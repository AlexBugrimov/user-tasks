package dev.bug.usertasks.view;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginEndpoint {

    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("userView", new UserView());
        return "login";
    }
}
