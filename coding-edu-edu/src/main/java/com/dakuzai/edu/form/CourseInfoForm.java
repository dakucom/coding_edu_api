package com.dakuzai.edu.form;
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

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @program: coding_edu_api
 * @description: 课程分类之课程基本信息
 * @author: dakuzai
 * @create: 2020-05-12 19:00
 */
@ApiModel(value = "课程基本信息", description = "编辑课程基本信息的表单对象")
@Data
public class CourseInfoForm implements Serializable {
    private static final long serialVersionUID = 1L;

    //属性
    @ApiModelProperty(value = "课程id")
    private String id;
    @ApiModelProperty(value = "课程讲师id")
    private String teacherId;
    @ApiModelProperty(value = "课程专业id")
    private String subjectId;
    @ApiModelProperty(value = "课程专业父级id")
    private String subjectParentId;
    @ApiModelProperty(value = "课程标题")
    private String title;
    @ApiModelProperty(value = "课程销售价格，如果为0，就代表可以免费观看")
    private BigDecimal price;
    @ApiModelProperty(value = "总课时")
    private Integer lessonNum;
    @ApiModelProperty(value = "课程封面图片路径")
    private String cover;
    @ApiModelProperty(value = "课程简介")
    private String description;
}
