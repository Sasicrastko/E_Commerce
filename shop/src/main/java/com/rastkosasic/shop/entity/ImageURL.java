package com.rastkosasic.shop.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

 
@Entity
@Table(name = "image_url_table")
public class ImageURL {

 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "image_url_id")
    private long imageURLId;
 
    @Column(name = "imageURL", length = 500)
    private String imageURL;
    
    @Column(name = "fkAttributeId")
    private long fkAttributeId;
    
    public long getFkAttributeId() {
		return fkAttributeId;
	}

	public void setFkAttributeId(long fkAttributeId) {
		this.fkAttributeId = fkAttributeId;
	}

	@Column(name = "created_at", length = 30)
    private String createdAt;
    
    @Column(name = "updated_at", length = 30)
    private String updatedAt;

  public long getImageURLId() {
    return imageURLId;
  }

  public void setImageURLId(long imageURLId) {
    this.imageURLId = imageURLId;
  }

  public String getImageURL() {
    return imageURL;
  }

  public void setImageURL(String imageURL) {
    this.imageURL = imageURL;
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
	return "ImageURL [imageURLId=" + imageURLId + ", imageURL=" + imageURL + ", fkAttributeId=" + fkAttributeId
			+ ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + "]";
}
       
}
