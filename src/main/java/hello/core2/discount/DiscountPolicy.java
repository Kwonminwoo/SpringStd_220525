package hello.core2.discount;

import hello.core2.member.Member;

/**
 *  할인 정책 역할 인터페이스
 */
public interface DiscountPolicy {
    /**
     * @return 할인 대상 금액
     */
    int discount(Member member, int price);
}
