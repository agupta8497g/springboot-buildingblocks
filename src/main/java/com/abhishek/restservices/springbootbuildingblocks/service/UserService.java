package com.abhishek.restservices.springbootbuildingblocks.service;

import com.abhishek.restservices.springbootbuildingblocks.model.User;
import com.abhishek.restservices.springbootbuildingblocks.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User create(User user) {
        userRepository.save(user);
        return user;
    }

    public User getUserById(Long id) {
        User user = userRepository.findById(id).get();
        return user;
    }

    public User updateUserByID(Long id, User user) {
        user.setId(id);
        userRepository.save(user);
        return user;
    }

    public void deleteUserById(Long id) {
        if(userRepository.findById(id).isPresent()) {
            userRepository.deleteById(id);
        }
    }

    public User getUserByName(String name) {
        return userRepository.findByUserName(name);
    }
}
