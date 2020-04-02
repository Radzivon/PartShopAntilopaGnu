package by.radzivon.partshop.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class BrandDto {
    private long id;
    private String name;

    private Set<PartDto> parts;
}
