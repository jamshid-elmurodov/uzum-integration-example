package uz.uzumintegrationexample.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.uzumintegrationexample.domain.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
}