package buysellcars.controllers;

import carsapp.carsbuysell.models.entities.User;
import carsapp.carsbuysell.services.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/adminpanel")
public class AdminPanelController {

    private final UserService userService;

    @Autowired
    public AdminPanelController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String getAdminDashboard(Model model){
        List<User> usersFromDB = userService.getAll();
        model.addAttribute("users",usersFromDB);
        return "adminDashboard";
    }
}
