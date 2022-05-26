package hello.core2.order;

/**
 * 주문서비스 역할 인터페이스
 */
public interface OrderService {
    Order createOrder (Long memberId, String itemName, int itemPrice); // 주문을 생성하면 주문 결과를 반환하는 메소드
}
