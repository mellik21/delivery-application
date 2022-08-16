package com.mellik21.deliveryapp.service;

import com.mellik21.deliveryapp.api.dto.CreatedOrderDto;
import com.mellik21.deliveryapp.api.dto.FoodAppOrderDto;
import com.mellik21.deliveryapp.config.OrderMapper;
import com.mellik21.deliveryapp.dao.CourierDao;
import com.mellik21.deliveryapp.dao.OrderDao;
import com.mellik21.deliveryapp.model.Courier;
import com.mellik21.deliveryapp.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.Random;

@Service
public class OrderService {

    private final OrderDao orderDao;
    private final CourierDao courierDao;
    private final OrderMapper orderMapper;

    @Autowired
    public OrderService(OrderDao orderDao, CourierDao courierDao, OrderMapper orderMapper) {
        this.orderDao = orderDao;
        this.courierDao = courierDao;
        this.orderMapper = orderMapper;
    }

    @Transactional
    public CreatedOrderDto createOrder(FoodAppOrderDto orderDto) {

        Courier courier = getAvailableCourier();

        Order order = Order.builder()
                .address(orderDto.getAddress())
                .comment(orderDto.getComment())
                .restaurantId(orderDto.getRestaurantId())
                .courier(courier)
                .creationDate(LocalDateTime.now())
                .build();

        order = orderDao.save(order);

        CreatedOrderDto createdOrderDto = orderMapper.toCreatedOrderDto(order);
        createdOrderDto.setCourierName(courier.getName());
        createdOrderDto.setExpectedDeliveryTime(LocalDateTime.now().plusHours(1));

        return createdOrderDto;
    }


    private Courier getAvailableCourier() {

        Random random = new Random(6);
        Long randomId = random.nextLong();

        return courierDao.findById(randomId).orElseThrow(
                () -> new RuntimeException("Sorry there is no available couriers now")
        );
    }
}
