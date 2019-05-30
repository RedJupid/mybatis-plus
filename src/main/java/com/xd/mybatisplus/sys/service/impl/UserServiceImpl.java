package com.xd.mybatisplus.sys.service.impl;

import com.xd.mybatisplus.sys.entity.User;
import com.xd.mybatisplus.sys.mapper.UserMapper;
import com.xd.mybatisplus.sys.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xd.mybatisplus.sys.vo.UserRoleVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 系统用户表 服务实现类
 * </p>
 *
 * @author zxd
 * @since 2019-05-30
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Override
    public List<UserRoleVO> selectWithRoles(String name) {
        return this.baseMapper.selectWithRoles(name);
    }
}
