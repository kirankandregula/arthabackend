package com.artha.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.artha.entity.Users;
import com.artha.repository.UserRepository;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<Users> findAll() {
        return userRepository.findAll();
    }
    
    public Users addUser(Users users) {
    	return userRepository.save(users);
    }
    

}
