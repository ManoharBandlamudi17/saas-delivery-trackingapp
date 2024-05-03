package com.saas.tagntrack.service;

import com.saas.tagntrack.dto.AddressDTO;
import com.saas.tagntrack.dto.DeliveryPartnerDTO;
import com.saas.tagntrack.dto.ShipmentDetailsDTO;
import com.saas.tagntrack.entity.Address;
import com.saas.tagntrack.entity.DeliveryPartner;
import com.saas.tagntrack.entity.ShipmentDetails;
import com.saas.tagntrack.entity.ShipmentSatus;
import com.saas.tagntrack.repository.DeliveryPartnerRepository;
import com.saas.tagntrack.repository.ShipmentDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DeliveryPartnerService {

    @Autowired
    private ShipmentDetailsRepository shipmentDetailsRepository;

    @Autowired
    DeliveryPartnerRepository deliveryPartnerRepository;

    public List<ShipmentDetailsDTO> getAllShipmentsAssigned(Long deliveryPartnerId) {
        List<ShipmentDetailsDTO> colShipmentDetailsDTO = new ArrayList<>();
        List<ShipmentDetails> colShipmentDetails = shipmentDetailsRepository.findAllByDeliveryPartnerId(deliveryPartnerId);
        for (ShipmentDetails shipmentDetails : colShipmentDetails) {
            colShipmentDetailsDTO.add(createShipmentDetailsDTO(shipmentDetails));
        }
        return  colShipmentDetailsDTO;
    }

    public ShipmentDetailsDTO assignDeliveryPartnerToShipment(Long deliveryPartnerId, Long shipmentId) throws Exception {
        ShipmentDetailsDTO shipmentDetailsDTO = new ShipmentDetailsDTO();
        Optional<ShipmentDetails> shipmentDetails = shipmentDetailsRepository.findById(shipmentId);
        if (shipmentDetails.isPresent()) {
            ShipmentDetails shipmentDetail = shipmentDetails.get();
            Optional<DeliveryPartner> deliveryPartner = deliveryPartnerRepository.findById(deliveryPartnerId);
            if (deliveryPartner.isPresent()) {
                DeliveryPartner deliveryPartnerDetail = deliveryPartner.get();
                shipmentDetail.setDeliveryPartner(deliveryPartnerDetail);
                shipmentDetail.setShipmentStatus(ShipmentSatus.SHIPMENT_ALLOCATEDTO_DELIVERY_PARTNER);
                shipmentDetailsRepository.save(shipmentDetail);
                shipmentDetailsDTO = createShipmentDetailsDTO(shipmentDetail);
            } else {
                throw new Exception("No Delivery partner details found for the given id");
            }
        } else {
            throw new Exception("No shipment details found for the given id");
        }

        return shipmentDetailsDTO;
    }

    public DeliveryPartnerDTO addDeliveryPartner(DeliveryPartnerDTO deliveryPartnerDTO) {
        DeliveryPartner deliveryPartner = new DeliveryPartner();
        deliveryPartner.setDeliveryPartnerName(deliveryPartnerDTO.getDeliveryPartnerName());
        deliveryPartner.setDeliveryPartnerContactNumber(deliveryPartnerDTO.getDeliveryPartnerContactNumber());

        deliveryPartnerRepository.save(deliveryPartner);
        deliveryPartnerDTO.setDeliveryPartnerId(deliveryPartner.getDeliveryPartnerId());
        return  deliveryPartnerDTO;
    }

    public ShipmentDetailsDTO updateShiptmentDeliveryStatus(Long shipmentDetailsId, String status) throws Exception {
        Optional<ShipmentDetails> optShipmentDetails = shipmentDetailsRepository.findById(shipmentDetailsId);
        ShipmentDetailsDTO shipmentDetailsDTO = new ShipmentDetailsDTO();

        if(optShipmentDetails.isPresent()) {
            ShipmentDetails shipmentDetails = optShipmentDetails.get();
            shipmentDetails.setShipmentStatus(ShipmentSatus.valueOf(status));
            shipmentDetailsRepository.save(shipmentDetails);

            shipmentDetailsDTO = createShipmentDetailsDTO(shipmentDetails);
        } else {
            throw new Exception("No shipment details found for the given id");
        }

        return shipmentDetailsDTO;
    }

    private ShipmentDetailsDTO createShipmentDetailsDTO(ShipmentDetails shipmentDetails) {
        ShipmentDetailsDTO shipmentDetailsDTO = new ShipmentDetailsDTO();
        shipmentDetailsDTO.setShipmentId(shipmentDetails.getShipmentId());
        shipmentDetailsDTO.setShipmentName(shipmentDetails.getShipmentName());

        Address address = shipmentDetails.getToAddress();
        AddressDTO addressDTO = new AddressDTO();
        addressDTO.setAddressId(address.getAddressId());
        addressDTO.setCity(address.getCity());
        addressDTO.setState(address.getState());
        addressDTO.setCountry(address.getCountry());
        addressDTO.setZip(address.getZip());
        addressDTO.setContactNumber(address.getContactNumber());
        addressDTO.setDoorNo(address.getDoorNo());
        shipmentDetailsDTO.setToAddressDTO(addressDTO);

        DeliveryPartnerDTO deliveryPartnerDTO = new DeliveryPartnerDTO();
        deliveryPartnerDTO.setDeliveryPartnerId(shipmentDetails.getDeliveryPartner().getDeliveryPartnerId());
        deliveryPartnerDTO.setDeliveryPartnerName(shipmentDetails.getDeliveryPartner().getDeliveryPartnerName());
        deliveryPartnerDTO.setDeliveryPartnerContactNumber(shipmentDetails.getDeliveryPartner().getDeliveryPartnerContactNumber());
        return shipmentDetailsDTO;
    }
}
