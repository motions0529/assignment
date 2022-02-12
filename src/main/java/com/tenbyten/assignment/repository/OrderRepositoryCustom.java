package com.tenbyten.assignment.repository;

import com.tenbyten.assignment.domain.Order;
import com.tenbyten.assignment.dto.OrderFindAllRequestDto;
import com.tenbyten.assignment.dto.OrderFindByIdRequestDto;
import com.tenbyten.assignment.dto.OrderFindByIdResponseDto;

import java.util.List;

public interface OrderRepositoryCustom {
    List<OrderFindByIdResponseDto> getOrderList(OrderFindAllRequestDto dto);

    List<OrderFindByIdResponseDto> getOrderFindById(OrderFindByIdRequestDto dto);
}
