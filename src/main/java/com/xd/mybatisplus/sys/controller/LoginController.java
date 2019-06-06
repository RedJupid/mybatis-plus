package com.xd.mybatisplus.sys.controller;

import com.alibaba.fastjson.JSON;
import com.xd.mybatisplus.entity.BaseResponse;
import com.xd.mybatisplus.sys.entity.User;
import com.xd.mybatisplus.util.JwtUtil;
import com.xd.mybatisplus.util.RedisUtil;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = {"登录控制器"})
@RestController
@RequestMapping("/auth")
public class LoginController {

    @Autowired
    JwtUtil jwtUtil;

    @Autowired
    RedisUtil redisUtil;

    /**
     * //有效期
     */
    @Value("${jwt.expiration}")
    private Long expiration;

    @PostMapping("/login")
    public BaseResponse login(String username, String password){
        if (password.equals("123456")){
            String token = jwtUtil.generateToken(username);
            User user = new User();
            user.setUsername(username);
            redisUtil.setExpire(token, JSON.toJSONString(user), expiration);
            return new BaseResponse(200,"登录成功", null, token);
        }else{
            return new BaseResponse(500,"登录失败");
        }
    }

}
