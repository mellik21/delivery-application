package com.mellik21.deliveryapp.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Builder
@Entity
@Data
@NoArgsConstructor
@Table(name = "\"courier\"")
@AllArgsConstructor
public class Courier {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "order_generator")
    @SequenceGenerator(name = "order_generator", sequenceName = "\"order_id_seq\"")
    private Long id;

    @Column
    private String name;

    @Column
    private String district; //city etc

    @Column
    private Boolean available;

    @OneToMany(cascade = {CascadeType.ALL}, mappedBy = "courier")
    List<Order> orders;
}