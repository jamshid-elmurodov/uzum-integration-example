package uz.uzumintegrationexample.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.uzumintegrationexample.domain.entity.UzumTransaction;

public interface UzumTransactionRepository extends JpaRepository<UzumTransaction, String> {
}