package edu.hm.ba.kongo.shop.warehouse.guilib.gen.ui.components.entity.product;

import com.vaadin.ui.Component;
import de.muenchen.vaadin.guilib.components.GenericGrid;
import de.muenchen.vaadin.guilib.components.buttons.ActionButton;

import edu.hm.ba.kongo.shop.warehouse.client.local.Product_;

import edu.hm.ba.kongo.shop.warehouse.guilib.gen.ui.controller.Product_ViewController;

public class Product_Grid extends GenericGrid<Product_> {

    public Product_Grid(final Product_ViewController controller) {
        super(controller.getModel().getProducts(),
                Product_.Field.getProperties());
    }
    
    public Component addButton(ActionButton button){
    	addComponent(button);
    	return this;
    }

}
