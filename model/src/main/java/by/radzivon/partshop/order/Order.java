package by.radzivon.partshop.order;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class Order implements Serializable {
    private Long id;
    private List<PairPartQuantity> parts;
    private String name;
    private LocalDate orderTime;
    private LocalDate deliveryDate;
    private BigDecimal totalCost;
    private Long customerId;
    private OrderCondition condition;
    private LocalDate dateOfCompletion;
    private String note;
    private DeliveryCondition deliveryCondition;
}
