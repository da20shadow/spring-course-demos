package pathfinder.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pathfinder.models.dto.route.view.MostCommentedRouteViewDTO;
import pathfinder.models.entity.User;
import pathfinder.services.RouteService;

@Controller
@RequestMapping("/")
public class StaticPageController {

    private final RouteService routeService;

    @Autowired
    public StaticPageController(RouteService routeService) {
        this.routeService = routeService;
    }

    @GetMapping
    public String getHomePage(Model model,
                              @CookieValue(name = "username",defaultValue = "")
                                      String username) {
        if (username.equals("")){
            return "redirect:login";
        }

        model.addAttribute("user", username);

        try {
            final MostCommentedRouteViewDTO mostCommentedRouteViewDTO =
                    routeService.getMostCommented();
            model.addAttribute("mostCommented", mostCommentedRouteViewDTO);
            System.out.println(mostCommentedRouteViewDTO.getName());
            System.out.println(mostCommentedRouteViewDTO.getDescription());
        } catch (Exception exception) {
            model.addAttribute("error", "No Routes yet!");
            System.out.println("No Routes Yet!");
        }
        return "index";
    }

    @GetMapping("about")
    public String getAboutPage(Model model,
                               @CookieValue(name = "username",defaultValue = "")
                                       String username) {
        if (username.equals("")){
            return "redirect:login";
        }

        model.addAttribute("user", username);
        return "about";
    }
}
