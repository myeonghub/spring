package UMC.spring.study.ApiPayload.exception.handler;

import UMC.spring.study.ApiPayload.code.BaseErrorCode;
import UMC.spring.study.ApiPayload.exception.GeneralException;

public class MissionHandler extends GeneralException {

    public MissionHandler(BaseErrorCode errorCode){
        super(errorCode);
    }
}
