package UMC.spring.study.ApiPayload.exception;

import UMC.spring.study.ApiPayload.code.BaseErrorCode;
import UMC.spring.study.ApiPayload.code.ErrorReasonDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class GeneralException extends RuntimeException {

    private BaseErrorCode code;

    public ErrorReasonDTO getErrorReason() {

        return this.code.getReason();
    }

    public ErrorReasonDTO getErrorReasonHttpStatus(){

        return this.code.getReasonHttpStatus();
    }
}
