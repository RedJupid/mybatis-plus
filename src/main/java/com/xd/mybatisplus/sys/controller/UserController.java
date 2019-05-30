package com.xd.mybatisplus.sys.controller;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xd.mybatisplus.sys.entity.UserRole;
import com.xd.mybatisplus.sys.vo.UserRoleVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import org.springframework.beans.factory.annotation.Autowired;
import com.xd.mybatisplus.sys.service.IUserService;
import com.xd.mybatisplus.sys.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 *   @description : User 控制器
 *   ---------------------------------
 *   @author zxd
 *   @since 2019-05-30
 */
@Api(tags = {"系统用户表控制器"})
@RestController
@RequestMapping("/sys/user")
public class UserController {
private final Logger logger = LoggerFactory.getLogger(UserController.class);

@Autowired
public IUserService userService;


    @GetMapping("/withRoles")
    public List<UserRoleVO> withRoles(String name){
        return userService.selectWithRoles(name);
    }

    @GetMapping("/all")
    @ApiOperation(value = "获取所有系统用户表")
    public List<User> all(){
        return userService.list();
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "根据id获取系统用户表")
    public User getById(@PathVariable Integer id){
        return userService.getById(id);
    }

    @PostMapping
    @ApiOperation(value = "新增系统用户表")
    public Object add(@RequestBody User o){
        boolean flag = userService.save(o);
        String result = "";
        if(flag){
            result = "{\"code\":200,\"message\":\"处理成功\"}";
        }else{
            result = "{\"code\":500,\"message\":\"处理失败\"}";
        }
        return JSONObject.parseObject(result);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "根据id删除系统用户表")
    public Object delete(@PathVariable Integer id){
        boolean flag = userService.removeById(id);
        String result = "";
        if(flag){
        result = "{\"code\":200,\"message\":\"处理成功\"}";
        }else{
        result = "{\"code\":500,\"message\":\"处理失败\"}";
        }
        return JSONObject.parseObject(result);
    }

    @DeleteMapping("/ids")
    @ApiOperation(value = "批量删除系统用户表")
    public Object deleteIds(@RequestBody List<Integer> ids){
        boolean flag = userService.removeByIds(ids);
        String result = "";
        if(flag){
        result = "{\"code\":200,\"message\":\"处理成功\"}";
        }else{
        result = "{\"code\":500,\"message\":\"处理失败\"}";
        }
        return JSONObject.parseObject(result);
    }

    @PutMapping
    @ApiOperation(value = "更新系统用户表")
    public Object update(@RequestBody User o){
        boolean flag = userService.updateById(o);
        String result = "";
        if(flag){
        result = "{\"code\":200,\"message\":\"处理成功\"}";
        }else{
        result = "{\"code\":500,\"message\":\"处理失败\"}";
        }
        return JSONObject.parseObject(result);
    }

    @GetMapping("/page")
    @ApiOperation(value = "分页得到系统用户表")
    public IPage<User> page(String key, @RequestParam Integer current, @RequestParam Integer size){
        Page<User> page = new Page<>();
        page.setCurrent(current);
        page.setSize(size);
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("name", key);
        IPage<User> result;
        if(key!=null && key!=""){
            result = userService.page(page, queryWrapper);
        }else{
            result = userService.page(page, null);
        }
        return result;
    }
}




