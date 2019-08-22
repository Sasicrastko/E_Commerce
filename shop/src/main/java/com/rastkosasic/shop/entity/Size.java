package com.rastkosasic.shop.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

 
@Entity
@Table(name = "size_table")
public class Size {

 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "size_id")
    private long sizeId;
 
    @Column(name = "size_name", length = 30)
    private String sizeName;
    
    @Column(name = "created_at", length = 30)
    private String createdAt;
    
    @Column(name = "updated_at", length = 30)
    private String updatedAt;

  public long getSizeId() {
    return sizeId;
  }

  public void setSizeId(long sizeId) {
    this.sizeId = sizeId;
  }

  public String getSizeName() {
    return sizeName;
  }

  public void setSizeName(String sizeName) {
    this.sizeName = sizeName;
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
    return "Size [sizeId=" + sizeId + ", sizeName=" + sizeName + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt
        + "]";
  }
}