package com.xd.mybatisplus.sys.service.impl;

import com.xd.mybatisplus.sys.entity.Role;
import com.xd.mybatisplus.sys.mapper.RoleMapper;
import com.xd.mybatisplus.sys.service.IRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 系统角色 服务实现类
 * </p>
 *
 * @author zxd
 * @since 2019-05-30
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements IRoleService {

}
