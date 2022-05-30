package hello.core2;

import hello.core2.member.Grade;
import hello.core2.member.Member;
import hello.core2.member.MemberService;
import hello.core2.member.MemberServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp { // 순수 자바로 테스트
    public static void main(String[] args) {
//        AppConfig appConfig = new AppConfig();
//        MemberService memberService = appConfig.memberService();
        // 기존의 AppConfig로 실행하던 것을 스프링을 이용하는 것으로 바꿈.

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);
        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        Member findMmber = memberService.findMember(1L);
        System.out.println("member = " + member.getName());
        System.out.println("findMmber = " + findMmber.getName());
    }
}
