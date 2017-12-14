package cn.itcast.mybatis.mapper;


import cn.itcast.mybatis.domain.User;

import java.util.List;
import java.util.Map;

/**
 * @Author: Gosin
 * @Date: 2017/12/13 22:28
 */
public interface UserMapper {
    /**
     * 根据用户名字模糊查询
     */
    List<User> getUserByName(User user);
    /**
     * 根据map查询数据
     */
    List<User> getUserByMap(Map<String,Object> dataMap);
    /**
     * 查询用户的总数
     */
    Integer getUserCount();
    /**
     * 根据id查询用户信息
     */
    User getUserById(Integer id);
    /**
     * choose 条件判断
     * 多查询用户
     */
    List<User> getUserByCondition(Map<String,Object> dataMap);
    /**
     * 修改用户信息
     */
    void updateUserById(User user);
    /**
     * 根据用户id集合获取用户信息
     */
    List<User> getUserByIdS(int[] ids);
}

