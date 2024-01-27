package ru.springGB.sem4HW.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.springGB.sem4HW.User;
import ru.springGB.sem4HW.service.RegistrationService;
import ru.springGB.sem4HW.service.UserService;

@Controller
@RequestMapping("/users")
public class UserThymController {

    private final RegistrationService registrationService;
    private final UserService userService;

    @Autowired
    public UserThymController(RegistrationService registrationService, UserService userService) {
        this.registrationService = registrationService;
        this.userService = userService;
    }


    @GetMapping()
    public String index(Model model){
        model.addAttribute("users", registrationService.getUsers());
        return "users";
    }


    @GetMapping("/new")
    public String newUser(Model model){
        model.addAttribute("user", new User());
        return "new";
    }

    @PostMapping
    public String create(@ModelAttribute("user") User user){
        registrationService.saveUser(user);
        return "redirect:users";
    }

    @GetMapping("/{id}")
    public String getUser(@PathVariable Long id, Model model){
        //model.addAttribute("user", userService.getUserById(id));
        model.addAttribute("user", registrationService.getUserId(id));
        return "userProfile";
    }



}
