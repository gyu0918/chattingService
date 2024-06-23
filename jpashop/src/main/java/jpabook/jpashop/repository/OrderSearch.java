package jpabook.jpashop.repository;

import jpabook.jpashop.domain.OrderStatus;
import lombok.Data;
import lombok.Getter;

@Data
public class OrderSearch {
    private String memberName;         //회원 이름
    private OrderStatus orderStatus;   // 주문상태 [ORDER, CANCEL]
}
