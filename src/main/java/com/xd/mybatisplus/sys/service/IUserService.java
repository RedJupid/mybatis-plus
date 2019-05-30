package com.xd.mybatisplus.sys.service;

import com.xd.mybatisplus.sys.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;
import com.xd.mybatisplus.sys.vo.UserRoleVO;

import java.util.List;

/**
 * <p>
 * 系统用户表 服务类
 * </p>
 *
 * @author zxd
 * @since 2019-05-30
 */
public interface IUserService extends IService<User> {

    List<UserRoleVO> selectWithRoles(String name);

}
