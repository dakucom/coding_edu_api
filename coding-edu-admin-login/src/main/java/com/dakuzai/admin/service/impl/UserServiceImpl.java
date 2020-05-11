package com.dakuzai.admin.service.impl;

import com.dakuzai.admin.entity.User;
import com.dakuzai.admin.mapper.UserMapper;
import com.dakuzai.admin.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author dakuzai
 * @since 2020-04-18
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
