package com.rastkosasic.shop.service;


import java.util.List;

import javax.transaction.Transactional;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
 

import com.rastkosasic.shop.dao.InCartProductDao;
import com.rastkosasic.shop.entity.InCartProduct;
 
@Service("inCartProductService")
public class InCartProductService {
 
    @Autowired
    @Qualifier("inCartProductDao")
    private InCartProductDao inCartProductDao;
 
    @Transactional
    public InCartProduct getInCartProductById(long inCartProductId) {
        return inCartProductDao.selectInCartProductById(inCartProductId);
    }
 
    @Transactional
    public void addInCartProduct(InCartProduct newInCartProduct) {
        inCartProductDao.insertInCartProduct(newInCartProduct);
    }
 
    @Transactional
    public void modifyInCartProduct(InCartProduct inCartProduct) {
        inCartProductDao.updateInCartProduct(inCartProduct);
    }
 
    @Transactional
    public List<InCartProduct> getAllInCartProducts() {
        return inCartProductDao.selectAllInCartProducts();
 
    }
    
 
    @Transactional
    public void removeInCartProduct(long inCartProductId) {
        inCartProductDao.deleteInCartProduct(inCartProductId);
 
    }
    
    @Transactional
    public List<Long> getNumberOfRecords() {
        return inCartProductDao.selectNumberOfRecordsInInCartProductTable();
 
    }
    
    @Transactional
    public List<Long> getInCartProductIdOfLastRecord() {
        return inCartProductDao.selectInCartProductIdOfLastRecord();
    }
 
}