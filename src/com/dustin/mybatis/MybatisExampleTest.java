package com.dustin.mybatis;

import com.dustin.dao.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

public class MybatisExampleTest{
    public static SqlSession createSqlSession() throws IOException {
        // mybatis配置文件
        // 在此遇到一个问题，发现读取配置文件的时候读取不到，原因是idea的 classpath的问题，解决的方案
        // 可以在 http://blog.csdn.net/shifangwannian/article/details/48882201 找到解决方案
        String resource = "SqlmapConfig.xml";
        // 得到配置文件流
        InputStream inputStream = Resources.getResourceAsStream(resource);

        // 创建会话工厂，传入mybatis的配置文件信息
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder()
                .build(inputStream);

        // 通过工厂得到SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        return sqlSession;
    }
    @Test
    public void queryUserById() throws IOException {


        // 通过SqlSession操作数据库
        // 第一个参数：映射文件中statement的id，等于=namespace+"."+statement的id
        // 第二个参数：指定和映射文件中所匹配的parameterType类型的参数
        // sqlSession.selectOne结果 是与映射文件中所匹配的resultType类型的对象
        // selectOne查询出一条记录
        SqlSession sqlSession = createSqlSession();
        User user = sqlSession.selectOne("test.queryUserById", 1);

        System.out.println(user);

        // 释放资源
        sqlSession.close();
        System.out.println(user.getUsername());
    }

    @Test
    public void queryUserByName() throws IOException {

        SqlSession sqlSession = createSqlSession();

        // 通过SqlSession操作数据库
        // 第一个参数：映射文件中statement的id，等于=namespace+"."+statement的id
        // 第二个参数：指定和映射文件中所匹配的parameterType类型的参数
        // sqlSession.selectOne结果 是与映射文件中所匹配的resultType类型的对象
        // selectOne查询出一条记录
        List<User> user = sqlSession.selectList("test.queryUserByName", "王五");

        System.out.println(user);

        // 释放资源
        sqlSession.close();
        System.out.println(user.get(1).getUsername());
    }
    @Test
    public void insertUse() throws IOException {
        User user = new User();
        user.setUsername("Wangsw");
        user.setSex("1");
        user.setAddress("dalian");
        user.setBirthday(new Date());
        SqlSession sqlSession = createSqlSession();
        sqlSession.insert("test.insertUser", user);
        // 这里一定要显示的提交一下
        sqlSession.commit();
        sqlSession.close();
        System.out.println(user.getId()); // 返回的是真实插入数据库中的记录的Id

    }
}
