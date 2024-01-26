package ru.springGB.sem4HW.repository;

import org.springframework.stereotype.Repository;
import ru.springGB.sem4HW.User;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepo {


    List<User> userList = new ArrayList<>();

    public List<User> getAllUsers(){
        return userList;
    }

    public void addUser(User user){
        userList.add(user);
    }
}
