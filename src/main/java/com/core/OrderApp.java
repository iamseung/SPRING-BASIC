package com.core;

import com.core.member.Grade;
import com.core.member.Member;
import com.core.member.MemberService;
import com.core.order.Order;
import com.core.order.OrderService;

public class OrderApp {
    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();

        MemberService memberService = appConfig.memberService();
//        MemberService memberService = new MemberServiceImpl(;

        OrderService orderService = appConfig.orderService();
//        OrderService orderService = new OrderServiceImpl();
        
        long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 20000);

        System.out.println("order = " + order);
    }
}
