package UMC.spring.study.converter;

import UMC.spring.study.web.dto.MissionEndResponse;

public class MissionEndConverter {

    public static MissionEndResponse.MissionEndDTO toMissionEndDTO(){
        return MissionEndResponse.MissionEndDTO.builder()
                .ID("1")
                .Success("8")
                .build();
    }
    public static MissionEndResponse.MissionExceptionDTO toMissionExceptionDTO(){
        return MissionEndResponse.MissionExceptionDTO.builder()
                .ID("none")
                .Success("none")
                .build();
    }
}
