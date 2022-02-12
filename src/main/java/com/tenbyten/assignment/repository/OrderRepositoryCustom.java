package com.tenbyten.assignment.repository;

import com.tenbyten.assignment.domain.Order;
import com.tenbyten.assignment.dto.OrderFindAllRequestDto;
import com.tenbyten.assignment.dto.OrderFindAllResponseDto;
import com.tenbyten.assignment.dto.OrderFindByIdRequestDto;
import com.tenbyten.assignment.dto.OrderFindByIdResponseDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface OrderRepositoryCustom {
    Page<OrderFindAllResponseDto> getOrderList(OrderFindAllRequestDto dto, Pageable pageable);

    List<OrderFindByIdResponseDto> getOrderFindById(OrderFindByIdRequestDto dto);
}
