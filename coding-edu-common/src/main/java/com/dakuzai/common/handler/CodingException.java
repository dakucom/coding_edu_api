package com.dakuzai.common.handler;
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

import com.dakuzai.common.constants.ResultCodeEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @program: coding_edu_api
 * @description: 自定义异常处理
 * @author: dakuzai
 * @create: 2020-04-17 12:18
 */
@Data
@ApiModel(value = "全局异常")
public class CodingException extends RuntimeException {
    @ApiModelProperty(value = "状态码")
    private Integer code;

    //定义构造器

    /**
     * @param code:    状态码
     * @param message: 消息
     * @Description:接收自定义传递的状态码和消息
     * @Author: dakuzai
     * @Date: 2020/4/17 12:41
     * @Return:
     */
    public CodingException(Integer code, String message) {
        super(message);
        this.code = code;
    }

    /**
     * @param resultCodeEnum:
     * @Description: 接收枚举参数类型
     * @Author: dakuzai
     * @Date: 2020/4/17 12:26
     * @Return:
     */
    public CodingException(ResultCodeEnum resultCodeEnum) {
        super(resultCodeEnum.getMessage());
        this.code = resultCodeEnum.getCode();
    }

    @Override
    public String toString() {
        return "CodingException{" +
                "message"+this.getMessage()+
                "code=" + code +
                '}';
    }
}