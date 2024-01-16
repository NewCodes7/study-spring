package NewCodes.NewCodesSpringStudy.controller;

import NewCodes.NewCodesSpringStudy.domain.Member;
import NewCodes.NewCodesSpringStudy.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller // 스프링이 해당 애노테이션 컨트롤러, 서비스, 리포지토리 등을 인식함. 컴포넌트 애노테이션 포함됨. 그래서 이를 인식할 수 있음.
public class MemberController {
    MemberService memberService;

    @Autowired // 스프링 컨테이너에 자동으로 등록되게 함. 해당 서비스 클래스는 여러 개 생성할 필요x 하나만 생성해서 관리해줌.(싱글톤)
    // 스프링 빈을 등록하는 방법1: 컴포넌트 스캔과 자동 의존관계 설정
    // 방법2: 자바 코드로 직접 스프링 빈 등록 @Configuration 파일 내 @Bean으로 등록
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }
    // DI 여러 가지 방법이 있지만 생성자 주입이 가장 안전함. setter는 public 선언이어서 노출됨. 필드도 별로. 변경할 일이 거의 없기에.

    @GetMapping("/members/new")
    public String createForm() {
        return "members/createMemberForm";
    }

    @PostMapping("members/new")
    public String create(MemberForm form) {
        Member member = new Member();
        member.setName(form.getName());

        memberService.join(member);

        return "redirect:/";
    }

}
