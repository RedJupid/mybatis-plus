package com.xd.mybatisplus.sys.controller;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import org.springframework.beans.factory.annotation.Autowired;
import com.xd.mybatisplus.sys.service.IRoleService;
import com.xd.mybatisplus.sys.entity.Role;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 *   @description : Role 控制器
 *   ---------------------------------
 *   @author zxd
 *   @since 2019-05-30
 */
@Api(tags = {"系统角色控制器"})
@RestController
@RequestMapping("/sys/role")
public class RoleController {
private final Logger logger = LoggerFactory.getLogger(RoleController.class);

@Autowired
public IRoleService roleService;




    @GetMapping("/all")
    @ApiOperation(value = "获取所有系统角色")
    public List<Role> all(){
        return roleService.list();
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "根据id获取系统角色")
    public Role getById(@PathVariable Integer id){
        return roleService.getById(id);
    }

    @PostMapping
    @ApiOperation(value = "新增系统角色")
    public Object add(@RequestBody Role o){
        boolean flag = roleService.save(o);
        String result = "";
        if(flag){
            result = "{\"code\":200,\"message\":\"处理成功\"}";
        }else{
            result = "{\"code\":500,\"message\":\"处理失败\"}";
        }
        return JSONObject.parseObject(result);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "根据id删除系统角色")
    public Object delete(@PathVariable Integer id){
        boolean flag = roleService.removeById(id);
        String result = "";
        if(flag){
        result = "{\"code\":200,\"message\":\"处理成功\"}";
        }else{
        result = "{\"code\":500,\"message\":\"处理失败\"}";
        }
        return JSONObject.parseObject(result);
    }

    @DeleteMapping("/ids")
    @ApiOperation(value = "批量删除系统角色")
    public Object deleteIds(@RequestBody List<Integer> ids){
        boolean flag = roleService.removeByIds(ids);
        String result = "";
        if(flag){
        result = "{\"code\":200,\"message\":\"处理成功\"}";
        }else{
        result = "{\"code\":500,\"message\":\"处理失败\"}";
        }
        return JSONObject.parseObject(result);
    }

    @PutMapping
    @ApiOperation(value = "更新系统角色")
    public Object update(@RequestBody Role o){
        boolean flag = roleService.updateById(o);
        String result = "";
        if(flag){
        result = "{\"code\":200,\"message\":\"处理成功\"}";
        }else{
        result = "{\"code\":500,\"message\":\"处理失败\"}";
        }
        return JSONObject.parseObject(result);
    }

    @GetMapping("/page")
    @ApiOperation(value = "分页得到系统角色")
    public IPage<Role> page(String key, @RequestParam Integer current, @RequestParam Integer size){
        Page<Role> page = new Page<>();
        page.setCurrent(current);
        page.setSize(size);
        QueryWrapper<Role> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("name", key);
        IPage<Role> result;
        if(key!=null && key!=""){
            result = roleService.page(page, queryWrapper);
        }else{
            result = roleService.page(page, null);
        }
        return result;
    }
}




