package com.dustin.mybatis;

import com.dustin.dao.*;
import com.dustin.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class MybatisMapperTest {
    private static SqlSessionFactory sqlSessionFactory = null;

    // 单例模式管理sqlSessionFactory,双重检索法
    public static SqlSessionFactory getSqlSessionFactory() {
        if (sqlSessionFactory == null) {
            synchronized (MybatisDaoTest.class) {
                if (sqlSessionFactory == null) {
                    try {
                        String resource = "SqlmapConfig.xml";

                        // 得到配置文件流
                        InputStream inputStream = null;
                        inputStream = Resources.getResourceAsStream(resource);

                        // 创建会话工厂，传入mybatis的配置文件信息
                        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder()
                                .build(inputStream);

                        return sqlSessionFactory;
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

        }
        return sqlSessionFactory;
    }

    @Test
    public void queryUserById() throws IOException {
        SqlSession sqlSession = getSqlSessionFactory().openSession();
        // 生成一个mapper代理对象
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = userMapper.queryUserById(1);
        System.out.println(user.getUsername());
    }

    @Test
    public void queryUserByUserQueryVOTest() throws IOException {
        SqlSession sqlSession = getSqlSessionFactory().openSession();
        // 生成一个mapper代理对象
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = new User();
        user.setSex("1");
        user.setUsername("Wangsw");
        UserQueryVo userQueryVo = new UserQueryVo();
        userQueryVo.setUser(user);
        List<Integer> ids = new ArrayList<Integer>(3);
        ids.add(100);
        ids.add(101);
        ids.add(102);
        userQueryVo.setIds(ids);
        List<UserCustomer>  userCustomers = userMapper.queryUserByUserQueryVo(userQueryVo);
        System.out.println(userCustomers);
    }
}
