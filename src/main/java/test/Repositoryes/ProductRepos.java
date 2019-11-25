package test.Repositoryes;

import org.springframework.data.repository.CrudRepository;
import test.Entityes.Product;

import java.util.List;


public interface ProductRepos extends CrudRepository<Product, Integer> {




}


