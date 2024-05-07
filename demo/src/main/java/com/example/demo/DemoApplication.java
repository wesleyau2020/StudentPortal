package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
// import org.springframework.context.ApplicationContext;
// import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

// import com.example.demo.user.User;
// import com.example.demo.user.UserRepository;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);

        // // JPA user repository init
        // ApplicationContext ctx = SpringApplication.run(DemoApplication.class, args);
        // UserRepository users = ctx.getBean(UserRepository.class);
        // BCryptPasswordEncoder encoder = ctx.getBean(BCryptPasswordEncoder.class);
        // System.out.println("[Add user]: "
        // + users.save(new User("myadmin", encoder.encode("goodpassword"),
        // "ROLE_ADMIN")).getUsername());
    }
}
