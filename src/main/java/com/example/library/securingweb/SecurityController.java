package com.example.library.securingweb;

import com.example.library.user.User;
import com.example.library.user.UserRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;

import java.util.Optional;

@Controller
public class SecurityController {

    private final UserRepository userRepository;

    public SecurityController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User getCurrentUser() {
         String currentUsername = SecurityContextHolder.getContext().getAuthentication().getName();
         Optional<User> optionalUser =  userRepository.findUserByUsername(currentUsername);
         User user = optionalUser.get();

         return user;
    }
}