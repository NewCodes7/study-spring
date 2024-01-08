package NewCodes.NewCodesSpringStudy.service;

import NewCodes.NewCodesSpringStudy.domain.Member;
import NewCodes.NewCodesSpringStudy.repository.MemberRepository;
import NewCodes.NewCodesSpringStudy.repository.MemoryMemberRepository;
import java.util.List;
import java.util.Optional;

public class MemberService {
    // 서비스는 비즈니스에 의존적으로 설계(용어도 그러함)
    //
    //리포지토리는 좀 더 개발스럽게 용어 선택
    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    // 회원가입
    public Long join(Member member) {
        validateDuplicateMember(member);

        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }

    /** 주석 스타일?
     * 전체 회원 조회
     */
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId) {
        return memberRepository.findById(memberId);
    }

}
