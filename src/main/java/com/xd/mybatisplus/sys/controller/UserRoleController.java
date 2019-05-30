package com.xd.mybatisplus.sys.controller;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import org.springframework.beans.factory.annotation.Autowired;
import com.xd.mybatisplus.sys.service.IUserRoleService;
import com.xd.mybatisplus.sys.entity.UserRole;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 *   @description : UserRole 控制器
 *   ---------------------------------
 *   @author zxd
 *   @since 2019-05-30
 */
@Api(tags = {"用户角色控制器"})
@RestController
@RequestMapping("/sys/user-role")
public class UserRoleController {
private final Logger logger = LoggerFactory.getLogger(UserRoleController.class);

@Autowired
public IUserRoleService userRoleService;




    @GetMapping("/all")
    @ApiOperation(value = "获取所有用户角色")
    public List<UserRole> all(){
        return userRoleService.list();
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "根据id获取用户角色")
    public UserRole getById(@PathVariable Integer id){
        return userRoleService.getById(id);
    }

    @PostMapping
    @ApiOperation(value = "新增用户角色")
    public Object add(@RequestBody UserRole o){
        boolean flag = userRoleService.save(o);
        String result = "";
        if(flag){
            result = "{\"code\":200,\"message\":\"处理成功\"}";
        }else{
            result = "{\"code\":500,\"message\":\"处理失败\"}";
        }
        return JSONObject.parseObject(result);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "根据id删除用户角色")
    public Object delete(@PathVariable Integer id){
        boolean flag = userRoleService.removeById(id);
        String result = "";
        if(flag){
        result = "{\"code\":200,\"message\":\"处理成功\"}";
        }else{
        result = "{\"code\":500,\"message\":\"处理失败\"}";
        }
        return JSONObject.parseObject(result);
    }

    @DeleteMapping("/ids")
    @ApiOperation(value = "批量删除用户角色")
    public Object deleteIds(@RequestBody List<Integer> ids){
        boolean flag = userRoleService.removeByIds(ids);
        String result = "";
        if(flag){
        result = "{\"code\":200,\"message\":\"处理成功\"}";
        }else{
        result = "{\"code\":500,\"message\":\"处理失败\"}";
        }
        return JSONObject.parseObject(result);
    }

    @PutMapping
    @ApiOperation(value = "更新用户角色")
    public Object update(@RequestBody UserRole o){
        boolean flag = userRoleService.updateById(o);
        String result = "";
        if(flag){
        result = "{\"code\":200,\"message\":\"处理成功\"}";
        }else{
        result = "{\"code\":500,\"message\":\"处理失败\"}";
        }
        return JSONObject.parseObject(result);
    }

    @GetMapping("/page")
    @ApiOperation(value = "分页得到用户角色")
    public IPage<UserRole> page(String key, @RequestParam Integer current, @RequestParam Integer size){
        Page<UserRole> page = new Page<>();
        page.setCurrent(current);
        page.setSize(size);
        QueryWrapper<UserRole> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("name", key);
        IPage<UserRole> result;
        if(key!=null && key!=""){
            result = userRoleService.page(page, queryWrapper);
        }else{
            result = userRoleService.page(page, null);
        }
        return result;
    }
}




