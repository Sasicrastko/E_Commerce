package com.rastkosasic.shop.service;


import java.util.List;

import javax.transaction.Transactional;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
 

import com.rastkosasic.shop.dao.ProductDao;
import com.rastkosasic.shop.entity.Product;
 
@Service("productService")
public class ProductService {
 
    @Autowired
    @Qualifier("productDao")
    private ProductDao productDao;
 
    @Transactional
    public Product getProductById(long productId) {
 
        return productDao.selectProductById(productId);
    }
 
    @Transactional
    public void addProduct(Product newProduct) {
        productDao.insertProduct(newProduct);
    }
 
    @Transactional
    public void modifyProduct(Product product) {
        productDao.updateProduct(product);
    }
 
    @Transactional
    public List<Product> getAllProducts() {
        return productDao.selectAllProducts();
 
    }
 
    @Transactional
    public void removeProduct(long productId) {
        productDao.deleteProduct(productId);
 
    }
    
    @Transactional
    public List<Long> getNumberOfRecords() {
        return productDao.selectNumberOfRecordsInProductTable();
 
    }
    
    @Transactional
    public List<Long> getCategoryIdOfLastRecord() {
    	return productDao.selectProductIdOfLastRecord();
    }
 
}

