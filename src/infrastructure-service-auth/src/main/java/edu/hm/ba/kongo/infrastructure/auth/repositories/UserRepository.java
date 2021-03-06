/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hm.ba.kongo.infrastructure.auth.repositories;

import edu.hm.ba.kongo.infrastructure.auth.UpdateOwnUserValidator;
import edu.hm.ba.kongo.infrastructure.auth.entities.User;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;

@RepositoryRestResource
public interface UserRepository extends CrudRepository<User, Long> {

    String User_CACHE = "SEC_USER_CACHE";
    String ROLE_WRITE = "hasRole('ROLE_WRITE_SEC_User')";
    String ROLE_DELETE = "hasRole('ROLE_DELETE_SEC_User')";

    @Cacheable(value = User_CACHE, key = "#p0")
    User findFirstByUsername(@Param("username") String username);

    @Override
    Iterable<User> findAll();

    @Override
    @Cacheable(value = User_CACHE, key = "#p0")
    User findOne(Long oid);

    @SuppressWarnings("unchecked")
    @Override
    @CachePut(value = User_CACHE, key = "#p0.oid")
    @PostAuthorize(ROLE_WRITE + "or" + UpdateOwnUserValidator.IS_OWN_USER_AUTH)
    User save(User User);

    @Override
    @CacheEvict(value = User_CACHE, key = "#p0")
    @PreAuthorize(ROLE_DELETE)
    void delete(Long oid);


    @Override
    @CacheEvict(value = User_CACHE, key = "#p0.oid")
    @PreAuthorize(ROLE_DELETE)
    void delete(User entity);

    @Override
    @CacheEvict(value = User_CACHE, allEntries = true)
    @PreAuthorize(ROLE_DELETE)
    void delete(Iterable<? extends User> entities);


    @Override
    @CacheEvict(value = User_CACHE, allEntries = true)
    @PreAuthorize(ROLE_DELETE)
    void deleteAll();

    User findByUsername(@Param(value = "username") String username);

}

