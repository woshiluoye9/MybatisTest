package com.dustin.mybatis;

import com.dustin.dao.User;
import com.dustin.dao.UserOperation;
import com.dustin.dao.UserOperatorImpl;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MybatisDaoTest {
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
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        UserOperation userOperation = new UserOperatorImpl(sqlSessionFactory);
        User user = userOperation.queryUserById(1);
        System.out.println(user.getUsername());
    }
    @Test
    public void queryUserByName() throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        UserOperation userOperation = new UserOperatorImpl(sqlSessionFactory);
        List<User> users = userOperation.queryUserByName("王五");
        for (int i = 0; i < users.size(); i++){
            System.out.println(users.get(i).getUsername());
        }

    }
}
