package com.example.library.user;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

@Configuration
public class UserConfig {

    private final PasswordEncoder passwordEncoder;

    public UserConfig(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Bean
    CommandLineRunner commandLineRunner2(UserRepository userRepository){
        return args -> {
            User admin = new User ("admin", passwordEncoder.encode("admin"),UserRole.ADMIN);
            User user = new User ("user", passwordEncoder.encode("user"), UserRole.USER);

            userRepository.saveAll(List.of(admin, user));
        };
    }
}