package UMC.spring.study.domain;

import UMC.spring.study.common.BaseEntity;
import UMC.spring.study.domain.enums.CheckingCall;
import UMC.spring.study.domain.enums.Gender;
import lombok.*;

import javax.annotation.processing.Generated;
import javax.persistence.*;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class User extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userIdx;
    private String name;
    private String birthday;
    private String city;
    private String dong;
    private String email;
    private String phoneNum;
    private String address;

    @Enumerated(EnumType.STRING)
    private Gender gender;
    @Enumerated(EnumType.STRING)
    private CheckingCall checkingCall;








}
