package UMC.spring.study.domain;

import UMC.spring.study.common.BaseEntity;
import UMC.spring.study.domain.enums.ReviewStatus;
import UMC.spring.study.domain.enums.ReviewStar;
import lombok.*;

import javax.persistence.*;
import java.math.BigInteger;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Review extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reviewIdx;
    private String reviewText;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "VARCHAR(10)")
    private ReviewStar reviewStar;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "VARCHAR(10)")
    private ReviewStatus reviewstate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "UserIdx")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "storeIdx")
    private Store store;





}
