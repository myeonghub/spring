package UMC.spring.study.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import UMC.spring.study.domain.Review;
import UMC.spring.study.domain.Store;

public interface StoreRepository extends JpaRepository<Store, Long> {
}
