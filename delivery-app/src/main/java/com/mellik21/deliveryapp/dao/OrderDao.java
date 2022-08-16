package com.mellik21.deliveryapp.dao;

import com.mellik21.deliveryapp.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderDao extends JpaRepository<Order, Long> {

}
