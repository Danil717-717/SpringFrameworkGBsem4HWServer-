package ru.springGB.sem4HW.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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


    @Autowired
    public UserThymController(RegistrationService registrationService) {
        this.registrationService = registrationService;
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
        model.addAttribute("user", registrationService.getUserId(id));
        return "userProfile";
    }

    @GetMapping("/sort")
    public String sortUser(Model model){
        model.addAttribute("users", registrationService.sortUsers());
        return "redirect:users";
    }

    @GetMapping("/filter/{age}")
    public String filterUser(@PathVariable int age, Model model){
        model.addAttribute("users", registrationService.filterUsers(age));
        return "redirect:users";
    }



}
