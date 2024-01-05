package NewCodes.NewCodesSpringStudy.repository;

import static org.assertj.core.api.Assertions.assertThat;

import NewCodes.NewCodesSpringStudy.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class MemoryMemberRepositoryTest {
    MemberRepository repository = new MemoryMemberRepository();

    @Test
    public void save() {
        Member member = new Member();
        member.setName("hyeok");
        repository.save(member);
        Member result = repository.findById(member.getId()).get();
        assertThat(member).isEqualTo(result);
    }

    @Test
    public void findByName() {
        Member member1 = new Member();
        member1.setName("hyeok");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("hyeok2");
        repository.save(member2);

        Member result = repository.findByName("hyeok").get();

        assertThat(member1).isEqualTo(result);
    }
}