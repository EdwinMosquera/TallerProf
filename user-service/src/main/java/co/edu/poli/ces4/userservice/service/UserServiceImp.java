package co.edu.poli.ces4.userservice.service;

import co.edu.poli.ces4.userservice.persistence.entity.User;
import co.edu.poli.ces4.userservice.persistence.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImp implements UserService {

    private final UserRepository repository;

    @Override
    @Transactional(readOnly = true)
    public List<User> findAll() {
        return repository.findAll();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void save(User user) {
        repository.save(user);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(User user) {
        repository.delete(user);
    }

    @Override
    public User findById(Long id) {
        return repository.findById(id).orElse(null);
    }
}
