package by.radzivon.partshop.dto;

import by.radzivon.partshop.entity.enums.PartCondition;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PartDto {
    private long id;
    private String category;
    private String model;
    private BigDecimal price;
    private Date realiseDate;
    private PartCondition condition;
    private String description;
    @JsonIgnore
    private Set<UserPartDto> pairPartQuantityList;
    private long stockId;
    private Set<PhotoDto> photos;
    private long brandId;
}
