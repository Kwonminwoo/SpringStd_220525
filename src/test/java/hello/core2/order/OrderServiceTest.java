package hello.core2.order;

import hello.core2.member.*;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class OrderServiceTest {
    OrderService orderService = new OrderServiceImpl();
    MemberService memberService = new MemberServiceImpl();
    MemberRepository memberRepository = new MemoryMemberRepository();

    @Test
    public void creatOrder(){
        Long memberId = 1L;
        Member member = new Member(memberId, "권민우", Grade.VIP);
        memberService.join(member);
        Order order = orderService.createOrder(memberId, "과자", 10000);
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }
}
