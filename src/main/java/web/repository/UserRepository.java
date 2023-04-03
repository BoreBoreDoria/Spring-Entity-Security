package web.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import web.model.Role;
import web.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
  User findUserByEmail(String email);

  User findUserByNameAndEmail(String name, String email);

  List<User> findAllByNameContaining(String name);

  List<User> findAllByRole(Role role);

  boolean existsUserByNameAndPassword(String name, String password);

  User findUserByName(String name);
}
