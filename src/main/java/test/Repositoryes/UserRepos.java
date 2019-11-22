package test.Repositoryes;
import org.springframework.data.repository.CrudRepository;
import test.Entityes.User;

import java.util.List;

public interface UserRepos extends CrudRepository<User, Integer> {
    User findByUsername(String username);
    List<User> findByUsernameEquals(String username);
    User findByIdEquals(Integer id);


}
