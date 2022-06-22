package uz.pdp.springbootapelsin.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data

public class OrderDto {
    private Integer id;
    private Date date;
    private Integer cust_id;
    private BigDecimal amount;
}
