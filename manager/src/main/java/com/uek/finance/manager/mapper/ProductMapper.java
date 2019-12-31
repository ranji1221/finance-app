package com.uek.finance.manager.mapper;

import com.uek.finance.entity.Product;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 产品持久化类
 * @author RanJi
 */
@Mapper
public interface ProductMapper {
    void save(Product product);
    void delete(@Param("id") String id);
    Product find(@Param("id") String id);
    List<Product> findAll();
}
