package UMC.spring.study.ApiPayload;
import UMC.spring.study.ApiPayload.code.BaseCode;
import UMC.spring.study.ApiPayload.code.Status.ErrorStatus;
import UMC.spring.study.ApiPayload.code.Status.SuccessStatus;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
@JsonPropertyOrder({"isSuccess", "code", "message", "result"})
public class ApiResponse<T> {
    @JsonProperty("isSuccess")
    private final Boolean isSuccess;
    private final String code;
    private final String message;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private T result;


     //성공한 경우 응답 생성


    public static <T> ApiResponse<T> onSuccess(T result){
        return new ApiResponse<>(true, SuccessStatus._OK.getCode() , SuccessStatus._OK.getMessage(), result);
    }

    public static <T> ApiResponse<T> missionSuccess(T result){
        return new ApiResponse<>(true, SuccessStatus._OK.getCode() , SuccessStatus._OK.getMessage(), result);
    }
    public static <T> ApiResponse<T> missionfailure(T result){
        return new ApiResponse<>(false, ErrorStatus.MISSION_EXCEPTION.getCode() , ErrorStatus.MISSION_EXCEPTION.getMessage(), result);
    }

    public static <T> ApiResponse<T> of(BaseCode code, T result){
        return new ApiResponse<>(true, code.getReasonHttpStatus().getCode() , code.getReasonHttpStatus().getMessage(), result);
    }


    // 실패한 경우 응답 생성
    public static <T> ApiResponse<T> onFailure(String code, String message, T data){
        return new ApiResponse<>(true, code, message, data);
    }

}
