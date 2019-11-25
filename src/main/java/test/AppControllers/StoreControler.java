package test.AppControllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import test.Entityes.Discount;
import test.Entityes.Product;
import test.Repositoryes.DisRepos;
import test.Repositoryes.ProductRepos;
import test.Repositoryes.UserRepos;

import java.util.*;

@Controller

public class StoreControler {
    @Autowired
    ProductRepos productRepos;
    @Autowired
    UserRepos userRepos;
    @Autowired
    DisRepos disRepos;



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
                             @RequestParam String description, @RequestParam Double price, @RequestParam Double discount,
                             Model model) {
        Product product = new Product(product_name, category, vendor, description, price, discount);


        productRepos.save(product);
        // если сумма скидки указана - создаем скидку
        if (discount!=null){
            Discount discount1=new Discount(discount,product.getProduct_id());
            disRepos.save(discount1);
        }
        Iterable<Product> products = productRepos.findAll();

        model.addAttribute("pro", products);

        return "addProduct";
    }

}


