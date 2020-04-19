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

import com.dakuzai.admin.entity.User;
import com.dakuzai.admin.service.UserService;
import com.dakuzai.common.vo.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 *@program: coding_edu_api
 *@description: 与前端对接
 *@author: dakuzai
 *@create: 2020-04-17 19:42
 */
@Api(tags = "系统管理")
@RestController
@CrossOrigin
@RequestMapping("/admin/sysuser")
public class AdminUserLoginController {

    @Autowired
    private UserService userService;

    @ApiOperation(value = "用户登录")
    @PostMapping("login")
    public R login(
            @ApiParam(name = "sysUser",value = "系统用户",required = true)
            @RequestBody User sysUser){
        // 用户业务逻辑（数据库中校验）
        User user = userService.getOne(null);
        String name = user.getName();
        return R.ok().data("token",name);
    }

    @GetMapping("info")
    @ApiOperation(value = "获取用户信息")
    public R info(
            @ApiParam(name = "token",value = "令牌",required = true)
            @RequestParam String token){
//      // 正常逻辑 从 token 中获取角色
        return R.ok()
                .data("roles",token)
                .data("name","dakuzai")
                .data("avatar","https://www.icodingedu.com/files/system/2019/09-25/221140c88a92856833.jpg");
    }

    @PostMapping("logout")
    @ApiOperation(value = "退出登录")
    public R logout(){
        return R.ok();
    }

}
