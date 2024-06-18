package co.edu.poli.ces4.userservice.service;

import co.edu.poli.ces4.userservice.persistence.entity.User;
import java.util.List;
import java.util.Optional;


public interface UserService {
    void save(User user);
    List<User> findAll();
    User getUserById(Long id);
    void deleteUser(Long userId);
}
