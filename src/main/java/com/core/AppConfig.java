package com.core;

import com.core.discount.DiscountPolicy;
import com.core.discount.FixDiscountPolicy;
import com.core.discount.RateDiscountPolicy;
import com.core.member.MemberService;
import com.core.member.MemberServiceImpl;
import com.core.member.MemoryMemberRepository;
import com.core.order.OrderServiceImpl;

public class AppConfig {
    public MemberService memberService() {
        return new MemberServiceImpl(MemberRepository());
    }

    private static MemoryMemberRepository MemberRepository() {
        return new MemoryMemberRepository();
    }

    public OrderServiceImpl orderService() {
        return new OrderServiceImpl(MemberRepository(), discountPolicy());
    }

    public DiscountPolicy discountPolicy() {
//        return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }
}
