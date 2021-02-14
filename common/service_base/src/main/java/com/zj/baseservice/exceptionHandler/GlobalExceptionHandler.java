package com.zj.baseservice.exceptionHandler;

import com.zj.baseservice.common.OutdoorException;
import com.zj.baseservice.common.R;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalExceptionHandler {

    // 全局异常处理
    @ResponseBody
    @ExceptionHandler(Exception.class)
    public R error(Exception e){
        e.printStackTrace();
        return R.error().message("捕捉到异常");
    }

    // 自定义异常
    @ResponseBody
    @ExceptionHandler(OutdoorException.class)
    public R error(OutdoorException e){
        e.printStackTrace();
        return R.error().message(e.getMsg());
    }
}
