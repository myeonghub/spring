package UMC.spring.study.domain;

import UMC.spring.study.common.BaseEntity;
import UMC.spring.study.domain.enums.CheckingCall;
import UMC.spring.study.domain.enums.Gender;
import UMC.spring.study.domain.mapping.UserMenu;
import UMC.spring.study.domain.mapping.UserMission;
import lombok.*;

import javax.annotation.processing.Generated;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class User extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userIdx;

    @Column(nullable = false, length = 20)
    private String name;
    @Column(nullable = false, length = 20)
    private String birthday;
    @Column(nullable = false, length = 20)
    private String city;
    @Column(nullable = false, length = 20)
    private String dong;

    private String email;

    private String phoneNum;

    @Column(nullable = false, length = 20)
    private String address;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "VARCHAR(10)")
    private Gender gender;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "VARCHAR(10)")
    private CheckingCall checkingCall;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Review> UserReviewList = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<UserMission> UserMissionList = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<UserMenu> UserMenuList = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Menu> MenuList = new ArrayList<>();












}
