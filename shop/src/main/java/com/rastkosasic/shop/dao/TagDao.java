package com.rastkosasic.shop.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
 
import org.springframework.stereotype.Repository;
import com.rastkosasic.shop.entity.Tag;
 
@Repository("tagDao")
public class TagDao {
 
    @PersistenceContext
    private EntityManager entityManager;
 
    public Tag selectTagById(long tagId) {
        return entityManager.find(Tag.class, tagId);
    }
 
    public void insertTag(Tag tag) {
        entityManager.persist(tag);
    }
 
    public void updateTag(Tag tag) {
 
        Tag tagToUpdate = selectTagById(tag.getTagId());
 
        tagToUpdate.setTagName(tag.getTagName());
        tagToUpdate.setCreatedAt(tag.getCreatedAt());
        tagToUpdate.setUpdatedAt(tag.getUpdatedAt());
        entityManager.flush();
    }
 
    public void deleteTag(long tagId) {
        entityManager.remove(selectTagById(tagId));
    }
 
    @SuppressWarnings("unchecked")
	public List<Tag> selectAllTagsForProduct(String productId) {
    	Query query = entityManager.createQuery("FROM Tag as t where t.tagId IN (SELECT fkTagId FROM ProductTag where fkProductId=" + productId + ")");
        return (List<Tag>) query.getResultList();
    }
    
    @SuppressWarnings("unchecked")
	public List<Tag> selectAllTags() {
        Query query = entityManager.createQuery("FROM Tag AS t ORDER BY t.tagName ASC");
        return (List<Tag>) query.getResultList();
    }
    
    @SuppressWarnings("unchecked")
	public List<Long> selectNumberOfRecordsInTagTable() {
        Query query = entityManager.createQuery("select count(*) as numberOfRecords FROM Tag");
        return (List<Long>) query.getResultList();
    }
    
    @SuppressWarnings("unchecked")
	public List<Long> selectTagIdOfLastRecord() {
        Query query = entityManager.createQuery("select max(tagId) as lastInsertedTagId  from Tag");
        return (List<Long>) query.getResultList();
    }
 
}
