package com.saas.tagntrack.service;

import com.saas.tagntrack.dto.AddressDTO;
import com.saas.tagntrack.dto.ShipmentDetailsDTO;
import com.saas.tagntrack.entity.Address;
import com.saas.tagntrack.entity.ShipmentDetails;
import com.saas.tagntrack.entity.ShipmentSatus;
import com.saas.tagntrack.repository.AddressRepository;
import com.saas.tagntrack.repository.ShipmentDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class ShipmentService {


    @Autowired
    private ShipmentDetailsRepository shipmentDetailsRepository;

    @Autowired
    private AddressRepository addressRepository;


    @Transactional
    public ShipmentDetailsDTO addNewShipmentDetails(ShipmentDetailsDTO shipmentDetailsDTO) {
        ShipmentDetails shipmentDetails = new ShipmentDetails();

        shipmentDetails.setShipmentName(shipmentDetailsDTO.getShipmentName());
        shipmentDetails.setShipmentStatus(ShipmentSatus.SHIPMENT_PENDING_DELIVERY_PARTNER_ALLOCATION);

        AddressDTO toAddressDTO = shipmentDetailsDTO.getToAddressDTO();
        Address address = new Address();
        address.setCity(toAddressDTO.getCity());
        address.setState(toAddressDTO.getState());
        address.setCountry(toAddressDTO.getCountry());
        address.setDoorNo(toAddressDTO.getDoorNo());
        address.setZip(toAddressDTO.getZip());
        address.setStreet(toAddressDTO.getStreet());
        address.setContactNumber(toAddressDTO.getContactNumber());
        addressRepository.save(address);
        shipmentDetails.setToAddress(address);
        shipmentDetailsDTO.getToAddressDTO().setAddressId(address.getAddressId());

        shipmentDetailsRepository.save(shipmentDetails);
        shipmentDetailsDTO.setShipmentId(shipmentDetails.getShipmentId());
        return shipmentDetailsDTO;
    }

}
