package co.edu.poli.ces4.userservice.persistence.repository;

import co.edu.poli.ces4.userservice.persistence.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
