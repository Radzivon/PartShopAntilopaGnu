package by.radzivon.partshop.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PairPartQuantityDto {
    private long id;
    private int quantity;
    private long partId;
    private long orderId;
}
