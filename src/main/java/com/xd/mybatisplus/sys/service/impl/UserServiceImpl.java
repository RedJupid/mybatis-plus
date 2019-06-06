package com.xd.mybatisplus.sys.service.impl;

import com.xd.mybatisplus.sys.entity.User;
import com.xd.mybatisplus.sys.mapper.UserMapper;
import com.xd.mybatisplus.sys.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 系统用户表 服务实现类
 * </p>
 *
 * @author zxd
 * @since 2019-06-05
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
