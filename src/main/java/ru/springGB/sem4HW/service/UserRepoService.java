package ru.springGB.sem4HW.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.springGB.sem4HW.User;
import ru.springGB.sem4HW.repository.UserRepo;

import java.util.List;

@Service
public class UserRepoService {
    private final UserRepo userRepo;
    private final DataProcessingService service;
    private final NotificationService notificationService;

    @Autowired
    public UserRepoService(UserRepo userRepo, DataProcessingService service, NotificationService notificationService) {
        this.userRepo = userRepo;
        this.service = service;
        this.notificationService = notificationService;
    }

    public List<User> sortListUsers() {
        List<User> listSort = service.sortUserByAge(userRepo.getAllUsers());
        notificationService.notifySortListUser(listSort);
        return listSort;
    }

    public List<User> filterListUsers(int age) {
        List<User> list = service.filterUserByAge(userRepo.getAllUsers(),age);
        notificationService.notifyFilterListUser(list);
        return list;
    }

    public double avgListUsers() {
        double avg = service.calculateAverageAge(userRepo.getAllUsers());
        notificationService.notifyAvgUser(avg);
        return avg;
    }
}
