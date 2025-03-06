package com.demo.practise.service.implementor;

import com.demo.practise.dto.UserDTO;
import com.demo.practise.entity.User;

import java.util.List;

public interface UserService {
    User createUser(UserDTO userDTO);
    List<User> getAllUsers();
    User getUserById(String id);
    User updateUserById(String id, UserDTO userDTO);
    User patchUserById(String id, UserDTO userDTO);
    void deleteUser(String id);
}
