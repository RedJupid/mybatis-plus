//package com.xd.mybatisplus.config.security;
//
//import com.alibaba.fastjson.JSON;
//import com.xd.mybatisplus.entity.BaseResponse;
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.security.web.AuthenticationEntryPoint;
//
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
///**
// * @Author xd
// * @Description 它负责启动未经过身份验证的用户的身份验证过程(当他们试图访问受保护的资源
// * @Date 2019/6/5 11:35
// */
//public class MyAuthenticationEntryPoint implements AuthenticationEntryPoint {
//
//    @Override
//    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException e) throws IOException, ServletException {
//        response.setHeader("Content-Type", "application/json;charset=utf-8");
//        BaseResponse baseResponse = new BaseResponse(403,"无法访问该资源");
//        response.getWriter().write(JSON.toJSONString(baseResponse));
//        response.getWriter().flush();
//    }
//}
