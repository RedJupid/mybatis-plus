package com.xd.mybatisplus.sys.vo;


import com.xd.mybatisplus.sys.entity.Role;
import lombok.Data;

import java.util.List;

@Data
public class UserRoleVO {

    private Integer uId;

    private String name;

    private Integer age;

    private String email;

    private List<Role> roles;
}
