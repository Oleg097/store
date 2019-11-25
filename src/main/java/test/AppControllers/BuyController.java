package test.AppControllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.method.P;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import test.Entityes.Product;
import test.Entityes.User;
import test.Repositoryes.ProductRepos;
import test.Repositoryes.UserRepos;

import java.util.*;

@Controller
public class BuyController {
    @Autowired
    UserRepos userRepos;
    @Autowired
    ProductRepos productRepos;

    @GetMapping("/addToBasket/{product_id}/{username}")
    public String addToBasket(@PathVariable Integer product_id,
                              @PathVariable String username, Model model) {
        Optional<Product> product = productRepos.findById(product_id);
        Product product1 = product.get();
        User user = userRepos.findByUsername(username);
        List<Product> products = user.getBasket();

        products.add(product1);
        userRepos.save(user);

        return "redirect:/main";
    }

    //очень корявый метод!!!!!!!!!!!!!!
    @GetMapping("/myBasket/{username}")
    public String myBasket(@PathVariable String username, Model model) {
        User user = userRepos.findByUsername(username);
        List<Product> products = user.getBasket();
        model.addAttribute("mybasket", products);

        return "mybasket";
    }


    @GetMapping("/buyproducts/{username}")
    public String byProducts(@PathVariable String username, Model model) {
        User user = userRepos.findByUsername(username);

        Double totalprice = new Double(0.0);  //обозначаем переменную для сравнивания с балансом
        List<Product> products = user.getBasket();
        List<Product> productsWithDiscount = new LinkedList<>();
        List<Product> productsNoDiscount = new LinkedList<>();

        //корявый метод, много ифов
        for (Product product : products) {
            if (product.getDiscount() != null) {    // фильтруем на наличие скидок и добавляем в отдельній список
                productsWithDiscount.add(product);
            } else {productsNoDiscount.add(product);}
        }

        int cont = 0;
        if(productsWithDiscount!=null){
           productsWithDiscount.sort(Comparator.comparing(Product::getDiscount).reversed()); // упорядочиваем скидки по возрастанию
           for (Product p : productsWithDiscount) {
               if (cont<3){
                   totalprice += p.getPrice() - p.getDiscount();
                   cont++;
               }else{totalprice+=p.getPrice();}
           }
       }
        if (productsNoDiscount!=null) {
            for (Product p : productsNoDiscount) {
                totalprice += p.getPrice();

            }
        }

        if (totalprice > user.getMoney()) {
            //ЗАБОРЧИК НА ОТСУТСТВИЕ ДЕНЕГ
            return "havenomoney";
        } else {
            user.setMoney(user.getMoney() - totalprice);
            products.clear();
            user.setBasket(products);
            userRepos.save(user);
            return "buyedproducts";
        }


    }
}



