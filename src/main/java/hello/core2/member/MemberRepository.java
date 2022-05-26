package hello.core2.member;

/**
 *  저장소 역할 인터페이스
 */
public interface MemberRepository {
    void save(Member member);

    Member findById(Long memberId);
}
