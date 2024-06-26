package jpabook.jpashop.domain.item;

import jakarta.persistence.*;
//import jpabook.jpashop.exception.NotEnoughStockException;
import jpabook.jpashop.domain.Category;
import jpabook.jpashop.exception.NotEnoughStockException;
import lombok.Getter;
import lombok.Setter;

//import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "dtype")
@Getter @Setter
public abstract class Item {

    @Id
    @GeneratedValue
    @Column(name = "item_id")
    private Long id;

    private String name;
    private int price;
    private int stockQuantity;

    @ManyToMany(mappedBy = "items")
    private List<Category> categories = new ArrayList<>();


    //이렇게 엔티티에 비지니스 로직이 들어가 있는게 좋다
    //==비지니스로직==//

    //재고 수량을 증가 시키는 로직 (stock 증가)
    public void addStock(int quantity){
        this.stockQuantity += quantity;
    }

    //재고 수량 감소 시키는 로직(stock 감소)
    public void removeStock(int quantity){
       int restStock = this.stockQuantity - quantity;
       if (restStock < 0){
           throw new NotEnoughStockException("need more stock");
       }
       this.stockQuantity = restStock;
    }
}
