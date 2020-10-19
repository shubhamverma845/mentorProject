package com.example.project.demo.Sirion.UserMicroservice.Service;

import com.example.project.demo.Sirion.UserMicroservice.Model.User;

import java.util.List;

public interface UserService {
    void createUser(User user);
    void deleteUserById(long id);
    List<User> getAllUser();
    User getUserById(long id);
}
