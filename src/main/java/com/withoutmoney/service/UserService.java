package com.withoutmoney.service;

import com.withoutmoney.entity.User;
import com.withoutmoney.source.UserSource;


import java.sql.SQLException;
import java.util.List;

public class UserService {

    private final UserSource userSource;

    public UserService(UserSource userSource) {
        this.userSource = userSource;
    }


    public List<User> getPersonList() throws SQLException {
        return userSource.getPersonList();
    }

    public User show(int id) throws SQLException {
        return userSource.show(id);
    }

    public void save(User user) throws SQLException {
        userSource.save(user);
    }

    public void update(int id, User updatedUser) throws SQLException {
        userSource.update(id, updatedUser);
    }

    public void delete(int id) throws SQLException {
        userSource.delete(id);
    }

}
