package com.dakuzai.service;
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
 */

import org.springframework.web.multipart.MultipartFile;

/**
 *@program: coding_edu_api
 *@description: 文件业务
 *@author: dakuzai
 *@create: 2020-04-23 11:31
 */

public interface FileService {
    //文件上传到阿里云服务器
    String uploadAliyun(MultipartFile multipartFile);
    //删除文件
//    void delete(MultipartFile multipartFile);
}
