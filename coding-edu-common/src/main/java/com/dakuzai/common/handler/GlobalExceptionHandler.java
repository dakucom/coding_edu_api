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
import com.dakuzai.common.vo.R;
import com.dakuzai.utils.ExceptionUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @program: coding_edu_api
 * @description: 统一异常处理器
 * @author: dakuzai
 * @create: 2020-04-16 18:28
 */
@ControllerAdvice //增强注解 属于AOP
@Slf4j
public class GlobalExceptionHandler {
    /**
     * @Description: @ExceptionHandler:异常处理处理器
     * Exception.class捕获Exception异常
     * Throwable   最大的异常捕获，包含 RuntimeException or Error or Exception,
     * @Author: dakuzai
     * @Date: 2020/4/16 22:40
     * @Return: com.coding.common.vo.R
     */
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public R erro(Exception e) {
        e.printStackTrace();
        return R.error();
    }

    /**
     * @param b:
     * @Description: 优先匹配精确异常
     * @Author: dakuzai
     * @Date: 2020/4/17 11:52
     * @Return: com.coding.common.vo.R
     */
    @ExceptionHandler(BadSqlGrammarException.class)
    @ResponseBody
    public R erro(BadSqlGrammarException b) {
        b.printStackTrace();
        return R.setResult(ResultCodeEnum.BAD_SQL_GRAMMAR);
    }

    /**
     * @param c:
     * @Description: 定义自己的统一异常
     * @Author: dakuzai
     * @Date: 2020/4/17 12:34
     * @Return: com.coding.common.vo.R
     */
    @ExceptionHandler(CodingException.class)
    @ResponseBody
    public R erro(CodingException c) {
//        e.printStackTrace();  默认的c
//        log.error(e.getMessage()); // 直接获取信息
        log.error(ExceptionUtil.getMessage(c));
        return R.error().message(c.getMessage()).code(c.getCode());
    }
}