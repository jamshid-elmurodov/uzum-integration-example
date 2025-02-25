package uz.uzumintegrationexample.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.uzumintegrationexample.domain.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
}