package UMC.spring.study.domain;


import UMC.spring.study.common.BaseEntity;
import UMC.spring.study.domain.mapping.UserMission;
import lombok.*;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Mission extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long missionIdx;
    @Column(nullable = true , length = 20)
    private String auth;
    @Column(nullable = true , length = 20)
    private String  misText;

    @OneToMany(mappedBy = "mission" , cascade = CascadeType.ALL)
    private List<UserMission> UserMissionList = new ArrayList<>();

}
