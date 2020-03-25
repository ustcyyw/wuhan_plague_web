package com.ustcyyw.Controller;

import com.google.common.collect.ImmutableMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.ObjectError;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Time : 2020年1月28日17:09:25
 * @Author : yyw@ustc
 * @E-mail : yang0@mail.ustc.edu.cn
 * @Github : https://github.com/ustcyyw
 * @desc :
 */
public abstract class BaseController {
    @Autowired
    private ImmutableMap<String, String> errorCodeMap;

    public BaseController() {

    }

    protected Map<String, Object> writeResult(int errorCode, Object data) {
        if (errorCode == 0) {
            return ImmutableMap.of("errorCode", errorCode, "data", data == null ? "" : data);
        } else {
            String errorMsg = errorCodeMap.get(String.valueOf(errorCode));
            List<String> msgDetails = new ArrayList<>();
            if (data != null) {
                if (data instanceof String)
                    msgDetails.add((String) data);
                else if (data instanceof List) {
                    List<Object> errDetails = (List) data;

                    for (Object item : errDetails) {
                        if (item instanceof ObjectError) {
                            ObjectError error = (ObjectError) item;
                            errDetails.add(error.getDefaultMessage());
                        }
                    }
                }
            }
            return ImmutableMap.of("errorCode", errorCode, "msg", errorMsg, "details", msgDetails);
        }
    }
}
