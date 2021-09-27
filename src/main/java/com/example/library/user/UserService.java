package com.example.library.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class UserService implements UserDetailsService{

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final static String USER_NOT_FOUND_MSG = "User not found";

    @Autowired
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public List<User> getUsers(){
        return userRepository.findAll();
    }

    public void deleteUser(Long userId) {
        boolean userExists = userRepository.existsById(userId);

        if(!userExists){
            throw new IllegalStateException("User does not exist");
        }
        userRepository.deleteById(userId);
    }

    public void signUpUser(User user) {
        boolean userExists = userRepository
                .findUserByUsername(user.getUsername())
                .isPresent();

        if (userExists) {
            throw new IllegalStateException("Username already taken");
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        userRepository.save(user);
    }

    public UserDetails loadUserByUsername(String username){
        return userRepository.findUserByUsername(username)
                .orElseThrow(() ->
                        new UsernameNotFoundException(
                                String.format(USER_NOT_FOUND_MSG)));
    }

}
