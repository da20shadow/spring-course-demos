package carsapp.carsbuysell.controllers;

import carsapp.carsbuysell.models.dtos.user.UserLoginDTO;
import carsapp.carsbuysell.models.dtos.user.UserRegisterDTO;
import carsapp.carsbuysell.models.entities.User;
import carsapp.carsbuysell.services.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/login")
    public String getLoginPage() {
        return "login";
    }

    @PostMapping("/login")
    public String postLoginPage(UserLoginDTO userLoginDTO) {

        boolean usernameExist = this.userService.findOneByUsername(userLoginDTO.getUsername());

        if (usernameExist){
            System.out.println("Successfully Logged in!");
            return "redirect:account";
        }
        System.out.println("An Error Occur!");
        return "redirect:login";
    }

    @GetMapping("/register")
    public String getRegisterPage() {
        return "register";
    }

    @PostMapping("/register")
    public String postRegisterPage(@ModelAttribute UserRegisterDTO userRegisterDTO) {
        User user = new User();
        user.setUsername(userRegisterDTO.getUsername());
        user.setEmail(userRegisterDTO.getEmail());
        user.setPassword(userRegisterDTO.getPassword());

        String result = this.userService.register(user);

        System.out.printf("Message: %s",result);
        return "redirect:login";
    }

    @GetMapping("/account")
    public String getAccountPage() {
        return "account";
    }
}
