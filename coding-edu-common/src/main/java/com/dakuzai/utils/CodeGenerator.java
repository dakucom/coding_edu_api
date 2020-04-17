package com.dakuzai.utils;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.po.TableFill;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

import java.util.ArrayList;
/**
 * @program: coding_edu_api
 * @description: 自动生成代码
 * @author: dakuzai
 * @create: 2020-04-15 00:49
 */
public class CodeGenerator {

    public static void main(String[] args) {

        // 模块名
        String moduleName = "edu";

        // 1、代码生成器
        AutoGenerator mpg = new AutoGenerator();

        /**
         * 规则的配置
         * */
        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        // 获取当前项目的路径
        String projectPath = System.getProperty("user.dir");
        gc.setOutputDir(projectPath + "/coding-edu-edu/src/main/java");
        gc.setAuthor("dakuzai");
        gc.setOpen(false);
        // 不覆盖之前生成的文件！
        gc.setFileOverride(false);
        gc.setServiceName("%sService");
        // 主键策略
        gc.setIdType(IdType.ID_WORKER_STR);
        // 日期类型
        gc.setDateType(DateType.ONLY_DATE);
        // 自动开启Swagger配置！
        gc.setSwagger2(true);
        mpg.setGlobalConfig(gc);


        /**
         * 数据源配置
         */
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl("jdbc:mysql://localhost:3306/coding_"+moduleName+"?characterEncoding=utf-8&useSSL=false&serverTimezone=GMT%2B8");
        dsc.setDriverName("com.mysql.cj.jdbc.Driver");
        dsc.setUsername("root");
        dsc.setPassword("root");
        dsc.setDbType(DbType.MYSQL);
        mpg.setDataSource(dsc);


        /**
         *  包配置
         */
        PackageConfig pc = new PackageConfig();
        pc.setModuleName(moduleName);
        pc.setParent("com.coding");
        pc.setController("controller");
        pc.setService("service");
        pc.setEntity("entity");
        pc.setMapper("mapper");
        mpg.setPackageInfo(pc);

        /**
         * 策略配置
         */
        StrategyConfig strategy = new StrategyConfig();
        // 要生成哪一个表对应的类
        // ！！！所有edu 开头的表都自动生成！
        strategy.setInclude(moduleName+"_\\w*");
        // 数据库表生成到实体类的策略
        strategy.setNaming(NamingStrategy.underline_to_camel);
        // edu_ 这个前缀不生成在类中
        strategy.setTablePrefix(pc.getModuleName()+"_");
        //表的列规则：下划线转驼峰
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        // 自动生成lombok注解
        strategy.setEntityLombokModel(true);

        // 逻辑删除！
        strategy.setLogicDeleteFieldName("is_deleted");
        // 去掉布尔值的 is_前缀！
        strategy.setEntityBooleanColumnRemoveIsPrefix(true);

        // 自动填充
        TableFill gmt_create = new TableFill("gmt_create", FieldFill.INSERT);
        TableFill gmt_modified = new TableFill("gmt_modified", FieldFill.INSERT_UPDATE);
        ArrayList<TableFill> tableFills = new ArrayList<>();
        tableFills.add(gmt_create);
        tableFills.add(gmt_modified);
        strategy.setTableFillList(tableFills);

        // 乐观锁
        strategy.setVersionFieldName("version");
        // restful api
        strategy.setRestControllerStyle(true);
        //  /user/hello_name 使用_连接驼峰！
        strategy.setControllerMappingHyphenStyle(true);

        mpg.setStrategy(strategy);

        // 2、执行代码生成器
        mpg.execute();

    }
}
