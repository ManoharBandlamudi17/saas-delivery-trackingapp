package com.saas.tagntrack.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/*
 * class Address
 *
 * @Author bandlamudi manohar
 * @Date 03.05.2025
 * version 1.0.0
 **/
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long addressId;
    private String doorNo;
    private String street;
    private String city;
    private String state;
    private String country;
    private String zip;
    private String contactNumber;

    @OneToOne(mappedBy = "toAddress")
    private ShipmentDetails shipmentDetails;
}
