package co.edu.poli.ces4.userservice.service;

import co.edu.poli.ces4.userservice.persistence.entity.User;

import java.util.List;

public interface UserService {
    List<User> findAll();
    void save(User user);
    void delete(User user);
    User findById(Long id);
}
