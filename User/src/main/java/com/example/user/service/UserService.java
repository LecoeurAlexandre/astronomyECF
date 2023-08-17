package com.example.user.service;

import com.example.user.entity.UserApp;
import com.example.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    public UserApp createUserApp(String name, String email) {
        UserApp userApp = UserApp.builder().name(name).email(email).build();
        userRepository.save(userApp);
        return userApp;
    }

    public UserApp getUserById(int id) {
        Optional<UserApp> userAppOptional = userRepository.findById(id);
        if(userAppOptional.isPresent()) {
            return userAppOptional.get();
        }
        throw new RuntimeException("Not found");
    }
}
