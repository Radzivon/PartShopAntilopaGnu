package by.radzivon.partshop.entity;

import by.radzivon.partshop.entity.enums.PartCondition;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Currency;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@Entity
@Table(name = "part")
public class Part implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column
    private String category;
  //  @OneToOne(optional = false, cascade = CascadeType.ALL, mappedBy = "part")
    @Column
    private String brand;
    @Column
    private String model;
    @Column
    private BigDecimal price;
   // @OneToOne(optional = false, cascade = CascadeType.ALL, mappedBy = "part")
    private int stock;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "part")
    private List<Photo> photos;
    @Column
    private Date realiseDate;
    @Enumerated(EnumType.STRING)
    private PartCondition condition;
    @Column
    private String description;
    @OneToOne
    private PairPartQuantity pairPartQuantity;
}
