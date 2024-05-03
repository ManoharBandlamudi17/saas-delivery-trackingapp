package com.saas.tagntrack.service;

import com.saas.tagntrack.dto.ShipmentDetailsDTO;
import com.saas.tagntrack.repository.DeliveryPartnerRepository;
import com.saas.tagntrack.repository.ShipmentDetailsRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class DeliveryPartnerServiceTest {

    @Autowired
    private DeliveryPartnerService deliveryPartnerService;


    @MockBean
    private ShipmentDetailsRepository shipmentDetailsRepository;

    @MockBean
    DeliveryPartnerRepository deliveryPartnerRepository;

    @BeforeEach
    void setup() {
        deliveryPartnerService = Mockito.mock(DeliveryPartnerService.class);
        shipmentDetailsRepository = Mockito.mock(ShipmentDetailsRepository.class);
    }

    @Test
    void getAllShipmentsAssigned() {

        Mockito.when(shipmentDetailsRepository.findAllByDeliveryPartnerId(1L)).thenReturn(new ArrayList<>());

        List<ShipmentDetailsDTO> colShipmentDetailsDTO = deliveryPartnerService.getAllShipmentsAssigned(1L);
        Assertions.assertEquals(colShipmentDetailsDTO.size(), 0);
    }
}
