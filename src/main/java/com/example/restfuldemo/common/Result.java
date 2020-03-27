package com.example.restfuldemo.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Lenovo
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result<T> {
    private int code = ExceptionType.SUCCESS.getCode();
    private String message = ExceptionType.SUCCESS.getMsg();
    //@NonNull
    private T data;

    public static Result<Object> success(){
        return success(null);
    }
    public static Result<Object> success(Object data){
        Result<Object> result = new Result<>();
        result.setCode(ExceptionType.SUCCESS.getCode());
        result.setMessage(ExceptionType.SUCCESS.getMsg());
        result.setData(data);
        return result;
    }
    public static Result<Object> fail(String msg){
        return fail(msg,null);
    }
    public static Result<Object> fail(String msg,Object data){
        return fail(ExceptionType.SERVER_ERROR.getCode(),msg,null);

    }
    public static Result<Object> fail(int code,String msg,Object data){
        Result<Object> result = new Result<>();
        result.setCode(code);
        result.setMessage(msg);
        result.setData(data);
        return result;
    }
}
