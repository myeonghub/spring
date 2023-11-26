package UMC.spring.study.domain;

import UMC.spring.study.common.BaseEntity;
import UMC.spring.study.domain.enums.StoreStatus;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Store extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long storeIdx;

    @Column(nullable = false, length = 20)
    private String name;

    @Column(nullable = false, length = 20)
    private String address;
    private String openTime;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "VARCHAR(10)")
    private StoreStatus storeStatus;

    @OneToMany(mappedBy = "store", cascade = CascadeType.ALL)
    private List<Review> ReviewList = new ArrayList<>();

    @OneToMany(mappedBy = "store" , cascade = CascadeType.ALL)
    private List<Menu> MenuList = new ArrayList<>();


}
