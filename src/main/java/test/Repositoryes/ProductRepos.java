package test.Repositoryes;

import org.springframework.data.repository.CrudRepository;
import test.Entityes.Product;


public interface ProductRepos extends CrudRepository<Product, Integer> {

}


