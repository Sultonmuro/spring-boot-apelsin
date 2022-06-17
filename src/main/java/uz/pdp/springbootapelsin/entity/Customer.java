package uz.pdp.springbootapelsin.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
@Table(name = "Customer")
public class Customer {
    // customer
    @Id //primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
@Column(nullable = false,length = 14)
    private String name;
 @Column(nullable = false,length = 3)
private String country;
@Column(columnDefinition = "text")
    private String address; //255ta dan belgilarni qabul qila oladi
    @Column(length = 50)
    private String phone;


}

