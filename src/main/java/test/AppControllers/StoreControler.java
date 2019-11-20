package test.AppControllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import test.Entityes.Product;
import test.Entityes.User;
import test.Repositoryes.ProductRepos;
import test.Repositoryes.UserRepos;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Controller

public class StoreControler {
    @Autowired
    ProductRepos productRepos;
    @Autowired
    UserRepos userRepos;



    // страница приветствия, предлагает войти или зарегистрироваться
    @GetMapping("/")
    public String greeting(Map<String, Object> model) {

        return "hallopage";
    }

    @GetMapping("/main")
    public String listOfProducts(Model model) {

        Iterable<Product> products = productRepos.findAll();
        model.addAttribute("products", products);
        return "main";
    }

    // -добавляем продукиы, после добавления, видим отображение
    @GetMapping("/addProducts")
    public String addProducts(Model model) {
        Iterable<Product> products = productRepos.findAll();
        model.addAttribute("pro", products);
        return "addProduct";
    }

    @PostMapping("/addProducts")
    public String addProduct(@RequestParam String product_name, @RequestParam String category, @RequestParam String vendor,
                             @RequestParam String description, @RequestParam Double price, @RequestParam Integer discount,
                             @RequestParam Integer qty, Model model) {
        Product product = new Product(product_name, category, vendor, description, price, discount, qty);
        productRepos.save(product);
        Iterable<Product> products = productRepos.findAll();
        model.addAttribute("pro", products);

        return "addProduct";
    }
    // віводим свои данные
    @GetMapping("/myAccount/{user}")
    public String account(@PathVariable String user,Model model) {
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
        userRepos.save(user);
        model.addAttribute("myinfo",user);

        return "afteradd";


    }








}


