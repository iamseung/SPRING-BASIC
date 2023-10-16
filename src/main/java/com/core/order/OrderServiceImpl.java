//주문 서비스 구현체
package com.core.order;

import com.core.discount.DiscountPolicy;
import com.core.member.Member;
import com.core.member.MemberRepository;

public class OrderServiceImpl implements OrderService {
    // final 은 무조건 값이 할당되어야 한다!
    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }
    /*
            주문 생성 요청이 오면, 회원 정보를 조회하고, 할인 정책을 적용한 다음 주문 객체를 생성해서 반환한다.
            메모리 회원 리포지토리와, 고정 금액 할인 정책을 구현체로 생성한다
         */
    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);
        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
