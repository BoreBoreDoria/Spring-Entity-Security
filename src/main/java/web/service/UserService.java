package web.service;

import java.util.List;
import web.model.User;

public interface UserService {
  void save(User user);

  List<User> listAll();

  User get(long id);

  void delete(long id);
}
