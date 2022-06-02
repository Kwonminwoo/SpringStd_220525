package hello.core2.member;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 *  저장소 구현체 클래스
 */
@Component
public class MemoryMemberRepository implements MemberRepository{

    private  static Map<Long, Member> store = new HashMap<>();
    @Override
    public void save(Member member) {
        store.put(member.getId(), member);
        System.out.println("test");
    }

    @Override
    public Member findById(Long memberId) {
        return store.get(memberId);
    }
}
