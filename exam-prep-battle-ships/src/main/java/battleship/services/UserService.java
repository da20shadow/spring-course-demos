package battleship.services;

import battleship.models.UserModel;
import battleship.models.entities.User;
import battleship.repositories.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public UserService(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    public UserModel getUserByUsername(String username) {
        return this.modelMapper.map(this.userRepository.findByUsername(username).orElse(new User()), UserModel.class);
    }

    public UserModel getUserByEmail(String email) {
        return this.modelMapper.map(this.userRepository.findByUsername(email).orElse(new User()), UserModel.class);
    }

}
