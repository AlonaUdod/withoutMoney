package com.withoutmoney.entity;

import com.withoutmoney.enums.Role;


import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "Ім’я не повинно бути порожнім")
    @Size(min = 2, max = 30, message = "Ім’я має містити від 2 до 30 символів")
    private String firstName;

    @NotEmpty(message = "Прізвище не повинно бути порожнім")
    @Size(min = 2, max = 30, message = "Ім’я має містити від 2 до 30 символів")
    private String lastName;

    @NotEmpty(message = "Електронна адреса не повинна бути пустою")
    @Email(message = "Некорректно введена електронна адреса")
    private String email;

    private Role role;

    @NotEmpty(message = "Пароль не повинен бути порожнім")
    @Size(min = 5, max = 30, message = "Пароль має містити від 5 до 30 символів")
    private String password;

    private String activationCode;

    public User() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getActivationCode() {
        return activationCode;
    }

    public void setActivationCode(String activationCode) {
        this.activationCode = activationCode;
    }



}
