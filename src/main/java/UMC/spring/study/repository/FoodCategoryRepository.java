package UMC.spring.study.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import UMC.spring.study.domain.FoodCategory;

public interface FoodCategoryRepository extends JpaRepository<FoodCategory, Long> {
}
