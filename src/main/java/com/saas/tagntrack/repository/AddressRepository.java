package com.saas.tagntrack.repository;

import com.saas.tagntrack.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/*
 * Interface AddressRepository
 *
 * @Author bandlamudi manohar
 * @Date 03.05.2025
 * version 1.0.0
 **/
@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {
}
