package edu.hm.ba.kongo.shop.shoppingcart.guilib.gen.services;

import edu.hm.ba.kongo.shop.shoppingcart.client.local.Cart_;
import org.springframework.hateoas.Link;

import java.util.List;
import java.util.Optional;

/*
 * This file will be overwritten on every change of the model!
 * This file was automatically generated by GAIA.
 */
/**
 * Service zum Verwalten von Cart_ aus der GUI heraus.
 */
public interface Cart_Service {
    Cart_ create(Cart_ cart);

    Cart_ update(Cart_ cart);

    boolean delete(Link link);
		
    List<Cart_> findAll();

    List<Cart_> findAll(Link relation);

    Optional<Cart_> findOne(Link link);

    List<Cart_> queryCart(String query);

    void setRelations(Link link, List<Link> relations);

    void setRelation(Link link, Link relation);
}
