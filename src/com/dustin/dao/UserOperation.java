package com.dustin.dao;

import java.util.List;

public interface UserOperation {
    User queryUserById(int id);
    List<User> queryUserByName(String name);
    void insertUser();
    void deleteUser();
    void modifyUser();
}
