package ru.springGB.sem4HW.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.springGB.sem4HW.service.DataProcessingService;
import ru.springGB.sem4HW.User;
import ru.springGB.sem4HW.service.NotificationService;

import java.util.List;

@Controller
@RequestMapping("/api")
public class DataProcessingController {

    private final DataProcessingService dataProcessingService;
    private NotificationService notificationService;

    @Autowired
    public DataProcessingController(DataProcessingService helloService) {
        this.dataProcessingService = helloService;
    }

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public ResponseEntity<String> hello(){
        String responce = this.dataProcessingService.getGreeting();
        return new ResponseEntity<>(responce, HttpStatus.OK);
    }



    @RequestMapping(value = "/sort", method = RequestMethod.POST)
    public ResponseEntity<List<User>> sortUsers(@RequestBody List<User> users){
        notificationService.notifySortListUser(users);
        return new ResponseEntity<>(dataProcessingService.sortUserByAge(users), HttpStatus.OK);
    }

    @RequestMapping(value = "/filter/{age}", method = RequestMethod.GET)
    public ResponseEntity<List<User>> filterUsersByAge(@PathVariable("age") Integer age, @RequestBody List<User> users){
        notificationService.notifyFilterListUser(users);
        return new ResponseEntity<>(dataProcessingService.filterUserByAge(users,age),HttpStatus.OK);
    }

    @RequestMapping(value = "/average", method = RequestMethod.POST)
    public ResponseEntity<Double> average (@RequestBody List<User> users){
        return new ResponseEntity<>(dataProcessingService.calculateAverageAge(users),HttpStatus.OK);
    }
}
