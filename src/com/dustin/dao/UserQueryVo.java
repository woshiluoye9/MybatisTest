package com.dustin.dao;

import java.util.List;

public class UserQueryVo {
    private List<Integer> ids;
    private User user;
    public List<Integer> getIds() {
        return ids;
    }

    public void setIds(List<Integer> ids) {
        this.ids = ids;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
