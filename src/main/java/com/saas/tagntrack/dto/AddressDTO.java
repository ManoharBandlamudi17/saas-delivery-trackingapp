package com.saas.tagntrack.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
 * DTO class AddressDTO
 *
 * @Author bandlamudi manohar
 * @Date 03.05.2025
 * version 1.0.0
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressDTO {
    private Long addressId;
    private String doorNo;
    private String street;
    private String city;
    private String state;
    private String country;
    private String zip;
    private String contactNumber;
}
