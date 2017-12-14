package cn.itcast.mybatis.utils;


import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.Reader;

/**
 * @Author: Gosin
 * @Date: 2017/12/12
 */
public class MyBatisUtil {
    //定义私有的sqlSessionFactory全局变量
    private static SqlSessionFactory sqlSessionFactory;
    static {
        try {
            //加载mybatis核心配置文件
            Reader reader = Resources.getResourceAsReader("mybatis.xml");
            //创建SqlSessionFactory会话工厂
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取SqlSessionFactory
     */
    public static SqlSessionFactory getSqlSessionFactory() {
        return sqlSessionFactory;
    }

    /**
     * 获取SqlSession
     */
    public static SqlSession getSession() {
        return sqlSessionFactory.openSession();
    }
}
