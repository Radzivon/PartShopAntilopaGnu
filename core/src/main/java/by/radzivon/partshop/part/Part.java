package by.radzivon.partshop.part;

import by.radzivon.partshop.photo.Photo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Currency;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class Part implements Serializable {
    private Long id;
    private String name;
    private String brand;
    private String model;
    private BigDecimal price;
    private Currency currency;
    private int stock;
    private List<Photo> photos;
    private LocalDate realiseDate;
    private int idColor;
    private PartCondition condition;
    private String description;
}
