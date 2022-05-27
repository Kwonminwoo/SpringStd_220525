package hello.core2.order;

import hello.core2.AppConfig;
import hello.core2.member.*;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class OrderServiceTest {
    OrderService orderService;
    MemberService memberService;

    @BeforeEach // 각 메소드 실행전 실행되는 코드
    public void beforeEach(){
        AppConfig appConfig = new AppConfig();
        orderService = appConfig.orderService();
        memberService = appConfig.memberService();
    }

    @Test
    public void creatOrder(){
        Long memberId = 1L;
        Member member = new Member(memberId, "권민우", Grade.VIP);
        memberService.join(member);
        Order order = orderService.createOrder(memberId, "과자", 10000);
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }
}
