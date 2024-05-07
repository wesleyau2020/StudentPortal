package com.example.demo.user;

import java.util.List;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/v1/user")
public class UserController {

    private final CustomUserDetailsService customUserDetailsService;
    private BCryptPasswordEncoder encoder;

    // @Autowired
    public UserController(CustomUserDetailsService customUserDetailsService, BCryptPasswordEncoder encoder) {
        this.customUserDetailsService = customUserDetailsService;
        this.encoder = encoder;
    }

    @GetMapping
    public List<User> getAllUsers() {
        return customUserDetailsService.getAllUsers();
    }

    @PostMapping
    public User addUser(@RequestBody User user) {
        user.setPassword(encoder.encode(user.getPassword()));
        return customUserDetailsService.addNewUser(user);
    }
}
