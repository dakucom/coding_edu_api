package com.dakuzai.edu.mapper;

import com.dakuzai.edu.entity.Teacher;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * 讲师 Mapper 接口
 * </p>
 *
 * @author dakuzai
 * @since 2020-04-05
 */
@Mapper
public interface TeacherMapper extends BaseMapper<Teacher> {

}
