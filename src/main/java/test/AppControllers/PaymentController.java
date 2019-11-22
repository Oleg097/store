package test.AppControllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import test.Entityes.User;
import test.Repositoryes.ProductRepos;
import test.Repositoryes.UserRepos;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PaymentController {
    @Autowired
    ProductRepos productRepos;
    @Autowired
    UserRepos userRepos;

    // віводим свои данные
    @GetMapping("/myAccount/{user}")
    public String account(@PathVariable String user, Model model) {
        Iterable<User>user1=userRepos.findByUsernameEquals(user);
        model.addAttribute("myinfo",user1);

        return "addmoney";
    }
    // метод добавление деней
    @PostMapping("/myAccount/{user}")
    public String myAccount(@RequestParam(name = "yourId") Integer yourId,
                            @RequestParam(name = "money") Integer money,Model model){
        User user=userRepos.findByIdEquals(yourId);
        user.setMoney(user.getMoney()+money);
        List<User> users=new ArrayList<>();
        users.add(user);
        userRepos.saveAll(users);
        model.addAttribute("myinfo",users);

        return "addmoney";

    }

}
