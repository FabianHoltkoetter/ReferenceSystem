package edu.hm.ba.kongo.shop.shoppingcart.guilib.gen.ui.components.entity.cart;

import com.vaadin.ui.Component;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Field;

import de.muenchen.vaadin.demo.i18nservice.buttons.SimpleAction;
import de.muenchen.vaadin.guilib.components.BaseComponent;
import de.muenchen.vaadin.guilib.components.actions.NavigateActions;
import de.muenchen.vaadin.guilib.components.buttons.ActionButton;

import edu.hm.ba.kongo.shop.shoppingcart.client.local.Cart_;
import edu.hm.ba.kongo.shop.shoppingcart.guilib.gen.ui.components.buttons.listener.cart.Cart_SingleActions;

/**
 * Provides a simple update form for the current selected Cart_.
 */
public class Cart_UpdateForm extends BaseComponent {
	/** Indicates the mode of the form. */
    protected static final boolean READ_ONLY = false;

	/** The underlying form. */
    protected final Cart_SelectedForm cartForm;

	/** The layout for all Buttons. */
    protected final HorizontalLayout buttonLayout = new HorizontalLayout();
    
    /** The button for the update action. */
    protected final NavigateActions saveNavigation;
    
    /** The button for the save action. */
    protected final ActionButton saveButton = new ActionButton(Cart_.class, SimpleAction.save);


    public Cart_UpdateForm(final String navigateToSaved) {
        saveNavigation = new NavigateActions(navigateToSaved);
        cartForm = new Cart_SelectedForm();
        cartForm.reLoad();

        init();
        setIds();
    }

	/**
	 * Initialize the ReadForm.
	 */
    protected void init() {
        getForm().setReadOnly(READ_ONLY);

        getButtonLayout().setSpacing(true);
        getButtonLayout().addComponents(getSaveButton());

        configureSaveButton();

        getForm().getFormLayout().addComponent(getButtonLayout());
        setCompositionRoot(getForm());

        getForm().getFields().stream().findFirst().ifPresent(Field::focus);
    }
    
    /**
	 * Set the IDs for important components.
	 */
	protected void setIds() {
		setId(getClass().getSimpleName());
		getForm().getFields().forEach(f -> f.setId(getId() + "#" + f.getId()));
		getForm().setId(getId() + "#form");
		getSaveButton().setId(getId() + "#save-button-" + getSaveNavigation().getNavigateTo());
	}

    protected void configureSaveButton() {
        final Cart_SingleActions singleActions = new Cart_SingleActions(getForm()::getCart);
        getSaveButton().addActionPerformer(singleActions::update);
        getSaveButton().addActionPerformer(getSaveNavigation()::navigate);
        
        getSaveButton().useNotification(true);
        getSaveButton().setNotifyAction(SimpleAction.update);
    }

	// Getters
    public Cart_SelectedForm getForm() {
        return cartForm;
    }

    public HorizontalLayout getButtonLayout() {
        return buttonLayout;
    }

    public ActionButton getSaveButton() {
        return saveButton;
    }

    public NavigateActions getSaveNavigation() {
        return saveNavigation;
    }
    
    public Component addButton(ActionButton button){
    	buttonLayout.addComponent(button);
    	return this;
    }
}
