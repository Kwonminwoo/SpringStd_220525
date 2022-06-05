package hello.core2.autowired.allbean;

import hello.core2.AutoAppConfig;
import hello.core2.discount.DiscountPolicy;
import hello.core2.member.Grade;
import hello.core2.member.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;
import java.util.Map;

public class AllBeanTest {
    @Test
    void findAllBean(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class, DiscountService.class);

        DiscountService discountService = ac.getBean(DiscountService.class);
        Member member = new Member(1L, "userA", Grade.VIP);
        int discount = discountService.discount(member, 10000, "fixDiscountPolicy");

        Assertions.assertThat(discount).isEqualTo(1000);


        int rateDiscountPrice = discountService.discount(member, 20000, "rateDiscountPolicy");
        Assertions.assertThat(rateDiscountPrice).isEqualTo(2000);
    }

    static class DiscountService{
        private final Map<String, DiscountPolicy> policyMap;
        private final List<DiscountPolicy> policyList;

        @Autowired
        public DiscountService(Map<String, DiscountPolicy> policyMap, List<DiscountPolicy> policyList) {
            this.policyMap = policyMap; // 빈에 등록된 모든 DiscountPolicy를 주입시켜줌 Key = 타입 value = 이름
            this.policyList = policyList;
            System.out.println("policyMap = " + policyMap);
            System.out.println("policyMap = " + policyList);
        }

        public int discount(Member member, int i, String discountCode) {
            DiscountPolicy discountPolicy = policyMap.get(discountCode);
            return discountPolicy.discount(member, i); // 실제 Rate/FixDiscountPolicy 클래스의 discount를 호출하는 부분
        }
    }
}
