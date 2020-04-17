package com.dakuzai.utils;
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

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * @program: coding_edu_api
 * @description: 异常的处理类
 * @author: dakuzai
 * @create: 2020-04-17 13:36
 */
public class ExceptionUtil {
    /**
     * @param e:
     * @Description: 打印堆栈信息
     * @Author: dakuzai
     * @Date: 2020/4/17 13:47
     * @Return: java.lang.String
     */
    public static String getMessage(Exception e) {
        // 流
        StringWriter sw = null;
        PrintWriter pw = null;
        try {
            // 将出错的信息输出到输出流 PrintWriter！中
            sw = new StringWriter();
            pw = new PrintWriter(sw);
            e.printStackTrace(pw);
            pw.flush();
            sw.flush();
        } catch (Exception e1) {
            e1.printStackTrace();
        } finally {
            if (sw != null) {
                try {
                    sw.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
            if (pw != null) {
                pw.close();
            }
        }
        return sw.toString();
    }

}
