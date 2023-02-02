package pathfinder.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import pathfinder.models.dto.user.EditProfileDTO;
import pathfinder.models.dto.user.UserLoginDTO;
import pathfinder.models.dto.user.UserRegisterDTO;
import pathfinder.models.entity.User;
import pathfinder.services.UserService;

@Controller
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    private String getLoginPage(Model model) {
        model.addAttribute("error", "");
        return "login";
    }

    @PostMapping("/login")
    private String postLoginPage(UserLoginDTO userLoginDTO, Model model) {

        var result = this.userService.login(userLoginDTO.getUsername(),userLoginDTO.getPassword());

        if (result == null){
            model.addAttribute("error", "Bad credentials!");
            return "login";
        }

        return "redirect:profile";
    }

    @GetMapping("/register")
    private String getRegisterPage() {
        return "register";
    }

    @PostMapping("/register")
    private String postRegisterPage(UserRegisterDTO userRegisterDTO,Model model) {

        var resultUsername = this.userService.getUserByUsername(userRegisterDTO.getUsername());
        var resultEmail = this.userService.getUserByEmail(userRegisterDTO.getEmail());

        if (resultUsername != null || resultEmail != null){
            model.addAttribute("error", "Such username already registered!");
            return "register";
        }

        User user = this.userService.convertToEntity(userRegisterDTO);
        this.userService.register(user);

        return "redirect:login";
    }

    @GetMapping("/profile")
    private String getProfilePage(Model model) {
        User tempUser = this.userService.getUserByUsername("vipearn");
        model.addAttribute("user", tempUser);
        return "profile";
    }

    @GetMapping("/edit-profile")
    private String getEditProfilePage() {
        return "edit-profile";
    }

    @PostMapping("/edit-profile")
    private String postEditProfilePage(EditProfileDTO editProfileDTO) {
        //TODO: implement update profile
        System.out.println("New birth date: " + editProfileDTO.getAge());
        System.out.println("New email: " + editProfileDTO.getEmail());
        System.out.println("New pass: " + editProfileDTO.getPassword());
        return "edit-profile";
    }

}
