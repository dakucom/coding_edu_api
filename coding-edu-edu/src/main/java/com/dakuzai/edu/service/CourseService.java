package com.dakuzai.edu.service;

import com.dakuzai.edu.entity.Course;
import com.baomidou.mybatisplus.extension.service.IService;
import com.dakuzai.edu.form.CourseInfoForm;

/**
 * <p>
 * 课程 服务类
 * </p>
 *
 * @author dakuzai
 * @since 2020-04-05
 */
public interface CourseService extends IService<Course> {
    //保存课程信息
    String saveCourseInfo(CourseInfoForm courseInfoForm);
}
