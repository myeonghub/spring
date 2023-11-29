package UMC.spring.study.ApiPayload.exception.handler;

import UMC.spring.study.ApiPayload.code.BaseErrorCode;
import UMC.spring.study.ApiPayload.exception.GeneralException;

public class TempHandler extends GeneralException {

    public TempHandler(BaseErrorCode errorCode) {
        super(errorCode);
    }
}
