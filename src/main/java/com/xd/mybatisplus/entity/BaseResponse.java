package com.xd.mybatisplus.entity;

import lombok.Data;

@Data
public class BaseResponse {

    private int code;
    private String msg;
    private Object data;
    private String token;


    public BaseResponse(int code, String msg, Object data, String token) {
        this.code = code;
        this.msg = msg;
        this.data = data;
        this.token = token;
    }

    public BaseResponse(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public BaseResponse(int code, String msg, String token) {
        this.code = code;
        this.msg = msg;
        this.token = token;
    }
}
