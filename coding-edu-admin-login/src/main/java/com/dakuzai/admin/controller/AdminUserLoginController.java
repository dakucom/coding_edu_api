package com.dakuzai.admin.controller;
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

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *@program: coding_edu_api
 *@description: 与前端对接
 *@author: dakuzai
 *@create: 2020-04-17 19:42
 */
@Api(tags = "系统管理")
@RestController
@CrossOrigin
@RequestMapping("/admin/sysUser")
public class AdminUserLoginController {
}
