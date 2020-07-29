package web.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import web.model.User;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Long> {
}
