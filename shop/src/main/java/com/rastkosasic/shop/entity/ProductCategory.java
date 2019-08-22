package com.rastkosasic.shop.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

 
@Entity
@Table(name = "product_category_table")
public class ProductCategory {

 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_category_id")
    private long productCategoryId;
 
    @Column(name = "fk_product_id")
    private long fkProductId;
    
    @Column(name = "fk_category_id")
    private long fkCategoryId;
    
    @Column(name = "created_at", length = 30)
    private String createdAt;
    
    @Column(name = "updated_at", length = 30)
    private String updatedAt;

    public long getProductCategoryId() {
        return productCategoryId;
    }

    public void setProductCategoryId(long productCategoryId) {
        this.productCategoryId = productCategoryId;
    }

    public long getFkProductId() {
        return fkProductId;
    }

    public void setFkProductId(long fkProductId) {
        this.fkProductId = fkProductId;
    }

    public long getFkCategoryId() {
        return fkCategoryId;
    }

    public void setFkCategoryId(long fkCategoryId) {
        this.fkCategoryId = fkCategoryId;
    }
    
    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public String toString() {
        return "ProductCategory [productCategoryId=" + productCategoryId + ", fkProductId=" + fkProductId + ", fkCategoryId=" + fkCategoryId
                + "]";
    }
    
       
}