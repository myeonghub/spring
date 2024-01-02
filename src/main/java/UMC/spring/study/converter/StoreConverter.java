package UMC.spring.study.converter;

import UMC.spring.study.domain.Mission;
import UMC.spring.study.domain.Review;
import UMC.spring.study.domain.Store;
import UMC.spring.study.web.dto.StoreRequestDTO;
import UMC.spring.study.web.dto.StoreResponseDTO;
import org.springframework.data.domain.Page;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class StoreConverter {

    public static Review toReview(StoreRequestDTO.ReveiwDTO request){
        return Review.builder()
                .title(request.getTitle())
                .score(request.getScore())
                .body(request.getBody())
                .build();
    }

    public static StoreResponseDTO.CreateReviewResultDTO toCreateReviewResultDTO(Review review){
        return StoreResponseDTO.CreateReviewResultDTO.builder()
                .reviewId(review.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }
    public static StoreResponseDTO.ReviewPreViewDTO reviewPreViewDTO(Review review){
        return StoreResponseDTO.ReviewPreViewDTO.builder()
                .ownerNickname(review.getMember().getName())
                .score(review.getScore())
                .createdAt(review.getCreatedAt().toLocalDate())
                .body(review.getBody())
                .build();
    }
    public static StoreResponseDTO.ReviewPreViewListDTO reviewPreViewListDTO(Page<Review> reviewList){

        List<StoreResponseDTO.ReviewPreViewDTO> reviewPreViewDTOList = reviewList.stream()
                .map(StoreConverter::reviewPreViewDTO).collect(Collectors.toList());

        return StoreResponseDTO.ReviewPreViewListDTO.builder()
                .isLast(reviewList.isLast())
                .isFirst(reviewList.isFirst())
                .totalPage(reviewList.getTotalPages())
                .totalElements(reviewList.getTotalElements())
                .listSize(reviewPreViewDTOList.size())
                .reviewList(reviewPreViewDTOList)
                .build();
    }
    public static StoreResponseDTO.AddStoreDTO toAddStoreDTO(Store store){ //요청에 대한 응답
        return StoreResponseDTO.AddStoreDTO.builder()
                .storeid(store.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }
    public static Store toStore(StoreRequestDTO.AddStoreDto request){ // 요청에 대한 행위
        return Store.builder()
                .name(request.getStorename())
                .address(request.getAddress())
                .score((request.getScore()))
                .build();

    }
    public static StoreResponseDTO.MissionDTO toMissionDTO(Mission mission){
        return StoreResponseDTO.MissionDTO.builder()
                .missionid(mission.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }
    public static Mission toMission(StoreRequestDTO.MissionDTO request){
        return Mission.builder()
                .missionSpec(request.getMissionSpec())
                .deadline(request.getDeadline())
                .reward(request.getReward())
                .build();

    }

}
