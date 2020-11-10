package com.sobuj.repository;

import com.sobuj.models.OrderDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDetailsRepository  extends JpaRepository<OrderDetails,Long> {
}
