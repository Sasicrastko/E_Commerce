package com.rastkosasic.shop.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

 
@Entity
@Table(name = "in_cart_product_table")
public class InCartProduct {

 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "in_cart_product_id")
    private long inCartProductId;
    
    @Column(name = "fk_product_id")
    private long fkProductId;
    
    @Column(name = "fk_user_id")
    private long fkUserId;
 
	public long getFkUserId() {
		return fkUserId;
	}

	public void setFkUserId(long fkUserId) {
		this.fkUserId = fkUserId;
	}

	@Column(name = "created_at", length = 30)
    private String createdAt;
    
    @Column(name = "updated_at", length = 30)
    private String updatedAt;

    public long getInCartProductId() {
        return inCartProductId;
    }

    public void setInCartProductId(long inCartProductId) {
        this.inCartProductId = inCartProductId;
    }

    public long getFkProductId() {
        return fkProductId;
    }

    public void setFkProductId(long fkProductId) {
        this.fkProductId = fkProductId;
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
		return "InCartProduct [inCartProductId=" + inCartProductId + ", fkProductId=" + fkProductId + ", fkUserId="
				+ fkUserId + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + "]";
	}

      
}
