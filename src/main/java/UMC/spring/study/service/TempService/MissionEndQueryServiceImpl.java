package UMC.spring.study.service.TempService;

import UMC.spring.study.ApiPayload.code.Status.ErrorStatus;
import UMC.spring.study.ApiPayload.exception.handler.MissionHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MissionEndQueryServiceImpl implements MissionEndQueryService{
    public void MissionException(){
        throw new MissionHandler(ErrorStatus.MISSION_EXCEPTION);
    }

}
