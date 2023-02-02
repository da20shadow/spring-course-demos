package pathfinder.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class StaticPageController {

    @GetMapping("about")
    public String getAboutPage(){
        return "about";
    }
}
