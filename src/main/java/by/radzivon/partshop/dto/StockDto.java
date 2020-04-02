package by.radzivon.partshop.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StockDto {
    private long id;
    private int stock;
    private long partId;
}
