package bootstrap.service;

import bootstrap.model.Role;
import bootstrap.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {

    List<User> index();

    void create(User user);

    void update(int id, User user);

    void delete(int id);

    List<Role> listAllRoles();
}
