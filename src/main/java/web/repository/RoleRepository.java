package web.repository;

import org.springframework.data.repository.CrudRepository;
import web.model.Role;
import web.model.User;

public interface RoleRepository extends CrudRepository<Role, Long> {
}
