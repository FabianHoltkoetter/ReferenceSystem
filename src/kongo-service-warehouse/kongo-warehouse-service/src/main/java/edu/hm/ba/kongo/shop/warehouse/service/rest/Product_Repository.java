package edu.hm.ba.kongo.shop.warehouse.service.rest;

import java.util.List;
import java.util.UUID;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.security.access.prepost.PreAuthorize;
import java.math.BigDecimal;

import edu.hm.ba.kongo.shop.warehouse.service.gen.domain.Product_;

/**
* Provides a Repository for a {@link Product_}. This Repository can be exported as a REST Resource.
* <p>
* The Repository handles CRUD Operations. Every Operation is secured and takes care of the tenancy.
* For specific Documentation on how the generated REST point behaves, please consider the Spring Data Rest Reference
* <a href="http://docs.spring.io/spring-data/rest/docs/current/reference/html/">here</a>.
* </p>
*/
@RepositoryRestResource(exported = true,
	path="products", collectionResourceRel="products")
@PreAuthorize("hasAuthority('warehouse_READ_Product')")
public interface Product_Repository extends edu.hm.ba.kongo.shop.warehouse.service.gen.rest.Generated_Product_Repository {
}
