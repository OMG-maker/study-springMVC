package hello.servlet.domain.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class MemberRepositoryTest {
    MemberRepository memberRepository = MemberRepository.getInstance();


    @AfterEach
    void afterEach(){ // 테스트 종료시마다 테스트를 깔끔하게 초기화 하기 위함
        memberRepository.clearStore();
    }

    void save(){
        // given : ~한게 주어졌을 떄, 결과가 ₩여야 해
        Member member1 = new Member("hello", 20);
        Member member2 = new Member("hello", 30);
//        Member member3 = new Member("hello", 40);



        memberRepository.save(member1);
        memberRepository.save(member2);
//        memberRepository.save(member3);

        List<Member> result = memberRepository.findAll();

        // Assertions.assertThat(result.size()).isEqualTo(2);
        // option + enter
        assertThat(result.size()).isEqualTo(2); // 숫자가 2개가 맞는가
        assertThat(result).contains(member1, member2); // member1과 member2가 있는가




//        // when
//        Member savedMember = memberRepository.save(member);
//
//        // then
//        Member findMember = memberRepository.findById(savedMember.getId());
//
//        Assertions.assertThat(findMember).isEqualTo(savedMember);
    }
}
