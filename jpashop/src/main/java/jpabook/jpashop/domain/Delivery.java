package jpabook.jpashop.domain;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Delivery {
    @Id @GeneratedValue
    @Column(name = "delivery_id")
    private Long id;

    @OneToOne(mappedBy = "delivery", fetch = FetchType.LAZY)
    private Order order;

    @Embedded
    private Address address;

    @Enumerated(EnumType.STRING)   // ORDINAL 컬럼이 숫자대로 1, 2, 3, 4, 로 들어감
    private DeliveryStatus status; // READY, COMP
}
