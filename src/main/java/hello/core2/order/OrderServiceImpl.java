package hello.core2.order;

import hello.core2.discount.DiscountPolicy;
import hello.core2.discount.FixDiscountPolicy;
import hello.core2.member.Member;
import hello.core2.member.MemberRepository;
import hello.core2.member.MemoryMemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *  주문서비스 구현체 클래스
 */
@Component
@RequiredArgsConstructor // final이 붙은 필수 필드를 이용한 생성자를 만들어 줌
public class OrderServiceImpl implements OrderService{
    //private final MemberRepository memberRepository = new MemoryMemberRepository(); // 기존의 직접 객체를 생성하던 코드
    //private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

//    @Autowired
//    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
//        this.memberRepository = memberRepository;
//        this.discountPolicy = discountPolicy;
//    }
    // 롬복으로 생성자가 자동으로 만들어져 기존의 코드는 필요 x

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
    
    // 테스트용도
    public MemberRepository getMemberRepository(){
        return memberRepository;
    }
}
