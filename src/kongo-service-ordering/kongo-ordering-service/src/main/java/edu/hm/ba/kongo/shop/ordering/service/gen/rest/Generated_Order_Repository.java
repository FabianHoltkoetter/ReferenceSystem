package edu.hm.ba.kongo.shop.ordering.service.gen.rest;

import java.util.List;
import java.util.UUID;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.security.access.prepost.PreAuthorize;

import edu.hm.ba.kongo.shop.ordering.service.gen.domain.Order_;

@NoRepositoryBean
public interface Generated_Order_Repository extends CrudRepository<Order_, UUID> {
	/**
	 * Name for the specific cache.
	 */
	String CACHE = "ORDER_CACHE";
	
	/**
	 * Get all the Order_ entities.
	 *
	 * @return an Iterable of the Order_ entities with the same Tenancy.
	 */
	@Override
	Iterable<Order_> findAll();
	
	/**
	 * Get one specific Order_ by its unique oid.
	 *
	 * @param oid The identifier of the Order_.
	 * @return The Order_ with the requested oid.
	 */
	@Override
	@Cacheable(value = CACHE, key = "#p0")
	Order_ findOne(UUID oid);
	
	/**
	 * Create or update a Order_.
	 * <p>
	 * If the oid already exists, the Order_ will be overridden, hence update.
	 * If the oid does no already exist, a new Order_ will be created, hence create.
	 * </p>
	 *
	 * @param order The Order_ that will be saved.
	 * @return the saved Order_.
	 */
	@Override
	@CachePut(value = CACHE, key = "#p0.oid")
	@PreAuthorize("hasAuthority('ordering_WRITE_Order')")
	<S extends Order_> S save(S order);
	
	/**
	 * Delete the Order_ by a specified oid.
	 *
	 * @param oid the unique oid of the Order_ that will be deleted.
	 */
	@Override
	@CacheEvict(value = CACHE, key = "#p0")
	@PreAuthorize("hasAuthority('ordering_DELETE_Order')")
	void delete(UUID oid);
	
	/**
	 * Delete a Order_ by entity.
	 *
	 * @param entity The Order_ that will be deleted.
	 */
	@Override
	@CacheEvict(value = CACHE, key = "#p0.oid")
	@PreAuthorize("hasAuthority('ordering_DELETE_Order')")
	void delete(Order_ entity);
	
	/**
	 * Delete multiple Order_ entities by their oid.
	 *
	 * @param entities The Iterable of Order_ entities that will be deleted.
	 */
	@Override
	@CacheEvict(value = CACHE, allEntries = true)
	@PreAuthorize("hasAuthority('ordering_DELETE_Order')")
	void delete(Iterable<? extends Order_> entities);
	
	/**
	 * Delete all Order_ entities.
	 */
	@Override
	@CacheEvict(value = CACHE, allEntries = true)
	@PreAuthorize("hasAuthority('ordering_DELETE_Order')")
	void deleteAll();
	
	Order_ findByCart(@Param(value= "cart") String cart);
	Order_ findByOrderedOn(@Param(value= "orderedOn") java.time.LocalDate orderedOn);
	
}
