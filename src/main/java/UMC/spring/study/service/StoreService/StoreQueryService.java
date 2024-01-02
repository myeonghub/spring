package UMC.spring.study.service.StoreService;

import UMC.spring.study.domain.Review;
import UMC.spring.study.domain.Store;
import org.springframework.data.domain.Page;
import java.util.Optional;


public interface StoreQueryService {

    Optional<Store> findStore(Long id);
    Page<Review> getReviewList(Long storeId, Integer page);
}
