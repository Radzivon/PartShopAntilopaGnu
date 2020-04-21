package by.radzivon.partshop.dto;

import by.radzivon.partshop.entity.enums.DeliveryCondition;
import by.radzivon.partshop.entity.enums.OrderCondition;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDto {
    private long id;
    private BigDecimal totalCost;
    @Enumerated(EnumType.STRING)
    private OrderCondition condition;
    private DeliveryCondition deliveryCondition;
    private String name;
    private Set<UserPartDto> parts;
    private Date dateOfCompletion;
    private Date deliveryDate;
    private String note;

    private long userId;

}
