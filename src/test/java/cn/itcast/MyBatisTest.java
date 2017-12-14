package cn.itcast;

import cn.itcast.mybatis.domain.User;
import cn.itcast.mybatis.mapper.UserMapper;
import cn.itcast.mybatis.utils.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: Gosin
 * @Date: 2017/12/14 10:23
 */
public class MyBatisTest {
    private UserMapper userMapper;
    private SqlSession sqlSession;

    @Before
    public void init() {
        sqlSession = MyBatisUtil.getSession();
        //获得UserMapper的代理对象
        userMapper = sqlSession.getMapper(UserMapper.class);
    }

    /**
     * 入参为javabean
     * 根据用户名模糊查询用户信息
     */
    @Test
    public void testGetUserByName() {
        User user = new User();
        user.setUsername("花");
        List<User> userNames = userMapper.getUserByName(user);
        for (User userName : userNames) {
            System.out.println(userName);
        }
    }
    /**
     * 入参为map
     * 根据map模糊查询用户
     */
    @Test
    public void testGetUserByMap() {
        //创建map，设置查询条件
        HashMap<String, Object> dataMap = new HashMap<>();
        dataMap.put("user_name","花");
        dataMap.put("userage",18);
        //执行查询
        List<User> users = userMapper.getUserByMap(dataMap);
        for (User user : users) {
            System.out.println(user);
        }
    }
    /**
     * 查询用户的总数
     */
    @Test
    public void testGetUserCount() {
        Integer userCount = userMapper.getUserCount();
        System.out.println("userCount:"+userCount);
    }
    /**
     * 根据id查询用户信息
     */
    @Test
    public void testGetUserByid() {
        User user = userMapper.getUserById(17);
        System.out.println(user);
    }

    @Test
    public void testGetUserByCondition() {
        HashMap<String,Object> dataMap = new HashMap<>();
       /* dataMap.put("userid",11);*/
        dataMap.put("user_name","花");
       /* dataMap.put("userage",18);*/
        List<User> users = userMapper.getUserByCondition(dataMap);
        for (User user : users) {
            System.out.println(user);
        }


    }

    /**
     * 修改用户信息
     */
    @Test
    public void testUpdateUserById() {
        User user = new User();
        user.setUsername("白白的包拯");
       /* user.setUserage(44);*/
        user.setUserid(19);
        userMapper.updateUserById(user);
        sqlSession.commit();
        sqlSession.close();
    }
    /**
     * 根据用户id集合获取用户信息
     */
    @Test
    public void testGetUserByIdS() {
        int[] ids = new int[3];
        ids[0] = 11;
        ids[1] = 12;
        ids[2] = 13;
        List<User> users = userMapper.getUserByIdS(ids);
        for (User user : users) {
            System.out.println(user);
        }
    }
}
