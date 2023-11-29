package UMC.spring.study.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class MissionEndResponse {

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class MissionEndDTO{
        String Success;  // result에 나올 메시지들 converter에서 작성가능
        String ID;
    }
    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class MissionExceptionDTO{
        String Success;
        String ID;
    }

}
