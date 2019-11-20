package test.Repositoryes;
import org.springframework.data.repository.CrudRepository;
import test.Entityes.Discount;

public interface DisRepos  extends CrudRepository<Discount, Integer> {
}
