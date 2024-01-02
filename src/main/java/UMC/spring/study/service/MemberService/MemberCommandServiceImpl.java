package UMC.spring.study.service.MemberService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import UMC.spring.study.ApiPayload.code.Status.ErrorStatus;
import UMC.spring.study.ApiPayload.exception.handler.FoodCategoryHandler;
import UMC.spring.study.converter.MemberConverter;
import UMC.spring.study.converter.MemberPreferConverter;
import UMC.spring.study.domain.FoodCategory;
import UMC.spring.study.domain.Member;
import UMC.spring.study.domain.mapping.MemberPrefer;
import UMC.spring.study.repository.FoodCategoryRepository;
import UMC.spring.study.repository.MemberRepository;
import UMC.spring.study.web.dto.MemberRequestDTO;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberCommandServiceImpl implements MemberCommandService{

    private final MemberRepository memberRepository;

    private final FoodCategoryRepository foodCategoryRepository;

    @Override
    @Transactional
    public Member joinMember(MemberRequestDTO.JoinDto request) {

        Member newMember = MemberConverter.toMember(request);
        List<FoodCategory> foodCategoryList = request.getPreferCategory().stream()
                .map(category -> {
                    return foodCategoryRepository.findById(category).orElseThrow(() -> new FoodCategoryHandler(ErrorStatus.FOOD_CATEGORY_NOT_FOUND));
                }).collect(Collectors.toList());

        List<MemberPrefer> memberPreferList = MemberPreferConverter.toMemberPreferList(foodCategoryList);

        memberPreferList.forEach(memberPrefer -> {memberPrefer.setMember(newMember);});

        return memberRepository.save(newMember);
    }
}