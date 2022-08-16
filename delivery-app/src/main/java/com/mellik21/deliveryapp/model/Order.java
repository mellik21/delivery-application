package com.mellik21.deliveryapp.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Builder
@Entity
@Data
@NoArgsConstructor
@Table(name = "\"order\"")
@AllArgsConstructor
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "order_generator")
    @SequenceGenerator(name = "order_generator", sequenceName = "\"order_id_seq\"")
    private Long id;

    @Column(name = "restaurant_id")
    private Long restaurantId;

    @Column
    private String address;

    @Column
    private String comment;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "courier_id")
    private Courier courier;

    @Column
    LocalDateTime creationDate;

}