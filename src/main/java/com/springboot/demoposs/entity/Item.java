package com.springboot.demoposs.entity;

import com.springboot.demoposs.entity.enums.MesuringUnitType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;

import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "item")

public class Item {
    @Id
    @Column(name = "item_id",length=10)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int itemId;

    @Column(name = "item_name",length=200,nullable=false)
    private String itemName;

    @Enumerated(EnumType.STRING)
    @Column(name = "measure_type",length=100,nullable=false)
    private MesuringUnitType mesuringUnitType;

    @Column(name = "balnce_qty",length=100,nullable=false)
    private double balnceQty;

    @Column(name = "supplier_price",length=100,nullable=false)
    private double supplierPrice;

    @Column(name = "selling_price",length=100,nullable=false)
    private double sellingPrice;

    @Column(name = "active_state",columnDefinition = "TINYINT default 1")
    private boolean activeState = true;

    @OneToMany(mappedBy="items")
    private Set<OrderDetails> orderDetails;

}
