package hiber.service;

import hiber.model.User;

import java.util.List;

public interface UserService {
    void add(User user);
    List<User> listUsers();
    List<User> findUserByCarModelAndSeries(String model, int series);
}
