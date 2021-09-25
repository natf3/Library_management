package com.example.library.user;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class UserConfig {

    @Bean
    CommandLineRunner commandLineRunner(UserRepository userRepository){
        return args -> {
            User admin = new User ("admin@gmail.com", "haslo123",UserRole.ADMIN);
            User user = new User ("user@gmail.com", "haslo123", UserRole.USER);

            userRepository.saveAll(List.of(admin, user));
        };
    }
}
