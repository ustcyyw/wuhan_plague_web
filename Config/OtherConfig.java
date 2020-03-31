package com.ustcyyw.Config;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.EncodedResource;
import org.springframework.core.io.support.PropertiesLoaderUtils;

import java.io.IOException;
import java.util.Properties;

/**
 * @Time : 2020年1月28日16:51:37
 * @Author : yyw@ustc
 * @E-mail : yang0@mail.ustc.edu.cn
 * @Github : https://github.com/ustcyyw
 * @desc :
 */
@Configuration
public class OtherConfig {
    /**
     * 初始化errormessage实例：读取error_code.properties文件中的数据初始化ErrorCodeMap实例
     *
     * @return
     */
    @Bean
    public ImmutableMap<String, String> errorCodeMap() {
        // errormessage map
        ImmutableMap<String, String> errorCodeMap = null;
        try {
            Properties properties = PropertiesLoaderUtils.loadProperties(new EncodedResource(new ClassPathResource("error_code.properties"), "UTF-8"));
            // 从properties文件中读取生成map
            errorCodeMap = Maps.fromProperties(properties);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return errorCodeMap;
    }
}
