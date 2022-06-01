package hello.core2.order;

import hello.core2.discount.DiscountPolicy;
import hello.core2.discount.FixDiscountPolicy;
import hello.core2.member.Member;
import hello.core2.member.MemberRepository;
import hello.core2.member.MemoryMemberRepository;

/**
 *  주문서비스 구현체 클래스
 */
public class OrderServiceImpl implements OrderService{
    //private final MemberRepository memberRepository = new MemoryMemberRepository(); // 기존의 직접 객체를 생성하던 코드
    //private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

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
