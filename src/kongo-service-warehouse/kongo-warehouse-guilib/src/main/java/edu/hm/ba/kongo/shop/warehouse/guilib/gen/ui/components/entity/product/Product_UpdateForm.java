package edu.hm.ba.kongo.shop.warehouse.guilib.gen.ui.components.entity.product;

import com.vaadin.ui.Component;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Field;

import de.muenchen.vaadin.demo.i18nservice.buttons.SimpleAction;
import de.muenchen.vaadin.guilib.components.BaseComponent;
import de.muenchen.vaadin.guilib.components.actions.NavigateActions;
import de.muenchen.vaadin.guilib.components.buttons.ActionButton;

import edu.hm.ba.kongo.shop.warehouse.client.local.Product_;
import edu.hm.ba.kongo.shop.warehouse.guilib.gen.ui.components.buttons.listener.product.Product_SingleActions;

/**
 * Provides a simple update form for the current selected Product_.
 */
public class Product_UpdateForm extends BaseComponent {
	/** Indicates the mode of the form. */
    protected static final boolean READ_ONLY = false;

	/** The underlying form. */
    protected final Product_SelectedForm productForm;

	/** The layout for all Buttons. */
    protected final HorizontalLayout buttonLayout = new HorizontalLayout();
    
    /** The button for the update action. */
    protected final NavigateActions saveNavigation;
    
    /** The button for the save action. */
    protected final ActionButton saveButton = new ActionButton(Product_.class, SimpleAction.save);


    public Product_UpdateForm(final String navigateToSaved) {
        saveNavigation = new NavigateActions(navigateToSaved);
        productForm = new Product_SelectedForm();
        productForm.reLoad();

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
        final Product_SingleActions singleActions = new Product_SingleActions(getForm()::getProduct);
        getSaveButton().addActionPerformer(singleActions::update);
        getSaveButton().addActionPerformer(getSaveNavigation()::navigate);
        
        getSaveButton().useNotification(true);
        getSaveButton().setNotifyAction(SimpleAction.update);
    }

	// Getters
    public Product_SelectedForm getForm() {
        return productForm;
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
