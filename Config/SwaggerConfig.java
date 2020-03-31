package com.ustcyyw.Config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @Time : 2020年1月28日16:08:13
 * @Author : yyw@ustc
 * @E-mail : yang0@mail.ustc.edu.cn
 * @Github : https://github.com/ustcyyw
 * @desc : Swagger配置类 查询接口信息
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
    /**
     * 路径前缀
     */
    @Value("${server.context-path}")
    private String pathMapping;

    @Bean
    public Docket createApi() {
        return new Docket(DocumentationType.SWAGGER_2).groupName("PlagueInfoService")
                .apiInfo(getApiInfo())
                .select().apis(RequestHandlerSelectors.basePackage("com.ustcyyw.Controller"))
                .paths(PathSelectors.any())
                .build().pathMapping(pathMapping);
    }

    /**
     * api概要信息
     *
     * @return
     */
    private ApiInfo getApiInfo() {
        return new ApiInfoBuilder()
                .title("武汉新型冠状病毒疫情历史记录查询")
                .description("接口说明")
                .termsOfServiceUrl("https://github.com/ustcyyw")
                .contact(new Contact("yyw", "https://github.com/ustcyyw", "yang0@mail.ustc.edu.cn"))
                .version("1.0")
                .build();
    }
}
