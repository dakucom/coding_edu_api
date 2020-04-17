package com.dakuzai.edu.mapper;

import com.dakuzai.edu.entity.Course;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 课程 Mapper 接口
 * </p>
 *
 * @author Coding
 * @since 2020-04-05
 */
@Mapper
public interface CourseMapper extends BaseMapper<Course> {

}
