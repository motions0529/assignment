package com.tenbyten.assignment.dto;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class OrderFindAllResponseDto {
    private String orderserial;
    private Long memberid;
    private String productname;
    private LocalDateTime paymentdate;

    @QueryProjection
    public OrderFindAllResponseDto(String orderserial , Long memberid , String productname , LocalDateTime paymentdate) {
        this.orderserial = orderserial;
        this.memberid = memberid;
        this.productname = productname;
        this.paymentdate = paymentdate;
    }
}
