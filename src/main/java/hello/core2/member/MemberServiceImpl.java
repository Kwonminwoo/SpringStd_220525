package hello.core2.member;

/**
 *  서비스 구현체 클래스 implement되는 대상이 하나 일 떄는 Impl을 써서 표시
 *  MemberService -> MemberServiceImpl 로 MemberServiceImpl인터페이스에서 상속되는 클래스는 MemberServiceImpl하나 뿐
 */
public class MemberServiceImpl implements MemberService{
    //private final MemberRepository memberRepository = new MemoryMemberRepository();// 추상화에도 의존, 구현체에도 의존 DIP를 위반하는 코드

    private final MemberRepository memberRepository;

    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

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
