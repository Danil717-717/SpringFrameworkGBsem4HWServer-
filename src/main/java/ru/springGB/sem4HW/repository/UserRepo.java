package ru.springGB.sem4HW.repository;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import ru.springGB.sem4HW.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Component
public class UserRepo {


    private Map<Long, User> users = new ConcurrentHashMap<>();
    private AtomicLong counter = new AtomicLong();

    public List<User> getAllUsers() {
        return new ArrayList<>(users.values());
    }

    public User findById(Long id) {
        return users.get(id);
    }

    public User save(User user) {
        if (user.getId() == null) {
            //увеличивает каунтер на 1 и выводит его
            user.setId(counter.incrementAndGet());
        }
        users.put(user.getId(), user);
        return user;
    }

    public List<User> findAll() {
        return new ArrayList<>(users.values());
    }

}
