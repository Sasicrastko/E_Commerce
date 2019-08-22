package com.rastkosasic.shop.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
 
import org.springframework.stereotype.Repository;
import com.rastkosasic.shop.entity.ImageURL;
 
@Repository("imageURLDao")
public class ImageURLDao {
 
  @PersistenceContext
  private EntityManager entityManager;
 
  public ImageURL selectImageURLById(long imageURLId) {
        return entityManager.find(ImageURL.class, imageURLId);
  }
 
  public void insertImageURL(ImageURL imageURL) {
        entityManager.persist(imageURL);
  }
 
  public void updateImageURL(ImageURL imageURL) {
 
        ImageURL imageURLToUpdate = selectImageURLById(imageURL.getImageURLId());
 
        imageURLToUpdate.setImageURL(imageURL.getImageURL());
        imageURLToUpdate.setFkAttributeId(imageURL.getFkAttributeId());
        imageURLToUpdate.setCreatedAt(imageURL.getCreatedAt());
        imageURLToUpdate.setUpdatedAt(imageURL.getUpdatedAt());
        entityManager.flush();
  }
 
  public void deleteImageURL(long imageURLId) {
        entityManager.remove(selectImageURLById(imageURLId));
  }
    

  @SuppressWarnings("unchecked")
  public List<ImageURL> selectAllImageURLs() {
        Query query = entityManager.createQuery("FROM ImageURL AS url ORDER BY url.imageURL ASC");
        return (List<ImageURL>) query.getResultList();
  }
    
  @SuppressWarnings("unchecked")
  public List<Long> selectNumberOfRecordsInImageURLTable() {
        Query query = entityManager.createQuery("SELECT COUNT(*) AS numberOfRecords FROM ImageURL");
        return (List<Long>) query.getResultList();
  }
    
  @SuppressWarnings("unchecked")
  public List<Long> selectImageURLIdOfLastRecord() {
        Query query = entityManager.createQuery("SELECT MAX(imageURLId) AS lastInsertedImageURLId  FROM ImageURL");
        return (List<Long>) query.getResultList();
  }
 
}
