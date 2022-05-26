package hello.core2.discount;

import hello.core2.member.Grade;
import hello.core2.member.Member;

/**
 *  정액 할인 구현체 클래스
 */
public class FixDiscountPolicy implements DiscountPolicy{
    private int discountFixAmount = 1000; // 1000원 할인
    @Override
    public int discount(Member member, int price) {
        if(member.getGrade() == Grade.VIP){
            return discountFixAmount;
        }else {
            return 0;
        }
    }
}
