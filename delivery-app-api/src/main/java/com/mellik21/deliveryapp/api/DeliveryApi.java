package com.mellik21.deliveryapp.api;

import com.mellik21.deliveryapp.api.dto.FoodAppOrderDto;
import com.mellik21.deliveryapp.api.dto.CreatedOrderDto;
import com.mellik21.deliveryapp.api.dto.OrderDto;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("v1")
public interface DeliveryApi {

    @GetMapping("/orders")
    @ApiOperation(value = "Получение списка заказов")
    List<OrderDto> getOrdersList();

    @GetMapping("/{id}")
    @ApiOperation(value = "Получение информации о заказе")
    @ApiImplicitParam(name = "id", value = "ID заказа", required = true)
    OrderDto getOrder(@PathVariable("id") String orderId);

    @ApiOperation(value = "Создание заказа")
    @ApiImplicitParam(
            name = "foodAppOrderDto",
            dataType = "FoodAppOrderDto",
            required = true,
            paramType = "body",
            value = "Создаем заказ с помощью food-app"
    )
    @PostMapping("/create")
    CreatedOrderDto createOrder(@RequestBody FoodAppOrderDto foodAppOrderDto);

    @ApiOperation(value = "Обновление заказа")
    @ApiImplicitParam(name = "employeeDto", value = "Dto сотрудника", required = true, paramType = "requestParam")
    @PutMapping("/update")
    void updateOrder(@RequestBody OrderDto orderDto);

    @ApiOperation(value = "Удаление заказа")
    @ApiImplicitParam(name = "orderDto", value = "Информация о заказе", required = true,
            dataType = "com.github.foodapp.api.dto.OrderDto", paramType = "requestBody")
    @DeleteMapping("/{id}")
    void deleteOrder(@RequestBody OrderDto orderDto);

}
