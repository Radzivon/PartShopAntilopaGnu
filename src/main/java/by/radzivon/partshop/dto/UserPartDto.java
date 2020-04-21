package by.radzivon.partshop.dto;

import by.radzivon.partshop.entity.enums.PartCondition;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

@Getter
@Setter
public class UserPartDto {
    private long id;
    private String name;
    private BigDecimal price;
    private Date realiseFrom;
    private Date realiseTo;
    private PartCondition condition;
    private String description;
    private int quantity;

    private Set<PhotoDto> photos;
    private long userPartId;
    private long orderId;
}
