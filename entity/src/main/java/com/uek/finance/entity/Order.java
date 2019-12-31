package com.uek.finance.entity;

import com.uek.finance.enumeration.OrderStatus;
import com.uek.finance.enumeration.OrderType;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 理财平台销售端-订单实体类
 */
@Data
public class Order implements Serializable {
    //订单ID
    private String orderId;
    //渠道ID
    private String chanId;
    //渠道用户ID
    private String chanUserId;
    //订单类型
    private String orderType;
    //产品ID
    private String productId;
    //购买金额
    private BigDecimal orderAmount;
    //外部订单ID
    private String outerOrderId;
    //订单状态
    private String orderStatus;
    //备注
    private String remark;
    //创建时间
    private Date createAt;
    //更新时间
    private Date updateAt;

    public void setOrderType(OrderType orderType) {
        this.orderType = orderType.name();
    }
    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus.name();
    }
}
