package com.example.demo.user;

import java.util.List;
import java.util.Optional;

// import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;

    // @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User addNewUser(User user) {
        Optional<User> optionalUser = userRepository.findUserByUsername(user.getUsername());

        if (optionalUser.isPresent()) {
            throw new IllegalStateException("Username: " + user.getUsername() + " already exists");
        }

        return userRepository.save(user);
    }
}
