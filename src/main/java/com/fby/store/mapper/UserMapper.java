package com.fby.store.mapper;

import com.fby.store.entity.User;
/** 用户模块的持久层接口 */
public interface UserMapper {
    /**
     * 插入用户的数据
     * @param user 用户的数据
     * @return 受影响的行数（增删改都有受影响的行数作为返回值，可以根据返回值判断是否执行成功）
     */
    Integer insert(User user);

    /**
     * 根据用户名查询用户的数据
     * @param username 用户名
     * @return 如果找到对应的用户，返回这个用户的数据，否则返回null
     */
    User findByUsername(String username);
}
