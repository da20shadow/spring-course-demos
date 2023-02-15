package battleship.services;

import battleship.models.binding.UserLoginModel;
import battleship.models.binding.UserRegisterModel;
import battleship.models.entities.User;
import battleship.models.helpers.LoggedUser;
import battleship.repositories.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final LoggedUser loggedUser;

    @Autowired
    public AuthService(UserRepository userRepository, ModelMapper modelMapper, LoggedUser loggedUser) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.loggedUser = loggedUser;
    }

    public void registerUser(UserRegisterModel userRegisterModel) {
        User user = this.userRepository.saveAndFlush(this.modelMapper.map(userRegisterModel, User.class));
        this.loggedUser.setId(user.getId());
    }

    public void loginUser(UserLoginModel userLoginModel) {
        Optional<User> user = this.userRepository.findByUsername(userLoginModel.getUsername());

    }

    public void logoutUser(){
        this.loggedUser.clearUser();
    }
}
