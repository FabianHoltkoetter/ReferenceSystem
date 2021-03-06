package edu.hm.ba.kongo.shop.ordering.client.rest;

import edu.hm.ba.kongo.shop.ordering.client.local.OrderingItem_;
import org.springframework.hateoas.Link;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

/*
 * This file will be overwritten on every change of the model!
 * This file was automatically generated by GAIA.
 */
public interface OrderingItem_RestClient {

    /**
     * The name of the Base Endpoint
     */
    public static final String ORDERINGITEMS = "orderingItems";

    /**
     * Get all the OrderingItems (with matching tenancy).
     *
     * @return a List of all OrderingItems.
     */
    List<OrderingItem_> findAll();

    /**
     * Get all the OrderingItems (with matching tenancy) on a specific endpoint.
     * <p>
     *     For example: <code>http://localhost:80/entitys/1/attribute</code>
     * </p>
     * @param relation
     * @return
     */
    List<OrderingItem_> findAll(Link relation);
    
    /**
     * Get all OrderingItem matched with string due to fuzzy search.
     * @param filter the string for the query
     * @return
     */
    List<OrderingItem_> findFullTextFuzzy(String filter);

    /**
     * Try to find one OrderingItem (with matching tenancy) by its ID / self relation.
     *
     * @param link The ID / self relation of the OrderingItem_.
     * @return an optional of the OrderingItem_.
     */
    Optional<OrderingItem_> findOne(Link link);

    /**
     * Set all the relations, specified by links, on a specific relation endpoint.
     * <p>
     * Example for an Endpoint: <code>http://localhost:80/entitys/1/attribute</code>
     * </p>
     * <p>
     * This method will always (re-) set the associations. The add or delete
     * functionality is not provided at RestClient level.
     * </p>
     *
     * @param endpoint The endpoint of the relation.
     * @param links    The links that are set to be related.
     */
    void setRelations(Link endpoint, Collection<Link> links);
	/**
	 * Set the relation, specified by @relation, on a specific relation endpoint.
	 * <p>
	 * Example for an Endpoint: <code>http://localhost:80/entitys/1/attribute</code>
	 * </p>
	 * <p>
	 * This method will always (re-) set the association. The add or delete
	 * functionality is not provided at RestClient level.
	 * </p>
	 *
	 * @param endpoint The endpoint of the relation.
	 * @param relation    The link that is set to be related.
	 */
	void setRelation(Link endpoint, Link relation);
    /**
     * Create a new OrderingItem_, the returned OrderingItem_ will have the Links and its ID.
     * @param orderingItem The OrderingItem_ to create, it must not contain any links.
     * @return the created OrderingItem_ (with ID).
     */
    OrderingItem_ create(OrderingItem_ orderingItem);

    /**
     * Update the fields of a OrderingItem_ by the {@link OrderingItem_#getId()}.
     *
     * @param orderingItem The updated OrderingItem_ that will be saved.
     * @return the updated version from the REST Server.
     */
    OrderingItem_ update(OrderingItem_ orderingItem);

    /**
     * Try to delete an ID.
     * @param id The link to the id.
     */
    void delete(Link id);
}
