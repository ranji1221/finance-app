package com.uek.finance.entity;

import com.uek.finance.enumeration.ProductStatus;
import org.apache.log4j.Logger;
import org.junit.Test;
import java.util.Date;

/**
 * 实体测试类
 * @author RanJi
 */
public class ProductEntityTest {

   private Logger logger = Logger.getLogger(ProductEntityTest.class);

    //-- 若在Idea下报查找不到log4j.properties文件，那么我们可以使用下面的代码设置log4j.properties的位置
    /*
    {
        LogManager.resetConfiguration();
        PropertyConfigurator.configure(com.uek.finance.entity.TestEntity.class.getClassLoader().getResourceAsStream("log4j.properties"));
    }*/

    /**
     * 测试实体类的方法是否可用，毕竟用到了lombok框架
     */
    @Test
    public void testProduct(){
        Product product = new Product();
        product.setStatus(ProductStatus.AUDITING);
        product.setName("余额宝");
        product.setCreateAt(new Date());
        product.setCreateUser("ranji");
        logger.info(product);
    }
}
