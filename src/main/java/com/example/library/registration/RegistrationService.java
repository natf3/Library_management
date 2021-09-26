package com.example.library.registration;

import com.example.library.user.User;
import com.example.library.user.UserRole;
import com.example.library.user.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RegistrationService {

    private final UserService userService;
    public void register(RegistrationRequest request) {

        userService.signUpUser(new User(request.getUserName(), request.getUserName(), UserRole.USER));
    }
}
