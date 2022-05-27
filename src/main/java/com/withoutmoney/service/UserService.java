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


    public List<User> getPersonList() {

        return userSource.getPersonList();

    }

    public User show(String email) throws SQLException {

        return userSource.show(email);

    }

    public void save(User user) {

        userSource.save(user);

    }

    public void update(String email, User updatedUser) {
        userSource.update(email, updatedUser);
    }

    public void delete(String email) throws SQLException {

        userSource.delete(email);

    }

}
