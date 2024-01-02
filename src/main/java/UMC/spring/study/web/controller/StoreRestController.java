package UMC.spring.study.web.controller;

import UMC.spring.study.domain.Mission;
import UMC.spring.study.domain.Store;
import UMC.spring.study.repository.ReviewRepository;
import UMC.spring.study.service.StoreService.StoreQueryService;
import UMC.spring.study.service.StoreService.StoreQueryServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import UMC.spring.study.ApiPayload.ApiResponse;
import UMC.spring.study.converter.StoreConverter;
import UMC.spring.study.domain.Review;
import UMC.spring.study.service.StoreService.StoreCommandService;
import UMC.spring.study.validation.annotation.ExistMember;
import UMC.spring.study.validation.annotation.ExistStore;
import UMC.spring.study.web.dto.StoreRequestDTO;
import UMC.spring.study.web.dto.StoreResponseDTO;


import javax.validation.Valid;

@RestController
@Validated
@RequiredArgsConstructor
@RequestMapping("/stores")
public class StoreRestController {

    private final StoreCommandService storeCommandService;
    private final StoreQueryService storeQueryService;

    @PostMapping("/{storeId}/reviews")
    public ApiResponse<StoreResponseDTO.CreateReviewResultDTO> createReview(@RequestBody @Valid StoreRequestDTO.ReveiwDTO request,
                                                                            @ExistStore @PathVariable(name = "storeId") Long storeId,
                                                                            @ExistMember @RequestParam(name = "memberId") Long memberId){
        Review review = storeCommandService.createReview(memberId, storeId, request);
        return ApiResponse.onSuccess(StoreConverter.toCreateReviewResultDTO(review));
    }
    @PostMapping("/addstore")
    public ApiResponse<StoreResponseDTO.AddStoreDTO> addStore(@RequestBody @Valid StoreRequestDTO.AddStoreDto request){  //성공/실패 에따른 행등
        Store store = storeCommandService.addStore(request);
        return ApiResponse.onSuccess(StoreConverter.toAddStoreDTO(store));  //응답
    }
    @PostMapping("/{storeId}/mission") //스토어 아이디를 패스로 불러오므로 {}이부분 작성해야함
    public ApiResponse<StoreResponseDTO.MissionDTO> mission(@RequestBody @Valid StoreRequestDTO.MissionDTO request,
                                                            @ExistStore @PathVariable(name = "storeId")Long storeId){
        Mission mission = storeCommandService.mission(storeId, request);
        return ApiResponse.onSuccess(StoreConverter.toMissionDTO(mission));
    }
    @Operation(summary = "특정 가게의 리뷰 목록 조회 API",description = "특정 가게의 리뷰들의 목록을 조회하는 API이며, 페이징을 포함합니다. query String 으로 page 번호를 주세요")
    @GetMapping("/{storeId}/reviews")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200",description = "OK, 성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH003", description = "access 토큰을 주세요!",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH004", description = "acess 토큰 만료",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH006", description = "acess 토큰 모양이 이상함",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
    })
    @Parameters({
            @Parameter(name = "storeId", description = "가게의 아이디, path variable 입니다!"),
            @Parameter(name = "page", description = "페이지 번호, 0번이 1 페이지 입니다."),
    })
    public ApiResponse<StoreResponseDTO.ReviewPreViewListDTO> getReviewList(@ExistStore @PathVariable(name = "storeId") Long storeId, @RequestParam(name = "page") Integer page){

            storeQueryService.getReviewList(storeId,page);
            return ApiResponse.onSuccess(StoreConverter.reviewPreViewListDTO(storeQueryService.getReviewList(storeId,page)));

    }

}