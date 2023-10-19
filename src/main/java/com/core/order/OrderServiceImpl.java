//주문 서비스 구현체
package com.core.order;

import com.core.discount.DiscountPolicy;
import com.core.member.Member;
import com.core.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
// 롬복 라이브러리가 제공하는 `@RequiredArgsConstructor` 기능을 사용하면
// final이 붙은 필드를 모아서 생 성자를 자동으로 만들어준다.
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

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
