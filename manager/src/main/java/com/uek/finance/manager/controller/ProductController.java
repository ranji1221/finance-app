package com.uek.finance.manager.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.uek.finance.entity.Product;
import com.uek.finance.manager.service.IProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 产品控制器类
 * @author RanJi
 */
@RestController
@RequestMapping(value = "/product")     //-- 这个地方要加value属性指定值，否则映射不成功，版本的问题
public class ProductController {

    private Logger logger = LoggerFactory.getLogger(ProductController.class);

    @Autowired
    private IProductService productService;

    @PostMapping("/add")
    public String addProduct(@RequestBody Product product){
        //-- 1. 添加产品
        productService.addProduct(product);
        //-- 2. 返回信息
        JSONObject jo = new JSONObject();
        jo.put("msg","success");
        jo.put("status","ok");
        return jo.toJSONString();
    }

    @GetMapping("/{id}")
    public String getProduct(@PathVariable String id){
        logger.info("查询产品，id={}",id);
        Product product = productService.getProduct(id);
        logger.info("查询产品，结果={}",product);
        return JSON.toJSONString(product);
    }

    @GetMapping("/list")
    public String getProducts(@PathVariable String id){
        return null;
    }
}
