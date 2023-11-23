package UMC.spring.study.domain.mapping;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigInteger;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor

public class UserMission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long userMissionIdx;
    private Long userIdx;
    private Long menuIdx;

}
