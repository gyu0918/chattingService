package jpabook.jpashop.domain;


import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Member {
    @Id @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    private String name;

    @Embedded
    private Address address;

    @OneToMany(mappedBy = "member")  // Order테이블에 있는 member에 의해서 매핑된거라는걸 의미한다. 읽기전용이다 의미
    private List<Order> orders = new ArrayList<>();




}
