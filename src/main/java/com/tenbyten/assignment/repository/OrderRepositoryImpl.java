package com.tenbyten.assignment.repository;

import com.querydsl.core.QueryResults;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.JPAExpressions;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.tenbyten.assignment.domain.QMember;
import com.tenbyten.assignment.domain.QOrder;
import com.tenbyten.assignment.dto.OrderFindAllRequestDto;
import com.tenbyten.assignment.dto.OrderFindAllResponseDto;
import com.tenbyten.assignment.dto.OrderFindByIdRequestDto;
import com.tenbyten.assignment.dto.OrderFindByIdResponseDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import org.springframework.util.ObjectUtils;

import java.util.List;

@Repository
public class OrderRepositoryImpl implements OrderRepositoryCustom {

    private final JPAQueryFactory queryFactory;
    private final QOrder order = QOrder.order;
    private final QOrder order2 = new QOrder("order2");
    private final QMember member = QMember.member;

    public OrderRepositoryImpl(JPAQueryFactory queryFactory) {
        this.queryFactory = queryFactory;
    }

    @Override
    public Page<OrderFindAllResponseDto> getOrderList(OrderFindAllRequestDto dto, Pageable pageable) {
        QueryResults<OrderFindAllResponseDto> results = queryFactory
                .select(Projections.constructor(OrderFindAllResponseDto.class,
                        order.orderserial,
                        order.memberid,
                        order.productname,
                        order.paymentdate))
                .from(order)
                    .leftJoin(member).on(member.id.eq(order.memberid))
                .where(eqName(dto.getName()),
                        eqEmail(dto.getEmail()),
                        eqLastOrder(dto.getActive()))
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetchResults();

        return new PageImpl<>(results.getResults() , pageable ,results.getTotal());
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

    private BooleanExpression eqName(String name) {
        if (ObjectUtils.isEmpty(name)) {
            return null;
        }
        return member.name.eq(name);
    }

    private BooleanExpression eqEmail(String email) {
        if (ObjectUtils.isEmpty(email)) {
            return null;
        }
        return member.email.eq(email);
    }

    private BooleanExpression eqLastOrder(String active) {
        if (ObjectUtils.isEmpty(active)) {
            return null;
        }
        return order.paymentdate.eq(JPAExpressions.selectOne().select(order2.paymentdate.max())
                                    .from(order2)
                                    .where(order2.memberid.eq(order.memberid)));
    }
}
