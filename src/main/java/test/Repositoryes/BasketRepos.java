package test.Repositoryes;

import org.springframework.data.repository.CrudRepository;
import test.Entityes.Basket;
import test.Entityes.Product;
import test.Entityes.User;

import java.util.List;

public interface BasketRepos extends CrudRepository<Basket, Integer> {
    List<Basket> findBasketByUsername(String username);
    void deleteByUsername(String username);


}