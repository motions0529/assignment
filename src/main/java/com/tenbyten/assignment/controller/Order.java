//package com.tenbyten.assignment.controller;
//
//import com.tenbyten.assignment.dto.MemberFindByIdRequestDto;
//import com.tenbyten.assignment.dto.MemberFindByIdResponseDto;
//import com.tenbyten.assignment.repository.OrderRepository;
//import io.swagger.annotations.ApiOperation;
//import lombok.AllArgsConstructor;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import javax.validation.Valid;
//
//@RestController
//@AllArgsConstructor
//public class Order {
//
//    @ApiOperation(value = "단일 회원 상세 정보 조회" , response = OrderFindAllResponseDto.class)
//    @GetMapping("/orders")
//    public ResponseEntity<?> getOrderList(@Valid OrderFindAllRequestDto dto) {
//        return ResponseEntity.ok(OrderRepository.getOrderList(dto));
//    }
//}
