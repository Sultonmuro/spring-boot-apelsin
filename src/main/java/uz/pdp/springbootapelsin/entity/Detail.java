package uz.pdp.springbootapelsin.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
@Table(name = "detail")

public class Detail {
    @Id //primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "ord_id")
    private Order order;
    @ManyToOne //table ichida uztun yasidi
    @JoinColumn(name="pr_id")
    private Product product;
    private Integer quantity;
}
