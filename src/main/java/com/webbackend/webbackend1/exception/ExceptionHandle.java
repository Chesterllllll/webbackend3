package com.webbackend.webbackend1.exception;

import com.webbackend.webbackend1.Constant.ResponseEnums;
import com.webbackend.webbackend1.entity.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class ExceptionHandle {

    /**
     * @author jinhaoxun
     * @description 统一的异常处理方法
     * @param e 抛出的异常
     * @return 返回给前端的错误信息提示
     */
    @ExceptionHandler(value = Exception.class)
    public Response handleException(Exception e){
        if(e instanceof CustomerException) {
            CustomerException ex = (CustomerException)e;
            log.info("自定义业务异常：msg：" + ex.getMessage() + "，log：" + ex.getLog(), e);
            return Response.fail(ex.getCode(), ex.getMessage(),null);
        }else if(e instanceof MethodArgumentNotValidException) {
            MethodArgumentNotValidException ex = (MethodArgumentNotValidException)e;
            log.error("参数校验异常：msg：" + ex.getBindingResult().getFieldError().getDefaultMessage());
            return Response.fail(ResponseEnums.WRONG_PARAM.getCode(),
                    ResponseEnums.WRONG_PARAM.getMsg() + "："
                            + ex.getBindingResult().getFieldError().getDefaultMessage(), null);
        }else{
            log.error("统一系统异常：msg：" + e.getMessage(), e);
            return Response.fail(ResponseEnums.EXCEPTION.getCode(), ResponseEnums.EXCEPTION.getMsg(), null);
        }
    }

}

