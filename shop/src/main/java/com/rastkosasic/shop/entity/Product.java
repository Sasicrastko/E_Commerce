package com.rastkosasic.shop.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

 
@Entity
@Table(name = "product_table")
public class Product {

 
    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private long productId;
 
    @Column(name = "product_name", length = 127)
    private String productName;
    
    @Column(name = "SKU", length = 30)
    private String SKU;
    
    @Column(name="description", columnDefinition="TEXT")
    private String description;
    
    @Column(name="active")
    private boolean active;
    
    @Column(name="regular_price")
    private double regularPrice;
    
    @Column(name="discounted")
    private boolean discounted;
    
    @Column(name="discount_price")
    private double discountPrice;
     
    @Column(name = "updated_at", length = 30)
    private String updatedAt;
    
    @Column(name = "created_at", length = 30)
    private String createdAt;

	public long getProductId() {
		return productId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getSKU() {
		return SKU;
	}

	public void setSKU(String sKU) {
		SKU = sKU;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public double getRegularPrice() {
		return regularPrice;
	}

	public void setRegularPrice(double regularPrice) {
		this.regularPrice = regularPrice;
	}

	public boolean isDiscounted() {
		return discounted;
	}

	public void setDiscounted(boolean discounted) {
		this.discounted = discounted;
	}

	public double getDiscountPrice() {
		return discountPrice;
	}

	public void setDiscountPrice(double discountPrice) {
		this.discountPrice = discountPrice;
	}

	public String getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(String updatedAt) {
		this.updatedAt = updatedAt;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", SKU=" + SKU + ", description="
				+ description + ", active=" + active + ", regularPrice=" + regularPrice + ", discounted=" + discounted
				+ ", discountPrice=" + discountPrice + ", updatedAt=" + updatedAt + ", createdAt=" + createdAt + "]";
	}
    
    

}