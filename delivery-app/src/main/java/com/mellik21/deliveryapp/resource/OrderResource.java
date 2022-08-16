package com.mellik21.deliveryapp.resource;

import com.mellik21.deliveryapp.api.DeliveryApi;
import com.mellik21.deliveryapp.api.dto.CreatedOrderDto;
import com.mellik21.deliveryapp.api.dto.FoodAppOrderDto;
import com.mellik21.deliveryapp.api.dto.OrderDto;
import com.mellik21.deliveryapp.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrderResource implements DeliveryApi {

    private final OrderService orderService;

    @Autowired
    public OrderResource(OrderService orderService) {
        this.orderService = orderService;
    }

    @Override
    public List<OrderDto> getOrdersList() {
        return null;
    }

    @Override
    public OrderDto getOrder(String orderId) {
        return null;
    }

    @Override
    public CreatedOrderDto createOrder(FoodAppOrderDto orderDto) {
        return orderService.createOrder(orderDto);
    }

    @Override
    public void updateOrder(OrderDto orderDto) {

    }

    @Override
    public void deleteOrder(OrderDto orderDto) {

    }
}
