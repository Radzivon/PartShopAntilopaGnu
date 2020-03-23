package by.radzivon.partshop.entity;

import by.radzivon.partshop.entity.enums.DeliveryCondition;
import by.radzivon.partshop.entity.enums.OrderCondition;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@Entity
@Table(name = "orders")
public class Order implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    @OneToMany
    private List<PairPartQuantity> parts;
    private Date orderTime;
    private Date deliveryDate;
    private BigDecimal totalCost;
    @ManyToOne
    private User user;
    @Enumerated(EnumType.STRING)
    private OrderCondition condition;
    private Date dateOfCompletion;
    private String note;
    private DeliveryCondition deliveryCondition;
}
