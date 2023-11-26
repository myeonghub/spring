package UMC.spring.study.domain.mapping;

import UMC.spring.study.common.BaseEntity;
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
public class UserMenu extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userMenuIdx;

    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn(name = "MenuIdx")
    private Menu menu;

    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn(name = "UserIdx")
    private User user;


}
