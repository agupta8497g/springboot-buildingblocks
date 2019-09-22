package com.abhishek.restservices.springbootbuildingblocks.service;

import com.abhishek.restservices.springbootbuildingblocks.exceptions.UserExistsException;
import com.abhishek.restservices.springbootbuildingblocks.exceptions.UserNotFoundException;
import com.abhishek.restservices.springbootbuildingblocks.model.User;
import com.abhishek.restservices.springbootbuildingblocks.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User create(User user) throws UserExistsException {
        User existingUser = userRepository.findByUserName(user.getUserName());
        if(existingUser!=null) {
            throw new UserExistsException("User already in repository");
        }
        userRepository.save(user);
        return user;
    }

    public Optional<User> getUserById(Long id) throws UserNotFoundException {
        Optional<User> user = userRepository.findById(id);
        if(!user.isPresent()) {
            throw new UserNotFoundException("User Not found in user repository");
        }
        return user;
    }

    public User updateUserByID(Long id, User user) throws UserNotFoundException {
        Optional<User> optionalUser = userRepository.findById(id);
        if(!optionalUser.isPresent()) {
            throw new UserNotFoundException("User Not found in user repository, provide correct userID");
        }
        user.setId(id);
        userRepository.save(user);
        return user;
    }

    public void deleteUserById(Long id) {
        Optional<User> optionalUser = userRepository.findById(id);
        if(!optionalUser.isPresent()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "User not found in repository, provide the correct user");
        }
        userRepository.deleteById(id);
    }

    public User getUserByName(String name) {
        return userRepository.findByUserName(name);
    }
}
