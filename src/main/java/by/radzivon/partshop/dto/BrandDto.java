package by.radzivon.partshop.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class BrandDto {
    private long id;
    private String name;
}
