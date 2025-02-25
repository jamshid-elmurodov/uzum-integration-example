package uz.uzumintegrationexample.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.uzumintegrationexample.domain.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
}