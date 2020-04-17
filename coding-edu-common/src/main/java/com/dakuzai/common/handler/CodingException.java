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
 *@program: coding_edu_api
 *@description: 全局异常
 *@author: dakuzai
 *@create: 2020-04-08 17:20
 */
@Data
@ApiModel(value = "全局异常")
public class CodingException extends RuntimeException {

    @ApiModelProperty(value = "状态码")
    private Integer code;

    /**
     * 接收自定传递的状态码和消息
     * @param code
     * @param message
     */
    public CodingException(Integer code, String message){
        super(message);
        this.code = code;
    }

    /**
     * 接收枚举类型参数
     */
    public CodingException(ResultCodeEnum resultCodeEnum){
        super(resultCodeEnum.getMessage());
        this.code = resultCodeEnum.getCode();
    }


    @Override
    public String toString() {
        return "CodingException{" +
                "message=" + this.getMessage() +
                "code=" + code +
                '}';
    }
}
