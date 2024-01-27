package ru.springGB.sem4HW.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.springGB.sem4HW.User;
import ru.springGB.sem4HW.service.RegistrationService;

@Controller
@RequestMapping("/use")
public class UserThymController {

    private final RegistrationService registrationService;

    @Autowired
    public UserThymController(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }


    @GetMapping()
    public String index(Model model){
        model.addAttribute("user", registrationService.getUsers());
        return "index";
    }


    @GetMapping("/new")
    public String newUser(Model model){
        model.addAttribute("user", new User());
        return "new";
    }

    @PostMapping
    public String create(@ModelAttribute("user") User user){
        registrationService.saveUser(user);
        return "index";
    }

//    @GetMapping("/users")
//    public String getUsers(@ModelAttribute("users") User user){
//        registrationService.getUsers();
//        return "index";
//    }

}
