package hello.core2.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *  서비스 구현체 클래스 implement되는 대상이 하나 일 떄는 Impl을 써서 표시
 *  MemberService -> MemberServiceImpl 로 MemberServiceImpl인터페이스에서 상속되는 클래스는 MemberServiceImpl하나 뿐
 */

@Component // 컴포넌트스캔을 위해 컴포넌트로 설정
public class MemberServiceImpl implements MemberService{
    //private final MemberRepository memberRepository = new MemoryMemberRepository();// 추상화에도 의존, 구현체에도 의존 DIP를 위반하는 코드

    private final MemberRepository memberRepository;
    //@Autowired private MemberRepository memberRepository; // 필드 의존관계 주입


    @Autowired // 의존관계주입을 자동으로 해주게 함. memberRepository를 컨테이너에서 타입으로 찾아 주입시켜줌
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

//    @Autowired  // setter주입 (수정자 주입) 의존관계 주입이 된다. 필드가 fianl로 지정되어 있으면 오류
//    public void setMemberRepository(MemberRepository memberRepository){
//        this.memberRepository = memberRepository;
//    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }

    // 테스트 용도
    public MemberRepository getMemberRepository(){
        return memberRepository;
    }
}
