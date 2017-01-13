package edu.hm.ba.kongo.shop.ordering.guilib.gen.ui.components.entity.order;

import com.vaadin.ui.Component;
import de.muenchen.vaadin.guilib.components.GenericGrid;
import de.muenchen.vaadin.guilib.components.buttons.ActionButton;

import edu.hm.ba.kongo.shop.ordering.client.local.Order_;

import edu.hm.ba.kongo.shop.ordering.guilib.gen.ui.controller.Order_ViewController;

public class Order_Grid extends GenericGrid<Order_> {

    public Order_Grid(final Order_ViewController controller) {
        super(controller.getModel().getOrders(),
                Order_.Field.getProperties());
    }
    
    public Component addButton(ActionButton button){
    	addComponent(button);
    	return this;
    }

}
