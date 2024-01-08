package NewCodes.NewCodesSpringStudy.controller;

import NewCodes.NewCodesSpringStudy.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller // 스프링이 해당 애노테이션 컨트롤러, 서비스, 리포지토리 등을 인식함. 컴포넌트 애노테이션 포함됨. 그래서 이를 인식할 수 있음.
public class MemberController {
    MemberService memberService;

    @Autowired // 스프링 컨테이너에 자동으로 등록되게 함. 해당 서비스 클래스는 여러 개 생성할 필요x 하나만 생성해서 관리해줌.(싱글톤)
    // 스프링 빈을 등록하는 방법1: 컴포넌트 스캔과 자동 의존관계 설정
    // 방법2: 자바 코드로 직접 스프링 빈 등록
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }
}
