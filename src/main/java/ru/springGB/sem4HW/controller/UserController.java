package ru.springGB.sem4HW.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.springGB.sem4HW.User;
import ru.springGB.sem4HW.repository.UserRepo;
import ru.springGB.sem4HW.service.RegistrationService;
import ru.springGB.sem4HW.service.UserRepoService;
import ru.springGB.sem4HW.service.UserService;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    private final UserService userService;
    private final RegistrationService registrationService;
    @Autowired
    private UserRepoService userRepoService;

    @Autowired
    public UserController(UserService userService, RegistrationService registrationService) {
        this.userService = userService;
        this.registrationService = registrationService;
    }

    @RequestMapping(value = "/adduser", method = RequestMethod.POST)
    public ResponseEntity<User> createUser(@RequestParam String name, @RequestParam int age, @RequestParam String email){
        return new ResponseEntity<>(registrationService.acceptsData(name,age,email), HttpStatus.CREATED);

    }

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public ResponseEntity<List<User>> getUsersList(){
        return new ResponseEntity<>(registrationService.getUsers(), HttpStatus.OK);
    }

    @RequestMapping(value = "/sort", method = RequestMethod.POST)
    public ResponseEntity<List<User>> sortUsers(){
        return new ResponseEntity<>(userRepoService.sortListUsers(), HttpStatus.OK);
    }

    @RequestMapping(value = "/filter/{age}", method = RequestMethod.GET)
    public ResponseEntity<List<User>> filterUsersByAge(@PathVariable("age") Integer age){
        return new ResponseEntity<>(userRepoService.filterListUsers(age),HttpStatus.OK);
    }

    @RequestMapping(value = "/average", method = RequestMethod.GET)
    public ResponseEntity<Double> average (){
        return new ResponseEntity<>(userRepoService.avgListUsers(),HttpStatus.OK);
    }



}
