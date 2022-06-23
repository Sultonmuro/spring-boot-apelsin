package uz.pdp.springbootapelsin.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.sql.Timestamp;
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class PaymentDto {
    private  Integer id;
    private Timestamp timestamp;
    private BigDecimal amount;
    private Integer ord_id;
    private  Integer inv_id;
}
