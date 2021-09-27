package com.example.library.registration;

import com.example.library.user.User;
import com.example.library.user.UserRole;
import com.example.library.user.UserService;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {

    private final UserService userService;

    public RegistrationService(UserService userService) {
        this.userService = userService;
    }

    public void register(RegistrationRequest request) {

        userService.signUpUser(new User(request.getUsername(), request.getPassword(), UserRole.USER));
    }
}
