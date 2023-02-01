package carsapp.carsbuysell.services.user;

import carsapp.carsbuysell.models.entities.User;

import java.util.List;

public interface UserService {
    String register(User user);
    boolean findOneByUsername(String username);
    List<User> getAll();
}
