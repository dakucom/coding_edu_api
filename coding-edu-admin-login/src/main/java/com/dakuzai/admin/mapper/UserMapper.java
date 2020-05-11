package com.dakuzai.admin.mapper;

import com.dakuzai.admin.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author dakuzai
 * @since 2020-04-18
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

}
