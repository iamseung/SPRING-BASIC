//정액 할인 정책 구현체
package com.core.discount;

import com.core.member.Grade;
import com.core.member.Member;

public class FixDiscountPolicy implements DiscountPolicy {
    private int discountFixAmount = 1000; //1000원 할인

    /*
        VIP면 1000원 할인, 아니면 할인 없음
     */
    @Override
    public int discount(Member member, int price) {
        if (member.getGrade() == Grade.VIP) {
            return discountFixAmount;
        } else {
            return 0;
        }
    }
}
