package com.uek.finance.manager.service;

import com.uek.finance.entity.Product;
import com.uek.finance.enumeration.ProductStatus;
import com.uek.finance.manager.mapper.ProductMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * 理财产品业务实现类
 * @author RanJi
 */
@Service
public class ProductService implements IProductService {
    //-- 引入slf4j的日志，它是对log4j的再次封装，更加简单吧
    private Logger logger = LoggerFactory.getLogger(ProductService.class);

    @Resource   //-- 这里使用@Resource，因为Idea这个工具的问题，若使用@Autowired它会报错，其实没什么问题
    private ProductMapper productMapper;

    /**
     * 这里注意，真实开发中，一定要做后台数据的校验工作，记得前端是不可靠的，很容易被破解
     * @param product
     * @return
     */
    @Override
    public void addProduct(Product product) {
        //-- 1. 设置默认值
        setDefault(product);
        //-- 2. 校验产品数据的合法性
        checkProductData(product);
        //-- 3. 保存产品
        logger.info("添加产品：{}",product);
        productMapper.save(product);

    }

    @Override
    public void destoryProduct(String id) {
        productMapper.delete(id);
    }

    @Override
    public Product getProduct(String id) {
        return productMapper.find(id);
    }

    @Override
    public List<Product> getProducts() {
        return productMapper.findAll();
    }

    /**
     * 校验产品数据的合法性
     * 1. 非空数据
     * 2. 收益率要0-30以内
     * 3. 投资步长需为整数
     * @param product
     */
    private void checkProductData(Product product){
        Assert.notNull(product.getId(),"编号不可为空");
        Assert.isTrue(
                BigDecimal.ZERO.compareTo(product.getEarningRate())<0 && BigDecimal.valueOf(30).compareTo(product.getEarningRate())>=0,
                "收益率范围错误 0-30之间，不包含0");
        Assert.isTrue(
                new BigDecimal(product.getStepAmount().intValue()).compareTo(product.getStepAmount())==0,
                "投资步长需为整数"
        );
    }

    /**
     * 设置默认值
     * 创建时间、更新时间
     * 投资步长、锁定期、状态
     * @param product
     */
    private void setDefault(Product product) {
        if(product.getCreateAt()==null) product.setCreateAt(new Date());
        if(product.getUpdateAt()==null) product.setUpdateAt(new Date());
        if(product.getStepAmount()==null) product.setStepAmount(BigDecimal.ZERO);
        if(product.getLockupPeriod()==null) product.setLockupPeriod(0);
        if(product.getStatus()==null) product.setStatus(ProductStatus.AUDITING);
    }

}
