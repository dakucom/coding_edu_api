package com.dakuzai.edu.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@ApiModel(value = "Teacher查询对象", description = "讲师查询对象封装")
@Data
public class TeacherQuery implements Serializable {

    private static final long serializableUID = 1L;

    @ApiModelProperty(value = "讲师名称,模糊查询")
    private String name;

    @ApiModelProperty(value = "头衔  1 高级讲师  2 顶级讲师")
    private Integer level;

    @ApiModelProperty(value = "入驻时间开始")
    private String begin; // String 类型，前端传递的数据不需要做类型转换！


    @ApiModelProperty(value = "入驻时间结束")
    private String end;


}



