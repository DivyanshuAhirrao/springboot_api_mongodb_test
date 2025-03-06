package com.demo.practise.service.implementor;

import com.demo.practise.dto.UserDTO;
import com.demo.practise.entity.User;
import com.demo.practise.exception.ResourceNotFound;
import com.demo.practise.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImplementor implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public User createUser(UserDTO userDTO) {
        User user = new User();
        user.setName(userDTO.getName());
        user.setEmail(userDTO.getEmail());
        user.setAge(userDTO.getAge());
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(String id) {
        return userRepository.findById(id).orElseThrow(()-> new ResourceNotFound("User Not Found"));
    }

    @Override
    public User updateUserById(String id, UserDTO userDTO) {
        User existingUser = getUserById(id);
        existingUser.setName(userDTO.getName());
        existingUser.setEmail(userDTO.getEmail());
        existingUser.setAge(userDTO.getAge());
        return userRepository.save(existingUser);

    }

    @Override
    public User patchUserById(String id, UserDTO userDTO) {
        User existingUser = getUserById(id);
        if (existingUser.getName() != null) existingUser.setName(userDTO.getName());
        if (existingUser.getEmail() != null) existingUser.setEmail(userDTO.getEmail());
        if (existingUser.getAge() != 0) existingUser.setAge(userDTO.getAge());
        return userRepository.save(existingUser);
    }

    @Override
    public void deleteUser(String id) {
        getUserById(id);
        userRepository.deleteById(id);
    }
}
