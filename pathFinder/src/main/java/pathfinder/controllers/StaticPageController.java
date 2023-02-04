package pathfinder.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pathfinder.models.dto.route.view.MostCommentedRouteViewDTO;
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
    public String getHomePage(Model model){
        final MostCommentedRouteViewDTO mostCommentedRouteViewDTO =
                routeService.getMostCommented();
        model.addAttribute("mostCommented", mostCommentedRouteViewDTO);
        return "index";
    }

    @GetMapping("about")
    public String getAboutPage(){
        return "about";
    }
}
