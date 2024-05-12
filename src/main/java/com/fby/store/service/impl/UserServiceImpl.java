package com.fby.store.service.impl;

import com.fby.store.entity.User;
import com.fby.store.mapper.UserMapper;
import com.fby.store.service.IUserService;
import com.fby.store.service.ex.InsertException;
import com.fby.store.service.ex.UsernameOccupiedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;
import sun.security.util.Password;

import java.util.Date;
import java.util.UUID;

@Service
/** 用户模块业务层接口的实现类 */
public class UserServiceImpl implements IUserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public void reg(User user){
        // 通过user参数来获取传递来的username
        String username = user.getUsername();
        // 调用findByUsername(username)判断用户是否被注册过
        User result = userMapper.findByUsername(username);
        // 判断result是不是null
        if (result != null){
            throw new UsernameOccupiedException("用户名被占用");
        }

        // 密码不能是明文，需要加密处理: md5算法的形式
        // 字符串（盐值 是随机的） + password + 字符串 --> 整体交给md5加密（一般连续加密三次）
        String oldPassword = user.getPassword();
        // 获取盐值（随机生成字符串）
        String salt = UUID.randomUUID().toString().toUpperCase();
        // 补全盐值
        user.setSalt(salt);
        // 将密码和盐值作为一个整体加密处理
        String md5Password = getMD5Password(oldPassword,salt);
        user.setPassword(md5Password);


        // 补全数据 is_delete设置为0
        user.setIsDelete(0);

        // 补全数据 四个日志字段信息
        user.setCreatUser(user.getUsername());
        user.setModifiedUser(user.getUsername());
        Date date = new Date();
        user.setCreatTime(date);
        user.setModifiedTime(date);

        // 执行注册的业务逻辑
        Integer rows = userMapper.insert(user);
        if (rows != 1){
            throw new InsertException("注册过程中产生了未知的异常");
        }
    }

    /** 定义md5算法加密处理 */
    private String getMD5Password(String password, String salt){
        // md5算法的调用
        for (int i = 0 ; i < 3; i++){
            password = DigestUtils.md5DigestAsHex((salt+password+salt).getBytes()).toUpperCase();
        }
        return password;
    }

}
