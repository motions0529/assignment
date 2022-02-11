package com.tenbyten.assignment.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.tenbyten.assignment.domain.Order;
import com.tenbyten.assignment.domain.QOrder;
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
    public List<Order> getOrderList() {
        return queryFactory
                .selectFrom(order)
                .fetch();
    }
}
