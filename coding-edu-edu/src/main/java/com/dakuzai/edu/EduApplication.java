package com.dakuzai.edu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @program: coding_edu_api
 * @description: 启动类
 * @author: dakuzai
 * @create: 2020-04-15 00:34
 */
@SpringBootApplication
@ComponentScan(basePackages = {"com.dakuzai.edu", "com.dakuzai.common"})
public class EduApplication {
    public static void main(String[] args) {
        SpringApplication.run(EduApplication.class, args);
    }
}
