package com.rastkosasic.shop.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

 
@Entity
@Table(name = "attribute_table")
public class Attribute {

 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "attribute_id")
    private long attributeId;
 
    @Column(name = "color", length = 16)
    private String color;
    
    @Column(name = "fk_size_id")
    long fkSizeId;
    
    @Column(name = "fk_product_id")
    long fkProductId;
    
    public long getFkProductId() {
		return fkProductId;
	}

	public void setFkProductId(long fkProductId) {
		this.fkProductId = fkProductId;
	}

	@Column(name="quantity")
    private double quantity;

     
    @Column(name = "updated_at", length = 30)
    private String updatedAt;
    
    @Column(name = "created_at", length = 30)
    private String createdAt;

	public long getAttributeId() {
		return attributeId;
	}

	public void setAttributeId(long attributeId) {
		this.attributeId = attributeId;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}


	public long getFkSizeId() {
		return fkSizeId;
	}

	public void setFkSizeId(long fkSizeId) {
		this.fkSizeId = fkSizeId;
	}

	public double getQuantity() {
		return quantity;
	}

	public void setQuantity(double quantity) {
		this.quantity = quantity;
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
		return "Attribute [attributeId=" + attributeId + ", color=" + color + ", fkSizeId="
				+ fkSizeId + ", fkProductId=" + fkProductId + ", quantity=" + quantity + ", updatedAt=" + updatedAt
				+ ", createdAt=" + createdAt + "]";
	}
 

}
