package edu.hm.ba.kongo.shop.warehouse.guilib.gen.ui.components.entity.product;

import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;

import org.springframework.hateoas.Link;

import com.vaadin.data.util.BeanItemContainer;
import de.muenchen.eventbus.selector.entity.ResponseEntityKey;
import edu.hm.ba.kongo.shop.warehouse.client.local.Product_;
import edu.hm.ba.kongo.shop.warehouse.guilib.gen.ui.components.buttons.listener.product.Product_SingleActions;
import edu.hm.ba.kongo.shop.warehouse.guilib.gen.services.model.Product_Datastore;

/*
 * This file will be overwritten on every change of the model!
 * This file was automatically generated by GAIA.
 */
/**
 * Provides a simple {@link Product_Form} that always shows the {@link Product_Datastore#getSelectedProduct()}.
 */
public class Product_SelectedForm extends Product_Form {

    /**
     * Creates a new Product_Form that updates its Product_ to the {@link Product_Datastore#getSelectedProduct()}
     * from the Eventbus.
     */
    public Product_SelectedForm() {
        getEventBus().on(new ResponseEntityKey(Product_Form.ENTITY_CLASS).toSelector(), this::update);
    }
    
    public void reLoad() {
        final Product_SingleActions singleActions = new Product_SingleActions(this::getProduct);
        singleActions.reRead(null);
    }

    /**
     * Update the Product_ of this Form to the selected one form the DataStore.
     *
     * @param event
     */
    protected void update(reactor.bus.Event<?> event) {
        final Product_Datastore data = (Product_Datastore) event.getData();
        if(data.getSelectedProduct().isPresent()){
        	Product_ product = data.getSelectedProduct().get();
			setProduct(product);
		}
    }
}