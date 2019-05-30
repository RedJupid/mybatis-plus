package com.xd.mybatisplus.sys.mapper;

import com.xd.mybatisplus.sys.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xd.mybatisplus.sys.vo.UserRoleVO;

import java.util.List;

/**
 * <p>
 * 系统用户表 Mapper 接口
 * </p>
 *
 * @author zxd
 * @since 2019-05-30
 */
public interface UserMapper extends BaseMapper<User> {

    List<UserRoleVO> selectWithRoles(String name);

}
