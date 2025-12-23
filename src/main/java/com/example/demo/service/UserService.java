package com.example.demo.service;

import com.example.demo.entity.User;
import java.util.List;

public interface UserService {

    // 🔧 FIXED
    User createUser(User user);

    List<User> getAllUsers();
}
