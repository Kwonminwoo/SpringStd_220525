package hello.core2;

import hello.core2.discount.DiscountPolicy;
import hello.core2.discount.FixDiscountPolicy;
import hello.core2.discount.RateDiscountPolicy;
import hello.core2.member.MemberRepository;
import hello.core2.member.MemberService;
import hello.core2.member.MemberServiceImpl;
import hello.core2.member.MemoryMemberRepository;
import hello.core2.order.OrderService;
import hello.core2.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


//public class AppConfig { // 배역에 맞는 담당배우를 선택하는, 어플리케이션 전첼가 어떤식으로 동작할지를 구성 담당.
//    /**
//     * 역할: MemberSerive 구현체: MemberServiceImpl
//     */
//    public MemberService memberService(){
//        return new MemberServiceImpl(memberRepository());
//    }
//    public MemberRepository memberRepository(){
//        return new MemoryMemberRepository();
//    }
//
//    public OrderService orderService(){
//        return new OrderServiceImpl(memberRepository(), discountPolicy());
//    }
//
//    public DiscountPolicy discountPolicy(){
////        return new FixDiscountPolicy(); // 할인 정책의 구체 클래스를 바꿈
//        return new RateDiscountPolicy();
//    }
//}


@Configuration // 구성정보를 담당
public class AppConfig{
    @Bean // 메소드에 Bean이라고 적으면 스프링 컨테이너에 들어감
    public MemberService memberService(){
        return new MemberServiceImpl(memberRepository());
    }
    @Bean
    public MemberRepository memberRepository(){
        return new MemoryMemberRepository();
    }
    @Bean
    public OrderService orderService(){
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }
    @Bean
    public DiscountPolicy discountPolicy(){
//        return new FixDiscountPolicy(); // 할인 정책의 구체 클래스를 바꿈
        return new RateDiscountPolicy();
    }
}