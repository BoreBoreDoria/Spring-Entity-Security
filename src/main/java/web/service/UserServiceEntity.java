package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.model.Role;
import web.model.User;
import web.repository.RoleRepository;
import web.repository.UserRepository;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service

public class UserServiceEntity implements UserDetailsService {

    @Autowired
    UserRepository repo;
    @Autowired
    RoleRepository rolRepo;
    @Transactional
    public void save(User user) {
        Set<Role> roles = user.getRoles();
        if(roles == null) {
            roles = new HashSet<>();
            roles.add(rolRepo.findById(1L).get());
            user.setRoles(roles);
        }
        repo.save(user);
    }
    @Transactional
    public List<User> listAll() {
        return (List<User>) repo.findAll();
    }
    @Transactional
    public User get(long id) {
        return repo.findById(id).get();
    }
    @Transactional
    public void delete(long id) {
        repo.deleteById(id);
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        return listAll().stream()
                .filter(a -> username.equals(a.getName()))
                .findFirst()
                .orElse(null);
    }
}
