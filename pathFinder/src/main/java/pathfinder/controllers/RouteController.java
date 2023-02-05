package pathfinder.controllers;

import org.springframework.stereotype.Controller;
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
    public String getAddRoutePage() {
        return "add-route";
    }

    @PostMapping("/add")
    public String postAddRoutePage() {
        return "add-route";
    }
}
