package by.radzivon.partshop.entity;

import by.radzivon.partshop.entity.enums.DeliveryCondition;
import by.radzivon.partshop.entity.enums.OrderCondition;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "orders")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
public class Order implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "order_id")
    private Long id;
    private String name;
    private Date orderTime;
    private Date deliveryDate;
    private BigDecimal totalCost;
    @Enumerated(EnumType.STRING)
    private OrderCondition condition;
    private DeliveryCondition deliveryCondition;
    private Date dateOfCompletion;
    private String note;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "order")
    private Set<PairPartQuantity> parts;
}
