package com.mellik21.deliveryapp.api.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
public class FoodAppOrderDto {

    @ApiModelProperty(notes = "ID Ресторана", example = "169866")
    Long restaurantId;

    @ApiModelProperty(notes = "Адрес", example = "ул.Пушкина, д.Колотушкина")
    String address;

    @ApiModelProperty(notes = "Комментарий", example = "можна пабыстрее??")
    String comment;

    @ApiModelProperty(notes = "Имя заказчика", example = "Евгений")
    String clientName;

    @ApiModelProperty(notes = "Время заказа", example = "2017-01-13T17:09:42.411")
    LocalDateTime creationDate;

}
