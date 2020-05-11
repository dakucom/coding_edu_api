package com.dakuzai.edu.controller.admin;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dakuzai.common.constants.ResultCodeEnum;
import com.dakuzai.common.handler.CodingException;
import com.dakuzai.common.vo.R;
import com.dakuzai.edu.dto.TeacherQuery;
import com.dakuzai.edu.entity.Teacher;
import com.dakuzai.edu.service.TeacherService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "讲师管理")
@RestController
@RequestMapping("/admin/edu/teacher")
@CrossOrigin // 跨域支持！
public class TeacherAdminController {
    // 以后我们要扩展接口或者编写业务，直接在这里进行编写即可！
    @Autowired
    private TeacherService teacherService;

    @ApiOperation(value = "获取讲师列表")
    @GetMapping
    public R list() {
        List<Teacher> list = teacherService.list(null);
        return R.ok().data("items", list);
    }

    @ApiOperation(value = "根据id删除讲师")
    @DeleteMapping("{id}")
    public R removeById(
            @ApiParam(name = "id", value = "讲师id", required = true)
            @PathVariable String id) {
        teacherService.removeById(id);
        return R.ok();
    }

    @ApiOperation(value = "新增讲师")
    @PostMapping
    public R save(
            @ApiParam(name = "teacher", value = "讲师对象", required = true)
            @RequestBody Teacher teacher) {
        teacherService.save(teacher);
        return R.ok();
    }


    @ApiOperation(value = "根据id查询讲师")
    @GetMapping("{id}")
    public R getById(
            @ApiParam(name = "id", value = "讲师id", required = true)
            @PathVariable String id) {
        Teacher teacher = teacherService.getById(id);
        return R.ok().data("item", teacher);
    }


    @ApiOperation(value = "根据id修改讲师信息")
    @PutMapping("{id}")
    public R updateById(
            @ApiParam(name = "id", value = "讲师id", required = true)
            @PathVariable String id,
            @ApiParam(name = "teacher", value = "讲师", required = true)
            @RequestBody Teacher teacher) {

        teacher.setId(id);
        teacherService.updateById(teacher);
        return R.ok().data("item", teacher);
    }

    @ApiOperation(value = "列表分页实现")
    @GetMapping("{page}/{pageSize}")
    public R pageList(
            @ApiParam(name = "page", value = "当前页码", required = true)
            @PathVariable Long page,
            @ApiParam(name = "pageSize", value = "每页记录数", required = true)
            @PathVariable Long pageSize,
            @ApiParam(name = "teacherQuery", value = "查询对象", required = false)
                    TeacherQuery teacherQuery) {

        // 统一异常的好处，所有开发人员协同的时候，可以保证整个错误结构是一致！
        if (page <= 0 || pageSize <= 0) {
//            throw new CodingException(21003,"参数不正确1");
            throw new CodingException(ResultCodeEnum.PARAM_ERROR); // 推荐使用
        }

        // 业务逻辑
        Page<Teacher> pageParam = new Page<>(page, pageSize);
        // 使用我们自己扩展的查询方法即可！
        teacherService.pageQuery(pageParam, teacherQuery);
        // 结果封装
        List<Teacher> records = pageParam.getRecords();
        long total = pageParam.getTotal();// 总页数

        return R.ok().data("total", total).data("rows", records);
    }

}
