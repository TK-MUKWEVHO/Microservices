package com.teekay.orderservice.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="tbl_orders")
public class Order implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name="order_id")
    private UUID id;

    @Column(name = "order_number",unique = true,nullable = false)
    private String orderNumber;
    @OneToMany(cascade=CascadeType.ALL)
    private List<OrderLineItems> orderLineItems;

}
