package edu.hm.ba.kongo.shop.ordering.service.rest;

import java.util.List;
import java.util.UUID;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.security.access.prepost.PreAuthorize;

import edu.hm.ba.kongo.shop.ordering.service.gen.domain.OrderingItem_;

/**
* Provides a Repository for a {@link OrderingItem_}. This Repository can be exported as a REST Resource.
* <p>
* The Repository handles CRUD Operations. Every Operation is secured and takes care of the tenancy.
* For specific Documentation on how the generated REST point behaves, please consider the Spring Data Rest Reference
* <a href="http://docs.spring.io/spring-data/rest/docs/current/reference/html/">here</a>.
* </p>
*/
@RepositoryRestResource(exported = true,
	path="orderingItems", collectionResourceRel="orderingItems")
@PreAuthorize("hasAuthority('ordering_READ_OrderingItem')")
public interface OrderingItem_Repository extends edu.hm.ba.kongo.shop.ordering.service.gen.rest.Generated_OrderingItem_Repository {
}
