package test.Repositoryes;
import org.springframework.data.repository.CrudRepository;
import test.Entityes.Category;


public interface CatRepos extends CrudRepository <Category, Integer>  {

}
