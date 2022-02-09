package com.tenbyten.assignment.domain;

import io.swagger.annotations.ApiModelProperty;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


import javax.persistence.*;

import java.util.Date;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Getter
public class Orders {
    @Id
    @Column(length = 12, nullable = false)
    @ApiModelProperty(value ="주문번호")
    private String orderserial;
    @Column(length = 100, nullable = false)
    @ApiModelProperty(value ="제품이름")
    private String productname;
    @Column(name = "DATE_FIELD", nullable = false)
    @Temporal(TemporalType.DATE)
    @ApiModelProperty(value ="결제일시")
    private Date paymentdate;

    @Builder
    public Orders(String orderserial , String productname , Date paymentdate) {
        this.orderserial = orderserial;
        this.productname = productname;
        this.paymentdate = paymentdate;
    }
}
