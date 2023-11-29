package UMC.spring.study.web.controller;

import UMC.spring.study.ApiPayload.ApiResponse;
import UMC.spring.study.converter.MissionEndConverter;
import UMC.spring.study.service.TempService.MissionEndQueryService;
import UMC.spring.study.web.dto.MissionEndResponse;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class MissionEndRestController {
    private final MissionEndQueryService missionEndQueryService;

    @GetMapping("/missionEnd")
    public ApiResponse<MissionEndResponse.MissionEndDTO> missionendAPI(){
        return ApiResponse.missionSuccess(MissionEndConverter.toMissionEndDTO());
    }

    @GetMapping("/MissionException")
    public ApiResponse<MissionEndResponse.MissionExceptionDTO> missionExceptionAPI(){
        return ApiResponse.missionfailure(MissionEndConverter.toMissionExceptionDTO());
    }
}
