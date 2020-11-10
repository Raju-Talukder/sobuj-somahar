package com.sobuj.repository;

import com.sobuj.models.ShippingInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShippingInfoRepository  extends JpaRepository<ShippingInfo,Long> {
}
