package com.dakuzai.edu.mapper;

import com.dakuzai.edu.entity.Chapter;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * 课程 Mapper 接口
 * </p>
 *
 * @author dakuzai
 * @since 2020-04-05
 */
@Mapper
public interface ChapterMapper extends BaseMapper<Chapter> {

}
