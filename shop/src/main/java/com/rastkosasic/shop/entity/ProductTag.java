package com.rastkosasic.shop.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

 
@Entity
@Table(name = "product_tag_table")
public class ProductTag {

 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_tag_id")
    private long productTagId;
 
    @Column(name = "fk_product_id")
    private long fkProductId;
    
    @Column(name = "fk_tag_id")
    private long fkTagId;
    
    @Column(name = "created_at", length = 30)
    private String createdAt;
    
    @Column(name = "updated_at", length = 30)
    private String updatedAt;

	public long getProductTagId() {
		return productTagId;
	}

	public void setProductTagId(long productTagId) {
		this.productTagId = productTagId;
	}

	public long getFkProductId() {
		return fkProductId;
	}

	public void setFkProductId(long fkProductId) {
		this.fkProductId = fkProductId;
	}

	public long getFkTagId() {
		return fkTagId;
	}

	public void setFkTagId(long fkTagId) {
		this.fkTagId = fkTagId;
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
		return "ProductTag [productTagId=" + productTagId + ", fkProductId=" + fkProductId + ", fkTagId=" + fkTagId
				+ "]";
	}
    
       
}
