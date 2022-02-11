package com.tenbyten.assignment.domain;

import io.swagger.annotations.ApiModelProperty;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


import javax.persistence.*;

import java.time.LocalDateTime;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Getter
@Table(name = "orderinfo")
public class Order {
    @Id
    @Column(length = 12, nullable = false)
    @ApiModelProperty(value ="주문번호")
    private String orderserial;

    @Column(nullable = false)
    @ApiModelProperty(value ="회원번호")
    private Long memberid;

    @Column(length = 100, nullable = false)
    @ApiModelProperty(value ="제품이름")
    private String productname;

    @Column(name = "DATE_FIELD", nullable = false)
    @ApiModelProperty(value ="결제일시")
    private LocalDateTime paymentdate;

    @Builder
    public Order(String orderserial , String productname , LocalDateTime paymentdate , Long memberid) {
        this.orderserial = orderserial;
        this.productname = productname;
        this.paymentdate = paymentdate;
        this.memberid = memberid;
    }
}
