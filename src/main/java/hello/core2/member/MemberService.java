package hello.core2.member;

/**
 *  서비스 역할 인터페이스
 */
public interface MemberService {
    void join(Member member);

    Member findMember(Long memberId);
}
