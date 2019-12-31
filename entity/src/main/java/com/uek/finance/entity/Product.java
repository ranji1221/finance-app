package com.uek.finance.entity;

import com.uek.finance.enumeration.ProductStatus;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 理财平台管理端-金融产品实体类
 * 1.注意枚举的用法
 * 2.注意status状态的属性的处理
 *   setStatus()方法设置的是枚举的名字，即为英文字符串
 * @author RanJi
 */
@Data
@NoArgsConstructor
public class Product implements Serializable {
    //产品ID
    private String id;
    //产品名称
    private String name;
    //产品状态
    /*
     * @see ProductStatus枚举类
     */
    private String status ;
    //起投金额
    private BigDecimal startAmount ;
    //投资步长
    private BigDecimal stepAmount;
    //锁定期
    private Integer lockupPeriod;
    //收益率，因为要与其他数相乘，所以使用BigDecimal
    private BigDecimal earningRate;
    //备注
    private String remark;
    //产品创建时间
    private Date createAt;
    //产品更新时间
    private Date updateAt;
    //产品创建者
    private String createUser;
    //产品更新者
    private String updateUser;

    /**
     * 重要属性的多参构造器
     * @param id
     * @param name
     * @param status
     * @param startAmount
     * @param stepAmount
     * @param earningRate
     */
    public Product(String id, String name, ProductStatus status, BigDecimal startAmount, BigDecimal stepAmount, BigDecimal earningRate) {
        this.id = id;
        this.name = name;
        this.status = status.name();
        this.startAmount = startAmount;
        this.stepAmount = stepAmount;
        this.earningRate = earningRate;
    }

    public void setStatus(ProductStatus ps){
        this.status = ps.name();
    }
}


