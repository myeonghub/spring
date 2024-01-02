package UMC.spring.study.service.MemberService;

import UMC.spring.study.domain.Member;
import UMC.spring.study.domain.Review;
import org.springframework.data.domain.Page;

import java.util.Optional;

public interface MemberQueryService {

    Optional<Member> findMember(Long id);
    Page<Review> getReviewList(Long memberId, Integer page);
}
