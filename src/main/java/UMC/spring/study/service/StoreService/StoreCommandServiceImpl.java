package UMC.spring.study.service.StoreService;

import UMC.spring.study.domain.Mission;
import UMC.spring.study.domain.Store;
import UMC.spring.study.repository.MissionRepository;
import UMC.spring.study.service.MemberService.MemberQueryService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import UMC.spring.study.converter.StoreConverter;
import UMC.spring.study.domain.Review;
import UMC.spring.study.repository.MemberRepository;
import UMC.spring.study.repository.ReviewRepository;
import UMC.spring.study.repository.StoreRepository;
import UMC.spring.study.web.dto.StoreRequestDTO;

@Service
@Transactional
@RequiredArgsConstructor
public class StoreCommandServiceImpl implements StoreCommandService{

    private final ReviewRepository reviewRepository;

    private final MemberQueryService memberQueryService;

    private final StoreRepository storeRepository;

    private final MissionRepository missionRepository;

    @Override
    public  Review createReview(Long memberId, Long storeId, StoreRequestDTO.ReveiwDTO request) {

        Review review = StoreConverter.toReview(request);

        review.setMember(memberQueryService.findMember(memberId).get()); // 이둘이 ㅇ하나는 쿼리서비스고
        review.setStore(storeRepository.findById(storeId).get()); //  하나는 리포지토리인지 모르겠음

        return reviewRepository.save(review);
    }
    @Override
    public Store addStore(StoreRequestDTO.AddStoreDto request){  //컨버터에서의 값들을 생성/저장
        Store newstore = StoreConverter.toStore(request);
        return storeRepository.save(newstore);
    }
    @Override
    public Mission mission( Long storeId, StoreRequestDTO.MissionDTO request){

        Mission mission = StoreConverter.toMission(request);

        mission.setStore(storeRepository.findById(storeId).get());

        return missionRepository.save(mission);
    }

}
