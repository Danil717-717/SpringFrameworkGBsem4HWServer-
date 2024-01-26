package ru.springGB.sem4HW.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.springGB.sem4HW.User;

@Service
public class UserService {

    private final NotificationService notificationService;


    @Autowired
    public UserService(NotificationService notificationService) {
        this.notificationService = notificationService;

    }

    @PostMapping
    public User createUser(@RequestParam("name") String name,
                           @RequestParam("age") int age,
                           @RequestParam("email") String email){

        User user = new User();
        user.setName(name);
        user.setAge(age);
        user.setEmail(email);

        notificationService.notifyCreatedUser(user);

        return user;
    }
}
