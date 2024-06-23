package jpabook.jpashop.domain;


import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "orders")
@Data
@NoArgsConstructor(access =  AccessLevel.PROTECTED)
public class Order {

    @Id @GeneratedValue
    @Column(name = "order_id")
    private Long id;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")  //mapping 이름이 member_id 외래키
    private Member member;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)  //한번에 persist해버린다 원래는 엔티티당 해야된다
    private List<OrderItem> orderItems = new ArrayList<>();

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)  // 이렇게 cascade사용할떄 만약에 delivery가 중요하고 order에만 쓰이지 않고 다른곳에도 쓰이고 한다면 사용x
    @JoinColumn(name = "delivery_id")
    private Delivery delivery;

    private LocalDateTime orderDate;   // 주문시간

    @Enumerated(EnumType.STRING)
    private OrderStatus status;   // 주문상태 [ORDER, CANCEL]


    //연관관계 편의메서드  //양방향일떄 써주면 좋다
    public void setMember(Member member){
        this.member = member;
        member.getOrders().add(this);
    }
    public void addOrderItem(OrderItem orderItem){
        orderItems.add(orderItem);
        orderItem.setOrder(this);
    }
    public void setDelivery(Delivery delivery){
        this.delivery = delivery;
        delivery.setOrder(this);
    }

    //== 생성 메서드 ==//
    public static Order createOrder(Member member, Delivery delivery, OrderItem... orderItems){
        Order order = new Order();
        order.setMember(member);
        order.setDelivery(delivery);
        for (OrderItem orderItem : orderItems){
            order.addOrderItem(orderItem);
        }
        order.setStatus(OrderStatus.ORDER);   //status를 처음 order상태로 강제해둘거다?
        order.setOrderDate(LocalDateTime.now());
        return order;
    }

    //== 비지니스 로직 ==//

    //주문 취소
    public void cancel(){
        if (delivery.getStatus() == DeliveryStatus.COMP){
            throw new IllegalStateException("이미 배송완료된 상품은 취소가 불가능합니다");
        }

        this.setStatus(OrderStatus.CANCEL);
        for (OrderItem orderItem : orderItems) {
            orderItem.cancel();
        }
    }

    //== 조회 로직 == //

    /**
     * 전체 주문 가격 조회
     */
//    public int getTotalPrice(){
//        int totalPrice = 0;
//        for (OrderItem orderItem : orderItems) {
//            totalPrice += orderItem.getTotalPrice();
//        }
//        return totalPrice;
//    }

    //람다 형식으로 바꾸기 이쁘게 보이게
    public int getTotalPrice(){
        return orderItems.stream()
                .mapToInt(OrderItem::getTotalPrice)
                .sum();
    }

}
