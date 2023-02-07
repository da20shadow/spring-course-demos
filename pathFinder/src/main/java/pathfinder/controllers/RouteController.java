package pathfinder.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/routes")
public class RouteController {

    @GetMapping
    public String getRoutesPage() {
        return "routes";
    }

    @GetMapping("/add")
    public String getAddRoutePage(Model model,
                                  @CookieValue(name = "username",defaultValue = "")
                                          String username) {
        if (username.equals("")){
            return "redirect:login";
        }

        model.addAttribute("user", username);
        return "add-route";
    }

    @PostMapping("/add")
    public String postAddRoutePage() {
        return "redirect:add-route";
    }
}
