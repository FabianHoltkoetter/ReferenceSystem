package edu.hm.ba.kongo.shop.warehouse.guilib.gen.ui.components.entity.product;

import com.vaadin.ui.Component;
import com.vaadin.ui.HorizontalLayout;

import de.muenchen.vaadin.guilib.components.BaseComponent;
import de.muenchen.vaadin.guilib.components.actions.NavigateActions;
import de.muenchen.vaadin.guilib.components.buttons.ActionButton;

import de.muenchen.vaadin.demo.i18nservice.buttons.SimpleAction;

import edu.hm.ba.kongo.shop.warehouse.client.local.Product_;
import edu.hm.ba.kongo.shop.warehouse.guilib.gen.ui.components.buttons.listener.product.Product_SingleActions;

public class Product_ReadForm extends BaseComponent {
	/** Indicates the mode of the form. */
	public static final boolean READ_ONLY = true;

    /** The underlying form. */
    protected final Product_SelectedForm productForm;

	/** The layout for all Buttons. */
    protected final HorizontalLayout buttonLayout = new HorizontalLayout();
    
    /** The button for the update action. */
    protected final ActionButton updateButton = new ActionButton(Product_.class, SimpleAction.update);

	/** The navigation for the update aciton. */
    protected final NavigateActions updateNavigation;

    public Product_ReadForm(final String navigateToUpdate) {
        productForm = new Product_SelectedForm();
        productForm.reLoad();
		
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
        final Product_SingleActions singleActions = new Product_SingleActions(getForm()::getProduct);
        getUpdateButton().addActionPerformer(singleActions::read);
        getUpdateButton().addActionPerformer(getUpdateNavigation()::navigate);
    }

    public Component addButton(ActionButton button){
    	buttonLayout.addComponent(button);
    	return this;
    }

    // Getters
    public Product_SelectedForm getForm() {
        return productForm;
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
