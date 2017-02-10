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

import edu.hm.ba.kongo.shop.ordering.service.gen.domain.OrderingItem_;

@NoRepositoryBean
public interface Generated_OrderingItem_Repository extends CrudRepository<OrderingItem_, UUID> {
	/**
	 * Name for the specific cache.
	 */
	String CACHE = "ORDERINGITEM_CACHE";
	
	/**
	 * Get all the OrderingItem_ entities.
	 *
	 * @return an Iterable of the OrderingItem_ entities with the same Tenancy.
	 */
	@Override
	Iterable<OrderingItem_> findAll();
	
	/**
	 * Get one specific OrderingItem_ by its unique oid.
	 *
	 * @param oid The identifier of the OrderingItem_.
	 * @return The OrderingItem_ with the requested oid.
	 */
	@Override
	@Cacheable(value = CACHE, key = "#p0")
	OrderingItem_ findOne(UUID oid);
	
	/**
	 * Create or update a OrderingItem_.
	 * <p>
	 * If the oid already exists, the OrderingItem_ will be overridden, hence update.
	 * If the oid does no already exist, a new OrderingItem_ will be created, hence create.
	 * </p>
	 *
	 * @param orderingItem The OrderingItem_ that will be saved.
	 * @return the saved OrderingItem_.
	 */
	@Override
	@CachePut(value = CACHE, key = "#p0.oid")
	@PreAuthorize("hasAuthority('ordering_WRITE_OrderingItem')")
	<S extends OrderingItem_> S save(S orderingItem);
	
	/**
	 * Delete the OrderingItem_ by a specified oid.
	 *
	 * @param oid the unique oid of the OrderingItem_ that will be deleted.
	 */
	@Override
	@CacheEvict(value = CACHE, key = "#p0")
	@PreAuthorize("hasAuthority('ordering_DELETE_OrderingItem')")
	void delete(UUID oid);
	
	/**
	 * Delete a OrderingItem_ by entity.
	 *
	 * @param entity The OrderingItem_ that will be deleted.
	 */
	@Override
	@CacheEvict(value = CACHE, key = "#p0.oid")
	@PreAuthorize("hasAuthority('ordering_DELETE_OrderingItem')")
	void delete(OrderingItem_ entity);
	
	/**
	 * Delete multiple OrderingItem_ entities by their oid.
	 *
	 * @param entities The Iterable of OrderingItem_ entities that will be deleted.
	 */
	@Override
	@CacheEvict(value = CACHE, allEntries = true)
	@PreAuthorize("hasAuthority('ordering_DELETE_OrderingItem')")
	void delete(Iterable<? extends OrderingItem_> entities);
	
	/**
	 * Delete all OrderingItem_ entities.
	 */
	@Override
	@CacheEvict(value = CACHE, allEntries = true)
	@PreAuthorize("hasAuthority('ordering_DELETE_OrderingItem')")
	void deleteAll();
	
	OrderingItem_ findByCart(@Param(value= "cart") String cart);
	OrderingItem_ findByOrderedOn(@Param(value= "orderedOn") java.time.LocalDate orderedOn);
	
}
