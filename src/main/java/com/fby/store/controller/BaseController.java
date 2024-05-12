package com.fby.store.controller;

import com.fby.store.service.ex.InsertException;
import com.fby.store.service.ex.ServiceException;
import com.fby.store.service.ex.UsernameOccupiedException;
import com.fby.store.util.JsonResult;
import org.springframework.web.bind.annotation.ExceptionHandler;

/** 控制层类的基类 */
public class BaseController {
    public static final int OK = 200;  //操作成功的状态码

    @ExceptionHandler(ServiceException.class)  // 用于统一处理抛出的异常(拦截异常),方法的返回值给到前端
    public JsonResult<Void> handleException(Throwable e){
        JsonResult<Void> result = new JsonResult<>(e);
        if (e instanceof UsernameOccupiedException){
            result.setState(4000);
            result.setMessage("用户名被占用");
        } else if (e instanceof InsertException) {
            result.setState(5000);
            result.setMessage("注册过程产生未知异常");
        }
        return result;
    }

}
