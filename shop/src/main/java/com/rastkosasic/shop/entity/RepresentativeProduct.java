package com.rastkosasic.shop.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

 
@Entity
@Table(name = "representative_product_table")
public class RepresentativeProduct {

 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "representative_product_id")
    private long representativeProductId;
    
    @Column(name = "fk_product_id")
    private long fkProductId;
 
    @Column(name = "created_at", length = 30)
    private String createdAt;
    
    @Column(name = "updated_at", length = 30)
    private String updatedAt;

	public long getRepresentativeProductId() {
		return representativeProductId;
	}

	public void setRepresentativeProductId(long representativeProductId) {
		this.representativeProductId = representativeProductId;
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
		return "RepresentativeProduct [representativeProductId=" + representativeProductId + ", fkProductId="
				+ fkProductId + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + "]";
	}
    
       
}