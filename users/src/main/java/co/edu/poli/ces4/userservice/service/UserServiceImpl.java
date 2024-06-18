package co.edu.poli.ces4.userservice.service;

import co.edu.poli.ces4.userservice.Feign.BookingClient;
import co.edu.poli.ces4.userservice.persistence.entity.User;
import co.edu.poli.ces4.userservice.persistence.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BookingClient bookingClient;

    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Transactional
    @Override
    public void deleteUser(Long userId) {
        // Verificar si existen reservas asociadas al usuario
        Boolean hasBookings = bookingClient.existsByUserId(userId);
        if (hasBookings) {
            throw new RuntimeException("No se puede eliminar el usuario porque tiene reservas asociadas");
        }
        userRepository.deleteById(userId);
    }
}
