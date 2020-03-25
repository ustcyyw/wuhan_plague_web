package com.ustcyyw.Controller;

import com.ustcyyw.Service.TotalInfoServiceInterface;
import com.ustcyyw.vo.input.TotalTimeAtVo;
import com.ustcyyw.vo.input.TotalTimeBetweenVo;
import com.ustcyyw.vo.output.TotalInfoVo;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @Time : 2020年1月28日17:44:53
 * @Author : yyw@ustc
 * @E-mail : yang0@mail.ustc.edu.cn
 * @Github : https://github.com/ustcyyw
 * @desc : 全国疫情信息Controller
 */
@RestController // @ResponseBody的作用其实是将java对象转为json格式的数据。
@RequestMapping(path = "/total")
public class TotalInfoController extends BaseController {
    @Autowired
    private TotalInfoServiceInterface totalInfoService;

    @ApiOperation(value = "查询某时刻全国疫情信息接口，可选查询何类人数（默认为4种全部）")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "theTime", value = "指定时刻", required = false, dataType = "String"),
            @ApiImplicitParam(name = "givenType", value = "指定何类人", required = false, dataType = "String")
    })
    @GetMapping(value = "/timeAt")
    public Map<String, Object> getRecordingAt(@Validated TotalTimeAtVo vo, BindingResult br){
        if (br.hasErrors()) {
            return writeResult(99999, br.getAllErrors());
        }
        TotalInfoVo result = null;
        if(vo.getGivenType() == null)
            result = totalInfoService.getFourTypeNumAt(vo.getTheTime());
        else
            result = totalInfoService.getGivenTypeNumAt(vo.getTheTime(), vo.getGivenType());
        if(result == null)
            return writeResult(40001, null);
        return writeResult(0, result);
    }

    @ApiOperation(value = "查询某时段内全国疫情信息接口，可选查询何类人数（默认为4种全部）")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "start", value = "指定开始时刻", required = false, dataType = "String"),
            @ApiImplicitParam(name = "end", value = "指定结束时刻", required = false, dataType = "String"),
            @ApiImplicitParam(name = "givenType", value = "指定何类人", required = false, dataType = "String")
    })
    @GetMapping(value = "/timeBetween")
    public Map<String, Object> getRecordingBetween(@Validated TotalTimeBetweenVo vo, BindingResult br){
        if (br.hasErrors()) {
            return writeResult(99999, br.getAllErrors());
        }
        List<TotalInfoVo> result = null;
        if(vo.getGivenType() == null)
            result = totalInfoService.getFourTypeNumBetween(vo.getStart(), vo.getEnd());
        else
            result = totalInfoService.getGivenTypeNumBetween(vo.getStart(), vo.getEnd(), vo.getGivenType());
        if(result == null)
            return writeResult(40001, null);
        return writeResult(0, result);
    }
}
