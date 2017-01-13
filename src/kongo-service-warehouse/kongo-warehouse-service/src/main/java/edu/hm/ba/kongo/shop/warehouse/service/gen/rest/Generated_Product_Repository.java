package edu.hm.ba.kongo.shop.warehouse.service.gen.rest;

import java.util.List;
import java.util.UUID;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.security.access.prepost.PreAuthorize;
import java.math.BigDecimal;

import edu.hm.ba.kongo.shop.warehouse.service.gen.domain.Product_;

@NoRepositoryBean
public interface Generated_Product_Repository extends CrudRepository<Product_, UUID> {
	/**
	 * Name for the specific cache.
	 */
	String CACHE = "PRODUCT_CACHE";
	
	/**
	 * Get all the Product_ entities.
	 *
	 * @return an Iterable of the Product_ entities with the same Tenancy.
	 */
	@Override
	Iterable<Product_> findAll();
	
	/**
	 * Get one specific Product_ by its unique oid.
	 *
	 * @param oid The identifier of the Product_.
	 * @return The Product_ with the requested oid.
	 */
	@Override
	@Cacheable(value = CACHE, key = "#p0")
	Product_ findOne(UUID oid);
	
	/**
	 * Create or update a Product_.
	 * <p>
	 * If the oid already exists, the Product_ will be overridden, hence update.
	 * If the oid does no already exist, a new Product_ will be created, hence create.
	 * </p>
	 *
	 * @param product The Product_ that will be saved.
	 * @return the saved Product_.
	 */
	@Override
	@CachePut(value = CACHE, key = "#p0.oid")
	@PreAuthorize("hasAuthority('warehouse_WRITE_Product')")
	<S extends Product_> S save(S product);
	
	/**
	 * Delete the Product_ by a specified oid.
	 *
	 * @param oid the unique oid of the Product_ that will be deleted.
	 */
	@Override
	@CacheEvict(value = CACHE, key = "#p0")
	@PreAuthorize("hasAuthority('warehouse_DELETE_Product')")
	void delete(UUID oid);
	
	/**
	 * Delete a Product_ by entity.
	 *
	 * @param entity The Product_ that will be deleted.
	 */
	@Override
	@CacheEvict(value = CACHE, key = "#p0.oid")
	@PreAuthorize("hasAuthority('warehouse_DELETE_Product')")
	void delete(Product_ entity);
	
	/**
	 * Delete multiple Product_ entities by their oid.
	 *
	 * @param entities The Iterable of Product_ entities that will be deleted.
	 */
	@Override
	@CacheEvict(value = CACHE, allEntries = true)
	@PreAuthorize("hasAuthority('warehouse_DELETE_Product')")
	void delete(Iterable<? extends Product_> entities);
	
	/**
	 * Delete all Product_ entities.
	 */
	@Override
	@CacheEvict(value = CACHE, allEntries = true)
	@PreAuthorize("hasAuthority('warehouse_DELETE_Product')")
	void deleteAll();
	
	Product_ findByName(@Param(value= "name") String name);
	Product_ findByDescription(@Param(value= "description") String description);
	Product_ findByPrice(@Param(value= "price") BigDecimal price);
	Product_ findByQuantity(@Param(value= "quantity") long quantity);
	List<Product_> findProductByName(@Param("name") String name);
	List<Product_> findProductByPrice(@Param("price") String price);
	List<Product_> findProductByQuantity(@Param("quantity") String quantity);
	
}
