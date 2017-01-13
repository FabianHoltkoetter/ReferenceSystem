package edu.hm.ba.kongo.shop.warehouse.guilib.gen.ui.components.entity.product;

import com.vaadin.data.Validator;
import com.vaadin.server.UserError;
import com.vaadin.ui.Component;
import com.vaadin.ui.Field;
import com.vaadin.ui.Grid;
import com.vaadin.ui.HorizontalLayout;
import java.util.stream.Collectors;
import java.util.NoSuchElementException;

import edu.hm.ba.kongo.shop.warehouse.client.local.Product_;
import edu.hm.ba.kongo.shop.warehouse.guilib.gen.ui.components.buttons.listener.product.Product_SingleActions;

import de.muenchen.vaadin.demo.i18nservice.buttons.SimpleAction;
import de.muenchen.vaadin.guilib.BaseUI;
import de.muenchen.vaadin.guilib.components.GenericGrid;
import de.muenchen.vaadin.guilib.components.actions.NavigateActions;
import de.muenchen.vaadin.guilib.components.buttons.ActionButton;

/**
 * Provides a simple Form for creating a new Product_.
 */
public class Product_CreateForm extends Product_Form {
	/** Indicates the mode of the form. */
    protected static final boolean READ_ONLY = false;

	/** The layout for all Buttons. */
    protected final HorizontalLayout buttonLayout = new HorizontalLayout();
    
    /** The navigation for the save aciton. */
    protected final NavigateActions saveNavigation;
    
    /** The button for the save action. */
    protected final ActionButton saveButton = new ActionButton(Product_.class, SimpleAction.save);
    
	/**
	 * Create a new Product_CreateForm that navigates to the navigateTo View on save.
	 *
	 * @param navigateTo The String of the view to navigate to on save.
	 */
    public Product_CreateForm(final String navigateTo) {
        this.saveNavigation = new NavigateActions(navigateTo);
        init();
        setIds();
    }

    /**
     * Build the basic layout and insert the headline and all Buttons.
     */
    protected void init() {
		setReadOnly(READ_ONLY);

        getButtonLayout().setSpacing(true);
        getButtonLayout().addComponents(getSaveButton());

        configureSaveButton();

        getFormLayout().addComponent(getButtonLayout());
		getFields().stream().findFirst().ifPresent(Field::focus);
    }
    
    /**
	 * Set the IDs for important components.
	 */
	protected void setIds() {
		setId(getClass().getSimpleName());
		getFields().forEach(f -> f.setId(getId() + "#" + f.getId()));
		setId(getId() + "#form");
		getSaveButton().setId(getId() + "#save-button-" + getSaveNavigation().getNavigateTo());
	}
	
	/**
	 * Configures the action the save button performs after beeing clicked.
	 */
	protected void configureSaveButton() {
        Product_SingleActions productSingleActions = new Product_SingleActions(this::getProduct);
        getSaveButton().addActionPerformer(productSingleActions::create);
        getSaveButton().addActionPerformer(getSaveNavigation()::navigate);
        
        getSaveButton().useNotification(true);
    }
    

	// Getters
	@Override
	public Product_ getProduct(){
		Product_ product=super.getProduct();
		
		
		return product;
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
