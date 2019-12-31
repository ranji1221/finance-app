package com.uek.finance.enumeration;

/**
 * 订单状态枚举类型
 * @author RanJi
 */
public enum OrderStatus {
    INIT("初始化"),PROCESS("处理中"),SUCCESS("成功"),FAIL("失败");

    private String desc;

    OrderStatus(String desc){
        this.desc = desc;
    }

    public String getDesc(){
        return desc;
    }
}
