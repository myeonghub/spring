package UMC.spring.study.domain.mapping;

import UMC.spring.study.domain.Menu;
import UMC.spring.study.domain.Mission;
import UMC.spring.study.domain.User;
import lombok.*;

import javax.persistence.*;
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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MissionIdx")
    private Mission mission ;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "UserIdx")
    private User user;




}
