package com.example.library.user;

import com.example.library.book.Book;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> getUsers(){
        return userService.getUsers();
    }

    @GetMapping(path = "/{userId}")
    public User getUser(@PathVariable("userId") Long userId){
        return userService.getUsers().stream().filter(user -> userId.equals(user.getId()))
                .findFirst()
                .orElseThrow(() -> new IllegalStateException());
    }

    @DeleteMapping(path = "{userId}")
    public void deleteUser(@PathVariable("userId") Long userId){
        userService.deleteUser(userId);
    }
}
