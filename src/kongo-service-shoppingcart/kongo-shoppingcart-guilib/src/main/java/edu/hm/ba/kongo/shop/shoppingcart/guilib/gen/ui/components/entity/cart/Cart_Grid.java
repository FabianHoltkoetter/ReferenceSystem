package edu.hm.ba.kongo.shop.shoppingcart.guilib.gen.ui.components.entity.cart;

import com.vaadin.ui.Component;
import de.muenchen.vaadin.guilib.components.GenericGrid;
import de.muenchen.vaadin.guilib.components.buttons.ActionButton;

import edu.hm.ba.kongo.shop.shoppingcart.client.local.Cart_;

import edu.hm.ba.kongo.shop.shoppingcart.guilib.gen.ui.controller.Cart_ViewController;

public class Cart_Grid extends GenericGrid<Cart_> {

    public Cart_Grid(final Cart_ViewController controller) {
        super(controller.getModel().getCarts(),
                Cart_.Field.getProperties());
    }
    
    public Component addButton(ActionButton button){
    	addComponent(button);
    	return this;
    }

}
