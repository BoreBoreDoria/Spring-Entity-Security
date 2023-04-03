package web.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import web.model.Role;
import web.model.User;

@Repository
public interface RoleRepository extends CrudRepository<Role, Long> {
}
