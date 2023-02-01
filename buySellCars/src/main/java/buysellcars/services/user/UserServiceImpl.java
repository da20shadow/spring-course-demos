package buysellcars.services.user;

import carsapp.carsbuysell.models.entities.User;
import carsapp.carsbuysell.repositories.UserRepository;
import carsapp.carsbuysell.services.init.DbInitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService, DbInitService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void dbInit() {

    }

    @Override
    public boolean isDbInitialized() {
        return this.userRepository.count() > 0;
    }

    public String register(User user){
        var result = this.userRepository.save(user);
        System.out.println(result.getUsername());
        return "Successfully Registered!";
    }

    @Override
    public boolean findOneByUsername(String username) {
        return this.userRepository.findByUsername(username) != null;
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }
}
