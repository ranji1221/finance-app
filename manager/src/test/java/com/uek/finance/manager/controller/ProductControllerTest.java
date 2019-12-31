package com.uek.finance.manager.controller;

import com.uek.finance.entity.Product;
import com.uek.finance.enumeration.ProductStatus;
import com.uek.finance.manager.ManagerApplication;
import com.uek.finance.manager.mapper.ProductMapper;
import com.uek.finance.manager.service.IProductService;
import com.uek.finance.util.RestUtil;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;
import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * 产品控制器单元测试
 * @author RanJi
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@FixMethodOrder(MethodSorters.JVM)      //-- 改变JUnit执行顺序，默认是按照方法字母顺序，我们让它按照方法定义的执行顺序执行
public class ProductControllerTest {
    private static Logger logger = LoggerFactory.getLogger(ProductControllerTest.class);
    //-- web client
    @Autowired
    private RestTemplate rt ;
    //-- ${local.server.port} 获取的是根据WebEnvironment.RANDOM_PORT得到的
    @Value("http://localhost:${local.server.port}/manager")
    private String baseUrl;

    @Autowired
    private  IProductService productService;

    //-- 正常产品数据
    private static List<Product> products = new ArrayList<Product>();

    //-- 初始化方法必须static
    @BeforeClass
    public static void init(){
        logger.info("初始化产品数据");
        Product p1 = new Product("R001","戴代宝", ProductStatus.AUDITING, BigDecimal.valueOf(1000),BigDecimal.valueOf(10),BigDecimal.valueOf(3.83));
        Product p2 = new Product("R002","学生宝", ProductStatus.AUDITING, BigDecimal.valueOf(1000),BigDecimal.valueOf(10),BigDecimal.valueOf(5.66));
        Product p3 = new Product("R003","财富猫", ProductStatus.AUDITING, BigDecimal.valueOf(1000),BigDecimal.valueOf(10),BigDecimal.valueOf(7.87));
        products.add(p1);products.add(p2);products.add(p3);
    }

    @Test
    public void addProducts(){
        products.forEach(product -> {
            String result = RestUtil.postJSON(rt,baseUrl+"/product/add",product);
            logger.info("返回结果：{}",result);
        });
    }

    @Test
    public void getProduct(){
        String result = rt.getForObject(baseUrl+"/product/R001",String.class);
        logger.info("返回结果：{}",result);
    }

    //-- 销毁产品，不留痕迹
    @Test
    public void clearProducts(){
        productService.destoryProduct("R001");
        productService.destoryProduct("R002");
        productService.destoryProduct("R003");
    }
}
