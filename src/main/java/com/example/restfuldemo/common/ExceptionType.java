package com.example.restfuldemo.common;

/**
 * @author Lenovo
 */

public enum ExceptionType {
    //系统基本码
    SUCCESS(200,"成功"),
    USER_INPUT_ERROR(400,"用户输入异常"),
    SERVER_ERROR(500,"系统服务异常"),
    NOT_FOUND_ERROR(404,"没找到"),
    OTHER_ERROR(999,"其他未知错误"),
    ;
    private int code;
    private String msg;

    ExceptionType(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
