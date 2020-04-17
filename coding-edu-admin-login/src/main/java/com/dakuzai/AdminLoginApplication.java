package com.dakuzai;
/**
 * .::::.
 * .::::::::.
 * :::::::::::    永无Bug、阿门
 * ..:::::::::::'
 * '::::::::::::'
 * .::::::::::
 * '::::::::::::::..
 * ..::::::::::::.
 * ``::::::::::::::::
 * ::::``:::::::::'        .:::.
 * ::::'   ':::::'       .::::::::.
 * .::::'      ::::     .:::::::'::::.
 * .:::'       :::::  .:::::::::' ':::::.
 * .::'        :::::.:::::::::'      ':::::.
 * .::'         ::::::::::::::'         ``::::.
 * ...:::           ::::::::::::'              ``::.
 * ```` ':.          ':::::::::'                  ::::..
 * '.:::::'                    ':'````..
 **/

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 *@program: coding_edu_api
 *@description: 主启动器
 *@author: dakuzai
 *@create: 2020-04-17 19:45
 */
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class AdminLoginApplication {
    public static void main(String[] args) {
        SpringApplication.run(AdminLoginApplication.class,args);
    }
}
