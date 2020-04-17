# 端口号
coding-edu-edu 8110

# 版本
+ SpringBoot 2.2.5
+ Swagger2
+ Mysql8
+ MyBatis Plus 3.0.5

# 状态码
+ SUCCESS(true,20000,"成功"),
+ UNKNOW_REASON(false,20001,"未知错误"),
+ BAD_SQL_GRAMMAR(false,21001,"sql语法错误"),
+ JSON_PARSE_ERROR(false,21002,"json 解析错误"),
+ PARAM_ERROR(false,21003,"参数不正确");

# 小提示
1. TeacherQuery中入驻时间开始与结束定义为String类型的原因：前端传递的数据不需要类型转换