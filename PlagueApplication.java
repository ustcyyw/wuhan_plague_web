package com.ustcyyw;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @Time : 2020年1月25日14:38:55
 * @Author : yyw@ustc
 * @E-mail : yang0@mail.ustc.edu.cn
 * @Github : https://github.com/ustcyyw
 * @desc : 启动类
 */
@SpringBootApplication
@EnableAsync
@EnableScheduling
public class PlagueApplication {
    public static void main(String[] args) {
        SpringApplication.run(PlagueApplication.class, args);
    }
}
