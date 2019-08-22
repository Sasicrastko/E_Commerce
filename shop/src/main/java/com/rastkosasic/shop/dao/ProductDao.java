package com.rastkosasic.shop.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
 
import org.springframework.stereotype.Repository;
import com.rastkosasic.shop.entity.Product;
 
@Repository("productDao")
public class ProductDao {
 
    @PersistenceContext
    private EntityManager entityManager;
 
    public Product selectProductById(long productId) {
        return entityManager.find(Product.class, productId);
    }
 
    public void insertProduct(Product product) {
        entityManager.persist(product);
    }
 
    public void updateProduct(Product product) {
 
        Product productToUpdate = selectProductById(product.getProductId());
 
        productToUpdate.setProductName(product.getProductName());
        productToUpdate.setSKU(product.getSKU());
        productToUpdate.setDescription(product.getDescription());
        productToUpdate.setActive(product.isActive());
        productToUpdate.setRegularPrice(product.getRegularPrice());
        productToUpdate.setDiscountPrice(product.getDiscountPrice());
        productToUpdate.setDiscounted(product.isDiscounted());
        productToUpdate.setCreatedAt(product.getCreatedAt());
        productToUpdate.setUpdatedAt(product.getUpdatedAt());
        entityManager.flush();
    }
 
    public void deleteProduct(long tagId) {
        entityManager.remove(selectProductById(tagId));
    }
 
    @SuppressWarnings("unchecked")
	public List<Product> selectAllProducts() {
        Query query = entityManager.createQuery("from Product as p order by p.productId");
        return (List<Product>) query.getResultList();
    }
    
    @SuppressWarnings("unchecked")
	public List<Long> selectNumberOfRecordsInProductTable() {
        Query query = entityManager.createQuery("select count(*) as numberOfRecords from Product");
        return (List<Long>) query.getResultList();
    }
    
    @SuppressWarnings("unchecked")
	public List<Long> selectProductIdOfLastRecord() {
        Query query = entityManager.createQuery("select max(productId) as lastInsertedProductId  from Product");
        return (List<Long>) query.getResultList();
    }
 
}