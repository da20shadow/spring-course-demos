package battleship.controllers;

import battleship.models.binding.UserRegisterModel;
import battleship.services.AuthService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;

    @Autowired
    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @GetMapping("/register")
    public String getRegisterPage(){
        return "register";
    }

    @PostMapping("/register")
    public String postRegister(@Valid @ModelAttribute("userRegisterModel")UserRegisterModel userRegisterModel,
                               BindingResult bindingResult, RedirectAttributes redirectAttributes){

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("userRegisterModel", userRegisterModel)
                    .addFlashAttribute("org.springframework.validation.BindingResult.userRegisterModel", bindingResult);
            return "redirect:register";
        }

        this.authService.registerUser(userRegisterModel);

        return "redirect:login";
    }

    @GetMapping("/login")
    public String getLoginPage(){
        return "login";
    }

    //Model attributes
    @ModelAttribute(name = "userRegisterModel")
    public UserRegisterModel userRegisterModel(){
        return new UserRegisterModel();
    }
}
