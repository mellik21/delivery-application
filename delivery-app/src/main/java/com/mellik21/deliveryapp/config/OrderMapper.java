package com.mellik21.deliveryapp.config;


import com.mellik21.deliveryapp.api.dto.CreatedOrderDto;
import com.mellik21.deliveryapp.api.dto.OrderDto;
import com.mellik21.deliveryapp.model.Order;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
@Component
public interface OrderMapper {

    OrderDto toOrderDto(Order order);

    Order toOrder(OrderDto orderDto);

    CreatedOrderDto toCreatedOrderDto(Order order);



}
