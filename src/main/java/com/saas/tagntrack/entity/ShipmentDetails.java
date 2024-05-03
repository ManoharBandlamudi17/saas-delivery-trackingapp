package com.saas.tagntrack.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/*
 * class ShipmentDetails
 *
 * @Author bandlamudi manohar
 * @Date 03.05.2025
 * version 1.0.0
 **/
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShipmentDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long shipmentId;
    private String shipmentName;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="addressId")
    private Address toAddress;

    @Enumerated(EnumType.STRING)
    private ShipmentSatus shipmentStatus;

    @ManyToOne
    @JoinColumn(name = "deliveryPartnerId")
    private DeliveryPartner deliveryPartner;
}
