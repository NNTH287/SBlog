package vn.edu.fpt.sblog_user_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.edu.fpt.sblog_user_service.entity.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    boolean existsByUsername(String username);
    Optional<User> findByUsername(String username);
}
