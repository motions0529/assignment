package com.tenbyten.assignment.repository;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.tenbyten.assignment.domain.Order;
import com.tenbyten.assignment.domain.QOrder;
import com.tenbyten.assignment.dto.OrderFindAllRequestDto;
import com.tenbyten.assignment.dto.OrderFindByIdRequestDto;
import com.tenbyten.assignment.dto.OrderFindByIdResponseDto;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class OrderRepositoryImpl implements OrderRepositoryCustom {

    private final JPAQueryFactory queryFactory;
    private QOrder order = QOrder.order;

    public OrderRepositoryImpl(JPAQueryFactory queryFactory) {
        this.queryFactory = queryFactory;
    }

    @Override
    public List<OrderFindByIdResponseDto> getOrderList(OrderFindAllRequestDto dto) {
        return queryFactory
                .select(Projections.constructor(OrderFindByIdResponseDto.class,
                        order.orderserial,
                        order.memberid,
                        order.productname,
                        order.paymentdate))
                .from(order)
                .fetch();
    }

    @Override
    public List<OrderFindByIdResponseDto> getOrderFindById(OrderFindByIdRequestDto dto) {

        return queryFactory
                .select(Projections.constructor(OrderFindByIdResponseDto.class,
                        order.orderserial,
                        order.memberid,
                        order.productname,
                        order.paymentdate))
                .from(order)
                .where(order.memberid.eq(dto.getMemberid()))
                .fetch();
    }
}
