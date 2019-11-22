package test.AppControllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import test.Entityes.Basket;
import test.Entityes.Product;
import test.Entityes.User;
import test.Repositoryes.BasketRepos;
import test.Repositoryes.ProductRepos;
import test.Repositoryes.UserRepos;

import java.util.*;

@Controller
public class BuyController {
    @Autowired
    UserRepos userRepos;
    @Autowired
    ProductRepos productRepos;
    @Autowired
    BasketRepos basketRepos;




    @GetMapping("/addToBasket/{product_id}/{username}")
    public String addToBasket(@PathVariable Integer product_id,
                              @PathVariable String username, Model model) {

        Basket basket = new Basket(username, product_id);
        basketRepos.save(basket);
        return "redirect:/main";
    }
    //очень корявый метод!!!!!!!!!!!!!!
    @GetMapping("/myBasket/{username}")
    public String myBasket(@PathVariable String username, Model model) {
        List<Product> products = new LinkedList<>();
        List<Basket>baskets=basketRepos.findBasketByUsername(username);
        for (Basket basket : baskets) {
                products.addAll(basket.getProducts());
            }
        model.addAttribute("mybasket", products);

        return "mybasket";
    }


    @GetMapping("/buyproducts/{username}")
    public String byProducts(@PathVariable String username, Model model){
        User user=userRepos.findByUsername(username);
        Double totalprice=0.0;
        List<Product> products = new LinkedList<>();
        List<Basket>baskets=basketRepos.findBasketByUsername(username);
        for (Basket basket : baskets) {
            products.addAll(basket.getProducts());
        }


        for (Product product:products){
            
            totalprice+=product.getPrice();

        }
        if (totalprice>user.getMoney()){
            //ЗАБОРЧИК НА ОТСУТСТВИЕ ДЕНЕГ
            return "buyproducts";
        }
        user.setMoney(user.getMoney()-totalprice);
        userRepos.save(user);
        for(Basket basket : baskets){
            basketRepos.delete(basket);
        }





        return "buyproducts";

    }
}


