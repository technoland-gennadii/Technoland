package ru.buypos.technoland.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.buypos.technoland.jpa.UserRepository;
import ru.buypos.technoland.model.User;

@RestController
@RequestMapping("/api/v1")
public class RegistrationUser {

    @Autowired
    UserRepository userRepository;

    @PostMapping(path = "/registrationUser")
    public void registrationUser (@RequestBody User user) {
        userRepository.save(user);
    }
}
