package ru.springGB.sem4HW.service;

import org.springframework.stereotype.Service;
import ru.springGB.sem4HW.User;

import java.util.List;

@Service
public class NotificationService {

    public void notifyCreatedUser(User user) {
        System.out.println("A new user has been created: " + user.getName());
    }

    public void notifyListUser(List<User> list) {
        System.out.println("The list Users: " + list);
    }

    public void notifySortListUser(List<User> list) {
        System.out.println("The list is sorted: " + list);
    }

    public void notifyFilterListUser(List<User> list) {
        System.out.println("The list is filtered " + list);
    }

    public void notifyAvgUser(double avg) {
        System.out.println("The avg age Users " + avg);
    }


}
