package UMC.spring.study.service.StoreService;

import UMC.spring.study.domain.Mission;
import UMC.spring.study.domain.Review;
import UMC.spring.study.domain.Store;
import UMC.spring.study.web.dto.StoreRequestDTO;

public interface StoreCommandService {

    Review createReview(Long memberId, Long storeId, StoreRequestDTO.ReveiwDTO request);
    Store addStore(StoreRequestDTO.AddStoreDto request);
    Mission mission(Long storeId, StoreRequestDTO.MissionDTO request);

}
