package com.rastkosasic.shop.service;


import java.util.List;

import javax.transaction.Transactional;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
 

import com.rastkosasic.shop.dao.RepresentativeProductDao;
import com.rastkosasic.shop.entity.RepresentativeProduct;
 
@Service("representativeProductService")
public class RepresentativeProductService {
 
    @Autowired
    @Qualifier("representativeProductDao")
    private RepresentativeProductDao representativeProductDao;
 
    @Transactional
    public RepresentativeProduct getRepresentativeProductById(long representativeProductId) {
        return representativeProductDao.selectRepresentativeProductById(representativeProductId);
    }
 
    @Transactional
    public void addRepresentativeProduct(RepresentativeProduct newRepresentativeProduct) {
        representativeProductDao.insertRepresentativeProduct(newRepresentativeProduct);
    }
 
    @Transactional
    public void modifyRepresentativeProduct(RepresentativeProduct representativeProduct) {
        representativeProductDao.updateRepresentativeProduct(representativeProduct);
    }
 
    @Transactional
    public List<RepresentativeProduct> getAllRepresentativeProducts() {
        return representativeProductDao.selectAllRepresentativeProducts();
 
    }
    
 
    @Transactional
    public void removeRepresentativeProduct(long representativeProductId) {
        representativeProductDao.deleteRepresentativeProduct(representativeProductId);
 
    }
    
    @Transactional
    public List<Long> getNumberOfRecords() {
        return representativeProductDao.selectNumberOfRecordsInRepresentativeProductTable();
 
    }
    
    @Transactional
    public List<Long> getRepresentativeProductIdOfLastRecord() {
        return representativeProductDao.selectRepresentativeProductIdOfLastRecord();
    }
 
}
