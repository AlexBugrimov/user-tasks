package dev.bug.usertasks.view;

import dev.bug.usertasks.usecase.SignUpUser;
import java.time.LocalDate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SignUpEndpoint {

    private final SignUpUser signUpUser;

    public SignUpEndpoint(SignUpUser signUpUser) {
        this.signUpUser = signUpUser;
    }

    @GetMapping("/signup")
    public String signUp(Model model) {
        model.addAttribute("userView", new UserView());
        return "signup";
    }

    @PostMapping("/signup")
    public String signUp(Model model, @ModelAttribute UserView userView) {
        signUpUser.execute(
            userView.getName(),
            userView.getUsername(),
            userView.getPhone(),
            userView.getEmail(),
            LocalDate.parse(userView.getBirthDate()),
            userView.getPassword()
        );
        return "redirect:/login";
    }
}
