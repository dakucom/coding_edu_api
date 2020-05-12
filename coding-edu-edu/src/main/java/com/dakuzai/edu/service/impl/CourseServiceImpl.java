package com.dakuzai.edu.service.impl;

import com.dakuzai.edu.entity.Course;
import com.dakuzai.edu.entity.CourseDescription;
import com.dakuzai.edu.form.CourseInfoForm;
import com.dakuzai.edu.mapper.CourseDescriptionMapper;
import com.dakuzai.edu.mapper.CourseMapper;
import com.dakuzai.edu.service.CourseDescriptionService;
import com.dakuzai.edu.service.CourseService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * 课程 服务实现类
 * </p>
 *
 * @author dakuzai
 * @since 2020-04-05
 */
@Transactional //事务
@Service
public class CourseServiceImpl extends ServiceImpl<CourseMapper, Course> implements CourseService {

    @Autowired
    private CourseDescriptionService courseDescriptionService;

    @Override
    public String saveCourseInfo(CourseInfoForm courseInfoForm) {

        //保存课程信息（Course）
        Course course = new Course();
        course.setStatus(Course.COURSE_DRAFT);
        BeanUtils.copyProperties(courseInfoForm, course);//将courseInfoForm数据复制到course中
        baseMapper.insert(course);


        //保存课程简介（CourseDescription）
        CourseDescription courseDescription = new CourseDescription();
        courseDescription.setDescription(courseInfoForm.getDescription());
        courseDescription.setId(course.getId());
        courseDescriptionService.save(courseDescription);
        return course.getId();
    }
}
