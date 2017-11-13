package com.dustin.mapper;

import com.dustin.dao.User;
import com.dustin.dao.UserCustomer;
import com.dustin.dao.UserQueryVo;

import java.util.List;

public interface UserMapper {
    User queryUserById(int id);
    List<UserCustomer> queryUserByUserQueryVo (UserQueryVo userQueryVo);
    List<User> queryUserByName(String name);
    void insertUser();
    void deleteUser();
    void modifyUser();
}
