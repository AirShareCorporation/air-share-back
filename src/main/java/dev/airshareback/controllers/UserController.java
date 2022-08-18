package dev.airshareback.controllers;

import dev.airshareback.controllers.dto.UserDto;
import dev.airshareback.entities.User;
import dev.airshareback.services.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(allowCredentials = "true", origins = "http://localhost:4200/")
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("users")
    public List<User> clients() {
        return this.userService.list();
    }

    @GetMapping("users/{id}")
    public Optional<User> get(@PathVariable Long id) {
        return this.userService.get(id);
    }

    @PostMapping("users")
    public User create(@RequestBody UserDto userDto) {
        return this.userService.create(userDto);
    }
}
