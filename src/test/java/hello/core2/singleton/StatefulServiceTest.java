package hello.core2.singleton;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

public class StatefulServiceTest {
   @Test
   void statefulServiceSingleton(){
       ApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
       StatefulService statefulService1 = ac.getBean(StatefulService.class);
       StatefulService statefulService2 = ac.getBean(StatefulService.class);
       // ThreadA: A사용자가 10000원을 주문
       int userAPrice = statefulService1.order("userA", 10000); // 지역 변수로 사용하여 필드를 공유하지 않음.
       // ThreadA: B사용자가 20000원을 주문
       int userBPrice = statefulService2.order("userB", 20000);

       // ThreadA: 사용자 A가 주문 금액 조회
//       int price = statefulService1.getPrice();
//       System.out.println("price = " + price); // 20000이 조회됨...

       System.out.println("userAPrice = " + userAPrice);

//       Assertions.assertThat(statefulService1.getPrice()).isEqualTo(20000);
   }

   static class TestConfig{

       @Bean
       public StatefulService statefulService(){
           return new StatefulService();
       }
   }
}
