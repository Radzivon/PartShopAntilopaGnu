package by.radzivon.partshop.order;

import by.radzivon.partshop.part.Part;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class PairPartQuantity {
    private Part part;
    private int quantity;
}
