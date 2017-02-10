package edu.hm.ba.kongo.shop.ordering.guilib.gen.ui.components.entity.orderingItem;

import com.vaadin.ui.Component;
import de.muenchen.vaadin.guilib.components.GenericGrid;
import de.muenchen.vaadin.guilib.components.buttons.ActionButton;

import edu.hm.ba.kongo.shop.ordering.client.local.OrderingItem_;

import edu.hm.ba.kongo.shop.ordering.guilib.gen.ui.controller.OrderingItem_ViewController;

public class OrderingItem_Grid extends GenericGrid<OrderingItem_> {

    public OrderingItem_Grid(final OrderingItem_ViewController controller) {
        super(controller.getModel().getOrderingItems(),
                OrderingItem_.Field.getProperties());
    }
    
    public Component addButton(ActionButton button){
    	addComponent(button);
    	return this;
    }

}
