package com.dakuzai.edu.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dakuzai.edu.entity.Teacher;
import com.baomidou.mybatisplus.extension.service.IService;
import com.dakuzai.edu.dto.TeacherQuery;

/**
 * <p>
 * 讲师 服务类
 * </p>
 *
 * @author Coding
 * @since 2020-04-05
 */
public interface TeacherService extends IService<Teacher> {

    void pageQuery(Page<Teacher> pageParam, TeacherQuery teacherQuery);

}
