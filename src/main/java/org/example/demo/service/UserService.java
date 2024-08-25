package org.example.demo.service;

import org.example.demo.dto.SaveUserDto;
import org.example.demo.model.User;
import org.example.demo.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Iterable<User> findAll() {
        return userRepository.findAll();
    }

    public SaveUserDto save(SaveUserDto user) {
        User userEntity = new User();
        userEntity.setEmail(user.getEmail());
        userEntity.setPassword(user.getPassword());
        userRepository.save(userEntity);
        return user;
    }

}
