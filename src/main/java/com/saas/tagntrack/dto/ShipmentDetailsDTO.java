package com.saas.tagntrack.dto;

import com.saas.tagntrack.entity.ShipmentSatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
 * DTO class ShipmentDetailsDTO
 *
 * @Author bandlamudi manohar
 * @Date 03.05.2025
 * version 1.0.0
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class   ShipmentDetailsDTO {

    private Long shipmentId;
    private String shipmentName;
    private AddressDTO toAddressDTO;
    private ShipmentSatus shipmentStatus;
    private DeliveryPartnerDTO deliveryPartnerDTO;

}
