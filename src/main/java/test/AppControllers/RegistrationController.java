package test.AppControllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import test.Entityes.Role;
import test.Entityes.User;
import test.Repositoryes.UserRepos;
import java.util.Collections;

@Controller
public class RegistrationController {
    @Autowired
    private UserRepos userRepos;

    // ммэппинг на страницу регистрации
    @GetMapping("/registration")
    public String registration() {
        return "registration";
    }

    @PostMapping("/registration")
    public String addUser(User user, Model model) {
        User userFromDb = userRepos.findByUsername(user.getUsername());

        if (userFromDb != null) {
            model.addAttribute("message", "User exists!");
            return "registration";
        }

        user.setActive(true);
        user.setRoles(Collections.singleton(Role.USER));
        userRepos.save(user);

        return "redirect:/login";
    }
}
