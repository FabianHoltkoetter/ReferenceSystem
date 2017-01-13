package edu.hm.ba.kongo.shop.shoppingcart.guilib.gen.ui.components.entity.cart;

import com.vaadin.ui.Component;
import com.vaadin.ui.HorizontalLayout;

import de.muenchen.vaadin.guilib.components.BaseComponent;
import de.muenchen.vaadin.guilib.components.actions.NavigateActions;
import de.muenchen.vaadin.guilib.components.buttons.ActionButton;

import de.muenchen.vaadin.demo.i18nservice.buttons.SimpleAction;

import edu.hm.ba.kongo.shop.shoppingcart.client.local.Cart_;
import edu.hm.ba.kongo.shop.shoppingcart.guilib.gen.ui.components.buttons.listener.cart.Cart_SingleActions;

public class Cart_ReadForm extends BaseComponent {
	/** Indicates the mode of the form. */
	public static final boolean READ_ONLY = true;

    /** The underlying form. */
    protected final Cart_SelectedForm cartForm;

	/** The layout for all Buttons. */
    protected final HorizontalLayout buttonLayout = new HorizontalLayout();
    
    /** The button for the update action. */
    protected final ActionButton updateButton = new ActionButton(Cart_.class, SimpleAction.update);

	/** The navigation for the update aciton. */
    protected final NavigateActions updateNavigation;

    public Cart_ReadForm(final String navigateToUpdate) {
        cartForm = new Cart_SelectedForm();
        cartForm.reLoad();
		
	   	updateNavigation = (navigateToUpdate==null ? null : new NavigateActions(navigateToUpdate));
        
        init();
        setIds();
    }

	/**
	 * Build the basic layout and insert the headline and all Buttons.
	 */
    protected void init() {
        getForm().setReadOnly(READ_ONLY);
		
        getButtonLayout().setSpacing(true);
		
		if(getUpdateNavigation()!=null){
        	configureUpdateButton();
			getButtonLayout().addComponents(getUpdateButton());
		}
		
        getForm().getFormLayout().addComponent(getButtonLayout());
        setCompositionRoot(getForm());
    }

    /**
	 * Set the IDs for important components.
	 */
	protected void setIds() {
		setId(getClass().getSimpleName());
		getForm().getFields().forEach(f -> f.setId(getId() + "#" + f.getId()));
		getForm().setId(getId() + "#form");
		if(getUpdateNavigation()!=null)
			getUpdateButton().setId(getId() + "#update-button-" + getNavigateToUpdate());
	}

    protected void configureUpdateButton() {
        final Cart_SingleActions singleActions = new Cart_SingleActions(getForm()::getCart);
        getUpdateButton().addActionPerformer(singleActions::read);
        getUpdateButton().addActionPerformer(getUpdateNavigation()::navigate);
    }

    public Component addButton(ActionButton button){
    	buttonLayout.addComponent(button);
    	return this;
    }

    // Getters
    public Cart_SelectedForm getForm() {
        return cartForm;
    }

    public HorizontalLayout getButtonLayout() {
        return buttonLayout;
    }

    public ActionButton getUpdateButton() {
        return updateButton;
    }

    public NavigateActions getUpdateNavigation() {
        return updateNavigation;
    }
    
    public String getNavigateToUpdate() {
        return (updateNavigation==null ? null : updateNavigation.getNavigateTo());
    }
}
