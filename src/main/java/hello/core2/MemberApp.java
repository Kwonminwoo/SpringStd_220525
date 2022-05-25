package hello.core2;

import hello.core2.member.Grade;
import hello.core2.member.Member;
import hello.core2.member.MemberService;
import hello.core2.member.MemberServiceImpl;

public class MemberApp { // 순수 자바로 테스트
    public static void main(String[] args) {
        MemberService memberService = new MemberServiceImpl();
        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        Member findMmber = memberService.findMember(1L);
        System.out.println("member = " + member.getName());
        System.out.println("findMmber = " + findMmber.getName());
    }
}
