package com.shangda.tourism.dao;

import com.shangda.tourism.model.User;

public interface UserDao {
    void insertUser(User user);

    User selectByUsername(String username);

    User selectById(int id);

    void updateStatus(int id,int status);

    User selectByCode(String code);

    User selectByEmail(String email);
}
