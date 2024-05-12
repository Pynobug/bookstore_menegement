package com.fby.store.controller;

import com.fby.store.entity.BaseEntity;
import com.fby.store.entity.User;
import com.fby.store.service.IUserService;
import com.fby.store.service.ex.InsertException;
import com.fby.store.service.ex.UsernameOccupiedException;
import com.fby.store.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("users")
public class UserController extends BaseController {
    @Autowired
    private IUserService userService;

    @RequestMapping("reg")
    // @ResponseBody --> Json
    public JsonResult<Void> reg(User user){
        userService.reg(user);
        return new JsonResult<>(OK);
    }
}
