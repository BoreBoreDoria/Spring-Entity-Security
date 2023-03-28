package web.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import web.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
  User findUserByEmail(String email);

  User findUserByNameAndEmail(String name, String email);

  List<User> findAllByNameContaining(String name);
}
