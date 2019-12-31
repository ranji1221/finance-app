package com.uek.finance.manager.service;

import com.uek.finance.entity.Product;
import java.util.List;

/**
 * 理财产品类业务接口
 * @author RanJi
 */
public interface IProductService {
    void addProduct(Product product);
    void destoryProduct(String id);
    Product getProduct(String id);
    List<Product> getProducts();
}
