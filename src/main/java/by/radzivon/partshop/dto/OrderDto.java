package by.radzivon.partshop.dto;

import by.radzivon.partshop.entity.PairPartQuantity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Past;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDto {
    @NotEmpty
    @NotBlank
    private String name;
    private List<PairPartQuantity> parts;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @Past(message = "{valid.part.realiseDate.past}")
    private Date dateOfCompletion;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @Past(message = "{valid.part.realiseDate.past}")
    private Date deliveryDate;
    private String note;
}
