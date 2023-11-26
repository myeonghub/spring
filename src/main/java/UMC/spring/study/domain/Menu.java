package UMC.spring.study.domain;

import UMC.spring.study.common.BaseEntity;
import UMC.spring.study.domain.enums.FoodType;
import UMC.spring.study.domain.enums.MenuStatus;
import UMC.spring.study.domain.mapping.UserMenu;
import ch.qos.logback.core.status.Status;
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
public class Menu extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long menuIdx;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "VARCHAR(10)")
    private FoodType foodType;
    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "VARCHAR(10)")
    private MenuStatus status;

    @OneToMany(mappedBy = "menu" , cascade = CascadeType.ALL)
    private List<UserMenu> UserMenuList = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "storeIdx")
    private Store store;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "UserIdx")
    private User user;

}
