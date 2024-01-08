package NewCodes.NewCodesSpringStudy.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import NewCodes.NewCodesSpringStudy.domain.Member;
import NewCodes.NewCodesSpringStudy.repository.MemberRepository;
import NewCodes.NewCodesSpringStudy.repository.MemoryMemberRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MemberServiceTest {
    MemberService memberService;
    MemoryMemberRepository memberRepository;

    @BeforeEach
    public void beforeEach() {
        memberRepository = new MemoryMemberRepository(); // 인터페이스여서 가능?
        memberService = new MemberService(memberRepository);
    }

    @Test
    void 예외_회원가입_중복_멤버() {
        // given
        Member member = new Member();
        member.setName("spring");

        Member member2 = new Member();
        member2.setName("spring");

        // when
        memberService.join(member);
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));

        //then
        assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
    }
}