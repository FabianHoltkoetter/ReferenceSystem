package edu.hm.ba.kongo.shop.ordering.guilib.gen.services.model;

import de.muenchen.vaadin.guilib.util.Datastore;
import com.vaadin.data.util.BeanItemContainer;
import edu.hm.ba.kongo.shop.ordering.client.local.OrderingItem_;
import java.util.Optional;

/*
 * This file will be overwritten on every change of the model!
 * This file was automatically generated by GAIA.
 */
/**
 * Provides a simple Model for the OrderingItem_ in the GUI.
 */
public class OrderingItem_Datastore implements Datastore<OrderingItem_>{
    
    /** A List of all the OrderingItem_, possible reduced by the query. */
    private final BeanItemContainer<OrderingItem_> orderingItems = new BeanItemContainer<>(OrderingItem_.class);
    
    /** The current (single or none) selected orderingItem in the GUI. */
    private Optional<OrderingItem_> selectedOrderingItem= Optional.empty();
    
    /** The query to filter the orderingItem. */
    private Optional<String> query = Optional.empty();

    public Optional<OrderingItem_> getSelectedOrderingItem() {
        return selectedOrderingItem;
    }

    /**
     * Set the Selected OrderingItem, if null the Optional will be empty.
     *
     * @param selectedOrderingItem The OrderingItem_ to set as the selected one.
     */
    public void setSelectedOrderingItem(OrderingItem_ selectedOrderingItem) {
        this.selectedOrderingItem = Optional.ofNullable(selectedOrderingItem);
    }

    public BeanItemContainer<OrderingItem_> getOrderingItems() {
        return orderingItems;
    }

    public Optional<String> getQuery() {
        return query;
    }

    /**
     * Set the current query.
     *
     * @param query The query.
     */
    public void setQuery(String query) {
        this.query = Optional.ofNullable(query);
    }

	@Override
	public BeanItemContainer<OrderingItem_> getEntityContainer() {
		return getOrderingItems();
	}
}

