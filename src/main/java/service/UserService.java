package service;

import entity.User;
import enums.Role;
import source.UserSource;

public class UserService {

    private final UserSource userSource;

    public UserService(UserSource userSource) {
        this.userSource = userSource;
    }

    public void addUser (String firstName, String lastName, String email,
                         Role role, String password, String activationCode){

        User user = new User(firstName,lastName, email, role, password, activationCode);
    }
}
