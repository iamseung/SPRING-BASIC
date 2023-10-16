//할인 정책 인터페이스
package com.core.discount;

import com.core.member.Member;

public interface DiscountPolicy {
    /*
    * @return 할인 대상 금액
     */
    int discount(Member member, int price);
}
