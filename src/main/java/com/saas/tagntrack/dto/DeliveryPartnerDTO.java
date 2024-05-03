package com.saas.tagntrack.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
 * DTO class DeliveryPartnerDTO
 *
 * @Author bandlamudi manohar
 * @Date 03.05.2025
 * version 1.0.0
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeliveryPartnerDTO {
    private Long deliveryPartnerId;
    private String deliveryPartnerName;
    private String deliveryPartnerContactNumber;
}
