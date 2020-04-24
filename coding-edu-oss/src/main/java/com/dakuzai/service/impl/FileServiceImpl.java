package com.dakuzai.service.impl;
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

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.model.CannedAccessControlList;
import com.dakuzai.service.FileService;
import com.dakuzai.utils.ConstantProperties;
import org.joda.time.DateTime;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

/**
 * @program: coding_edu_api
 * @description: 文件业务实现类
 * @author: dakuzai
 * @create: 2020-04-23 11:33
 */
@Service
public class FileServiceImpl implements FileService {

    /**
     * @param multipartFile: io流
     * @Description: 上传文件到阿里云
     * @Author: dakuzai
     * @Date: 2020/4/23 11:35
     * @Return: java.lang.String
     */
    @Override
    public String uploadAliyun(MultipartFile multipartFile) {
        //基本配置，通过配置文件变化，不需要更改此处代码（降低耦合性）
        String endpoint = ConstantProperties.END_POINT;
        String accessKeyID = ConstantProperties.ACCESS_KEY_ID;
        String accessKeySecret = ConstantProperties.ACCESS_KEY_SECRET;
        String bucketName = ConstantProperties.BUCKET_NAME;
        String fileHost = ConstantProperties.FILE_HOST;
        //上传后返回的地址
        String uploadUrl = null;

        try {
            OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyID, accessKeySecret);
            //判断oss是否存在，不存在就创建
            if (!ossClient.doesBucketExist(bucketName)) {
                ossClient.createBucket(bucketName);//创建bucketName
                ossClient.setBucketAcl(bucketName, CannedAccessControlList.PublicRead);//设置权限
            }
            //获取文件上传流
            InputStream inputStream = multipartFile.getInputStream();
            //保存到oss路径（重写文件名、文件分类：上传文件的核心思想）
            String filePath = new DateTime().toString("yyy/MM/dd");
            //文件名（uuid的形式)
            String fileName = UUID.randomUUID().toString();
            String original = multipartFile.getOriginalFilename();
            //获取文件名后缀  .jpg、.png.....
            String fileType = original.substring(original.lastIndexOf("."));
            //创建自己的文件名
            String newName = fileName + fileType;
            //构建完整路径
            String fileUrl = fileHost + "/" + filePath + "/" + newName;

            //文件上传到阿里云
            ossClient.putObject(bucketName, fileUrl, inputStream);

            //关闭连接
            ossClient.shutdown();

            //获取上传后的文件地址
            uploadUrl = "https://" + bucketName + "." + endpoint + "/" + fileUrl;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return uploadUrl;
    }

}
