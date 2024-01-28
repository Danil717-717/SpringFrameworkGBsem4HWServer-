package ru.springGB.sem4HW.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.springGB.sem4HW.User;

import java.util.List;

@Service
public class RegistrationService {
    private final UserService userService;
    private final DataProcessingService processingService;
    private final NotificationService notificationService;

    @Autowired
    public RegistrationService(UserService userService, DataProcessingService processingService, NotificationService notificationService) {
        this.userService = userService;
        this.processingService = processingService;
        this.notificationService = notificationService;
    }

    public User acceptsData(String name, int age, String email) {
        User user = userService.createUser(name, age, email);
        processingService.addUser(user);
        return user;
    }

    public void saveUser(User user) {
        processingService.addUser(user);
    }

    public List<User> getUsers(){
        List<User> list = processingService.getAllUsers();
        notificationService.notifyListUser(list);
        return list;
    }

    public List<User> sortUsers(){
        List<User> list = processingService.getAllUsers();
        notificationService.notifySortListUser(list);
        return processingService.sortUserByAge(list);
    }

    public User getUserId(Long id){
        notificationService.notifyUserId(id);
        return processingService.getUserId(id);
    }

    public List<User> filterUsers(int age){
        List<User> list = processingService.getAllUsers();
        notificationService.notifyFilterListUser(list);
        return processingService.filterUserByAge(list,age);
    }

}
