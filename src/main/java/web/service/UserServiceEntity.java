package web.service;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.model.User;
import web.repository.UserRepository;

@Service
@RequiredArgsConstructor
@Transactional
public class UserServiceEntity {
  private final UserRepository repo;

  public List<User> listAll() {
    return (List<User>) repo.findAll();
  }

  public User getById(Long id) {
    return repo.findById(id).get();
  }

  public User saveUser(User user) {
    return repo.save(user);
  }

  public void updateUser(User user) {
    if (!repo.existsById(user.getId())) {
      throw new RuntimeException("Не удалось найти пользовтаеля с id:" + user.getId());
    }
    repo.save(user);
  }

  public User findByEmail(String email){
    return repo.findUserByEmail(email);
  }

  public User findUserByNameAndEmail(String name, String email){
    return repo.findUserByNameAndEmail(name, email);
  }

  public List<User> findAllByNameContaining(String name){
    return repo.findAllByNameContaining(name);
  }
}
