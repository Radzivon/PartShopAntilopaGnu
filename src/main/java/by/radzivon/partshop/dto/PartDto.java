package by.radzivon.partshop.dto;

import by.radzivon.partshop.entity.Brand;
import by.radzivon.partshop.entity.Photo;
import by.radzivon.partshop.entity.Stock;
import by.radzivon.partshop.entity.enums.PartCondition;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Currency;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class PartDto {
    private Long id;
    @NotNull(message = "{valid.part.category}")
    @NotBlank
    private String category;
    @NotNull(message = "{valid.part.brand}")
    private String brand;
    @NotNull(message = "{valid.part.model}")
    private String model;
    @NotNull(message = "{valid.part.price}")
    private BigDecimal price;
    @NotNull(message = "{valid.part.stock}")
    private int stock;
    //    @NotNull(message = "{valid.category}")
//    @NotEmpty(message = "{valid.category}")
//    private List<Photo> photos;
//    @NotNull(message = "{valid.part.realiseDate}")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @Past(message = "{valid.part.realiseDate.past}")
    private Date realiseDate;
    @NotNull(message = "{valid.part.condition}")
    private PartCondition condition;
    @NotNull(message = "{valid.part.description}")
    private String description;
}
