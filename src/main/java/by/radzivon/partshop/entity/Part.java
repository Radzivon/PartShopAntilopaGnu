package by.radzivon.partshop.entity;

import by.radzivon.partshop.entity.enums.PartCondition;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;


@Entity
@Table(name = "part")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
public class Part implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "part_id")
    private Long id;
    private String category;
    private String model;
    private BigDecimal price;
    private Date realiseDate;
    @Enumerated(EnumType.STRING)
    private PartCondition condition;
    private String description;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "part", cascade = CascadeType.ALL)
    private Stock stock;

    @OneToMany(mappedBy = "part", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Photo> photos;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "brand_id")
    private Brand brand;
}
