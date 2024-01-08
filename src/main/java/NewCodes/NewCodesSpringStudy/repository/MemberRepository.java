package NewCodes.NewCodesSpringStudy.repository;

import NewCodes.NewCodesSpringStudy.domain.Member;
import java.util.List;
import java.util.Optional;

public interface MemberRepository { // 클래스가 가져야 할 메서드의 틀을 정의(추상 메서드), 인터페이스의 효용성
    Member save(Member member);
    Optional<Member> findById(Long id);
    Optional<Member> findByName(String name);
    List<Member> findAll();
}
