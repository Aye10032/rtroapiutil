package com.aye10032.data;

import lombok.Getter;

/**
 * @program: rtroapi
 * @className: APIException
 * @Description: 异常处理
 * @version: v1.0
 * @author: Aye10032
 * @date: 2021/7/14 下午 5:23
 */
@Getter
public class APIException extends RuntimeException{
    private int code;
    private String msg;

    public APIException() {
        this(1001, "接口错误");
    }

    public APIException(String msg) {
        this(ResultCode.FAILED.getCode(), msg);
    }

    public APIException(int code, String msg) {
        super(msg);
        this.code = code;
        this.msg = msg;
    }
}
