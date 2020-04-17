package com.dakuzai.common.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;
/**
 * @program: coding_edu_api
 * @description: MyMetaObjectHandler 元对象处理
 * @author: dakuzai
 * @create: 2020-04-15 00:46
 */
@Component
public class MyMetaObjectHandler implements MetaObjectHandler {

    // 插入的策略
    @Override
    public void insertFill(MetaObject metaObject) {
        // this.setFieldValByName()设置当前字段的值！
        // String fieldName, Object fieldVal, MetaObject metaObject
        // 以后只要是插入操作就会自动控制
        // createTime updateTime 使用 new Date() 进行填充

        this.setFieldValByName("gmtCreate",new Date(),metaObject);
        this.setFieldValByName("gmtModified",new Date(),metaObject);
    }

    // 更新策略
    @Override
    public void updateFill(MetaObject metaObject) {
        this.setFieldValByName("gmtModified",new Date(),metaObject);
    }

}
