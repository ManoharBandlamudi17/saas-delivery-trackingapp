package com.saas.tagntrack.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/*
 * class DeliveryPartner
 *
 * @Author bandlamudi manohar
 * @Date 03.05.2025
 * version 1.0.0
 **/
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeliveryPartner {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long deliveryPartnerId;
    private String deliveryPartnerName;
    private String deliveryPartnerContactNumber;
    @OneToMany(mappedBy = "deliveryPartner", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ShipmentDetails> colShipmentDetails = new ArrayList<>();
}
