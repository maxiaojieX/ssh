package com.ma.service;

import com.ma.dao.ProductDao;
import com.ma.pojo.Product;
import com.ma.util.Page;
import com.ma.util.RequestHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Administrator on 2017/12/1 0001.
 */
@Service
@Transactional(rollbackFor = RuntimeException.class)
public class ProductService {

    @Autowired
    private ProductDao productDao;


    /**
     * 根据id删除
     * @param id
     */
    public void delById(Integer id) {
        productDao.deletById(id);
    }

    /**
     * 根据id查找
     * @param id
     * @return
     */
    public Product findById(Integer id) {
        return productDao.findById(id);
    }

    /**
     * 保存
     * @param product
     */
    public void saveOrUpdate(Product product) {
        productDao.save(product);
    }

    /**
     * 分页查询
     * @param requestHandlerList
     * @param pageNum
     * @return
     */
    public Page<Product> findLimit(List<RequestHandler> requestHandlerList, Integer pageNum) {
        return productDao.findByConditionAndLimit(requestHandlerList,pageNum);
    }

}
