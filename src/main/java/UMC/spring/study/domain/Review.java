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
    private Long userIdx;
    private Long storeIdx;

    @Enumerated(EnumType.STRING)
    private ReviewStar reviewStar;

    @Enumerated(EnumType.STRING)
    private ReviewStatus reviewstate;



}
