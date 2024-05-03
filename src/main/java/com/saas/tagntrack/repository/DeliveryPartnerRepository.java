package com.saas.tagntrack.repository;

import com.saas.tagntrack.entity.DeliveryPartner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/*
 * Interface DeliveryPartnerRepository
 *
 * @Author bandlamudi manohar
 * @Date 03.05.2025
 * version 1.0.0
 **/
@Repository
public interface DeliveryPartnerRepository extends JpaRepository<DeliveryPartner, Long> {
}
