package com.mellik21.deliveryapp.dao;


import com.mellik21.deliveryapp.model.Courier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourierDao extends JpaRepository<Courier, Long> {

}