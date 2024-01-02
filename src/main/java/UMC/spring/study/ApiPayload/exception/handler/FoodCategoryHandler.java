package UMC.spring.study.ApiPayload.exception.handler;

import UMC.spring.study.ApiPayload.code.BaseErrorCode;
import UMC.spring.study.ApiPayload.exception.GeneralException;

public class FoodCategoryHandler extends GeneralException {
    public FoodCategoryHandler(BaseErrorCode errorCode) {
        super(errorCode);
    }
}
