package com.tenbyten.assignment.controller;

import com.tenbyten.assignment.dto.OrderFindAllRequestDto;
import com.tenbyten.assignment.dto.OrderFindByIdRequestDto;
import com.tenbyten.assignment.repository.OrderRepositoryImpl;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@AllArgsConstructor
public class Order {

    private final OrderRepositoryImpl orderRepository;

    @ApiOperation(value = "단일 회원의 주문 목록 조회")
    @GetMapping("/orders/")
    public ResponseEntity<?> getOrderFindById(@Valid OrderFindByIdRequestDto dto) {
        return ResponseEntity.ok(orderRepository.getOrderFindById(dto));
    }

    @ApiOperation(value = "전체 주문 목록 조회")
    @GetMapping("/orders")
    public ResponseEntity<?> getOrderList(@Valid OrderFindAllRequestDto dto) {
        return ResponseEntity.ok(orderRepository.getOrderList(dto));
    }
}
