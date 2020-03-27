package com.example.restfuldemo.config;

import com.example.restfuldemo.common.ExceptionType;
import com.example.restfuldemo.common.Result;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import java.lang.reflect.AnnotatedElement;
import java.util.Arrays;

/**
 * @author Lenovo
 */
@RestControllerAdvice("com.example.restfuldemo.controller")
public class ResultResponseAdvice implements ResponseBodyAdvice<Object> {

    private static final Class[] annos = {
            RequestMapping.class,
            GetMapping.class,
            PostMapping.class,
            DeleteMapping.class,
            PutMapping.class
    };

    @Override
    public boolean supports(MethodParameter returnType,
                            Class<? extends HttpMessageConverter<?>> converterType) {
        AnnotatedElement element = returnType.getAnnotatedElement();
        return Arrays.stream(annos).anyMatch(anno ->anno.isAnnotation()&&element.isAnnotationPresent(anno));
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType,
                                  MediaType mediaType,
                                  Class<? extends HttpMessageConverter<?>> selectedConverterType,
                                  ServerHttpRequest request,
                                  ServerHttpResponse response) {
        Object result = null;
        response.getHeaders().setContentType(MediaType.APPLICATION_JSON);
        if (body instanceof Result || body instanceof Byte || body instanceof String){
            result = body;
        }
        else if (body instanceof ExceptionType){
            ExceptionType errorCode = (ExceptionType) body;
            result = Result.fail(errorCode.getCode(),errorCode.getMsg(),"");
        }else {
            result = getWrapperResponse(request,body);
        }
        return result;

    }

    private Object getWrapperResponse(ServerHttpRequest request, Object data) {
        return Result.success(data);
    }
}
