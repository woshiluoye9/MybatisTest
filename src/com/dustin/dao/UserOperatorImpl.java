package com.dustin.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class UserOperatorImpl implements UserOperation {
    private SqlSessionFactory sqlSessionFactory;
    public UserOperatorImpl(SqlSessionFactory sqlSessionFactory){
        this.sqlSessionFactory = sqlSessionFactory;
    }
    @Override
    public User queryUserById(int id) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        User user = sqlSession.selectOne("test.queryUserById",id);
        sqlSession.close();
        return user;

    }

    @Override
    public List<User> queryUserByName(String name) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        List<User> users = sqlSession.selectList("test.queryUserByName", "王五");
        sqlSession.close();
        return users;
    }

    @Override
    public void insertUser() {

    }

    @Override
    public void deleteUser() {

    }

    @Override
    public void modifyUser() {

    }
}
