package UMC.spring.study.web.dto;

import lombok.Getter;
import UMC.spring.study.validation.annotation.ExistCategories;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class StoreRequestDTO {

    @Getter
    public static class ReveiwDTO{
        @NotBlank
        String title;
        @NotNull
        Float score;
        @NotBlank
        String body;
    }
    @Getter
    public static class AddStoreDto{
        @NotBlank
        String storename;
        @NotBlank
        String address;
        @NotBlank
        Float score;
    }
    @Getter
    public static class MissionDTO{
        String missionSpec;
        Integer reward;
        LocalDate deadline;
    }


}
