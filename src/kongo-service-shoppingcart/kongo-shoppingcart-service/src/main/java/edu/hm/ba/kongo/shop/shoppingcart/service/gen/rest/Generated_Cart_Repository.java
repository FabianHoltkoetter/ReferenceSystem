package edu.hm.ba.kongo.shop.shoppingcart.service.gen.rest;

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

import edu.hm.ba.kongo.shop.shoppingcart.service.gen.domain.Cart_;

@NoRepositoryBean
public interface Generated_Cart_Repository extends CrudRepository<Cart_, UUID> {
	/**
	 * Name for the specific cache.
	 */
	String CACHE = "CART_CACHE";
	
	/**
	 * Get all the Cart_ entities.
	 *
	 * @return an Iterable of the Cart_ entities with the same Tenancy.
	 */
	@Override
	Iterable<Cart_> findAll();
	
	/**
	 * Get one specific Cart_ by its unique oid.
	 *
	 * @param oid The identifier of the Cart_.
	 * @return The Cart_ with the requested oid.
	 */
	@Override
	@Cacheable(value = CACHE, key = "#p0")
	Cart_ findOne(UUID oid);
	
	/**
	 * Create or update a Cart_.
	 * <p>
	 * If the oid already exists, the Cart_ will be overridden, hence update.
	 * If the oid does no already exist, a new Cart_ will be created, hence create.
	 * </p>
	 *
	 * @param cart The Cart_ that will be saved.
	 * @return the saved Cart_.
	 */
	@Override
	@CachePut(value = CACHE, key = "#p0.oid")
	@PreAuthorize("hasAuthority('shoppingcart_WRITE_Cart')")
	<S extends Cart_> S save(S cart);
	
	/**
	 * Delete the Cart_ by a specified oid.
	 *
	 * @param oid the unique oid of the Cart_ that will be deleted.
	 */
	@Override
	@CacheEvict(value = CACHE, key = "#p0")
	@PreAuthorize("hasAuthority('shoppingcart_DELETE_Cart')")
	void delete(UUID oid);
	
	/**
	 * Delete a Cart_ by entity.
	 *
	 * @param entity The Cart_ that will be deleted.
	 */
	@Override
	@CacheEvict(value = CACHE, key = "#p0.oid")
	@PreAuthorize("hasAuthority('shoppingcart_DELETE_Cart')")
	void delete(Cart_ entity);
	
	/**
	 * Delete multiple Cart_ entities by their oid.
	 *
	 * @param entities The Iterable of Cart_ entities that will be deleted.
	 */
	@Override
	@CacheEvict(value = CACHE, allEntries = true)
	@PreAuthorize("hasAuthority('shoppingcart_DELETE_Cart')")
	void delete(Iterable<? extends Cart_> entities);
	
	/**
	 * Delete all Cart_ entities.
	 */
	@Override
	@CacheEvict(value = CACHE, allEntries = true)
	@PreAuthorize("hasAuthority('shoppingcart_DELETE_Cart')")
	void deleteAll();

	Iterable<Cart_> findByUserID(@Param(value= "userID") String userID);
	Iterable<Cart_> findByTotalPrice(@Param(value= "totalPrice") BigDecimal totalPrice);
	
}
