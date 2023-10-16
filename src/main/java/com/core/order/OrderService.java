//주문 서비스 인터페이스
package com.core.order;

public interface OrderService {
    Order createOrder(Long memberId, String itemName, int itemPrice);
}
