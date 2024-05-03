package com.saas.tagntrack.repository;

import com.saas.tagntrack.entity.ShipmentDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/*
 * Interface ShipmentDetailsRepository
 *
 * @Author bandlamudi manohar
 * @Date 03.05.2025
 * version 1.0.0
 **/
@Repository
public interface ShipmentDetailsRepository extends JpaRepository<ShipmentDetails, Long> {

    @Query(value = "select sd from SipmentDetails sd join DeliveryPartner dp on sd.deliveryPartner.deliveryPartnerId = dp.deliveryPartnerId where dp.deliveryPartnerId = ?1", nativeQuery = true)
    List<ShipmentDetails> findAllByDeliveryPartnerId(Long deliveryPartnerId);
}
