package edu.hm.ba.kongo.shop.shoppingcart.guilib.gen.ui.components.entity.cart;

import com.vaadin.ui.Component;
import com.vaadin.ui.Field;
import com.vaadin.ui.HorizontalLayout;


import de.muenchen.vaadin.demo.apilib.domain.Principal;
import de.muenchen.vaadin.demo.i18nservice.buttons.SimpleAction;
import de.muenchen.vaadin.guilib.BaseUI;
import de.muenchen.vaadin.guilib.components.BaseComponent;
import de.muenchen.vaadin.guilib.components.buttons.ActionButton;

import edu.hm.ba.kongo.shop.shoppingcart.client.local.Cart_;
import edu.hm.ba.kongo.shop.shoppingcart.guilib.gen.ui.components.buttons.listener.cart.Cart_SingleActions;

/**
 * Provides a full-featured Form for a Cart_. It allows to view the current selected cart and edit it.
 */
public class Cart_ReadWriteForm extends BaseComponent {

    /** The default (readOnly/write) mode the Form initially starts. */
    public static final boolean DEFAULT_MODE = false;
    
    /** The button for the save action. */
	protected final ActionButton saveButton = new ActionButton(Cart_.class, SimpleAction.save);
	
	/** The button for the cancel action. */
	protected final ActionButton cancelButton = new ActionButton(Cart_.class, SimpleAction.cancel);
	
	/** The button for the edit action. */
	protected final ActionButton editButton = new ActionButton(Cart_.class, SimpleAction.update);

    /** The Form displaying the current selected Cart_. */
    protected final Cart_SelectedForm cartForm;
    
    /** The layout for all buttons that are shown in readonly mode. */
    protected final HorizontalLayout buttons = new HorizontalLayout();
    
    /** The layout for all buttons that are shown in the update mode. */
    protected final HorizontalLayout editButtons = new HorizontalLayout();
    
    /** The layout for all the buttons that are added aside from the standard buttons. */
	protected HorizontalLayout extraButtons = new HorizontalLayout();
    
    /** The current mode the RWForm is in. */
    protected boolean edit;
    
    /** the Principal of the User viewing this form */
    protected final Principal principal = BaseUI.getCurrentPrincipal().get();

    /**
     * Create a new Cart_ReadWriteForm with the internationalization of the Controller.
     * It will navigate to the navigateBack value on the back button click.
     */
    public Cart_ReadWriteForm() {
        cartForm = new Cart_SelectedForm();
        cartForm.reLoad();

        init();
        setIds();
    }

    /**
     * Initialize the Layout and all the Buttons in it.
     */
    protected void init() {
    	configureButtons();
		configureEditButtons();
    	
    	if(principal.getAuthorities().contains("shoppingcart_READ_Cart")){
	        getButtons().setSpacing(true);
	        getButtons().addComponents(editButton);
	        getEditButtons().setSpacing(true);
	        getEditButtons().addComponents(cancelButton, saveButton);
		}
		
        getForm().getFormLayout().addComponents(getButtons(), getEditButtons(), getExtraButtons());

        setEditable(DEFAULT_MODE);
        setCompositionRoot(getForm());
    }
    
    /**
	 * Set the IDs for important components.
	 */
	protected void setIds() {
		setId(getClass().getSimpleName());
		getForm().getFields().forEach(f -> f.setId(getId() + "#" + f.getId()));
		getForm().setId(getId() + "#form");
		getEditButton().setId(getId() + "#edit-button");
		getCancelButton().setId(getId() + "#cancel-button");
		getSaveButton().setId(getId() + "#save-button");
	}

    /**
     * Configures the edit Buttons for this form.
     * @return An array of all buttons.
     */
    protected void configureEditButtons() {
        final Cart_SingleActions singleActions = new Cart_SingleActions(getForm()::getCart);
        saveButton.addActionPerformer(singleActions::update);
        saveButton.addActionPerformer(clickEvent -> {
            setEditable(false);
            return true;
        });
        saveButton.useNotification(true);
        getSaveButton().setNotifyAction(SimpleAction.update);

        cancelButton.addActionPerformer(singleActions::reRead);
        cancelButton.addActionPerformer(clickEvent -> {
            setEditable(false);
            return true;
        });
    }

    /**
     * Configures the Buttons for the readOnly mode.
     * @return An array of all buttons.
     */
    protected void configureButtons() {
        editButton.addClickListener(clickEvent -> setEditable(true));
    }

    /**
     * Set the mode of this form. True means edit and false means readOnly.
     * @param edit true means edit mode.
     */
    protected void setEditable(boolean edit) {
        this.edit = edit;

        getButtons().setVisible(!isEditable());
        getEditButtons().setVisible(isEditable());
        getForm().setReadOnly(!isEditable());

        if (isEditable())
            getForm().getFields().stream().findFirst().ifPresent(Field::focus);
    }

	// Getters
    /**
     * Get the Layout for Buttons of the readOnly mode.
     * @return The Layout for the readOnly mode Buttons.
     */
    public HorizontalLayout getButtons() {
        return buttons;
    }

    public HorizontalLayout getExtraButtons() {
        return extraButtons;
    }

    /**
     * Check if this Form is in Edit mode.
     * @return true, if it is in edit mode.
     */
    public boolean isEditable() {
        return edit;
    }

    /**
     * Get the Layout for the Buttons that is shown in edit mode.
     * @return The layout for edit mode.
     */
    public HorizontalLayout getEditButtons() {
        return editButtons;
    }

    /**
     * Get the Cart_SelectedForm used by this RWForm.
     * @return The Cart_SelectedForm.
     */
    public Cart_SelectedForm getForm() {
        return cartForm;
    }
    
    public ActionButton getEditButton() {
		return editButton;
	}
	
	public ActionButton getCancelButton() {
		return cancelButton;
	}
	
	public ActionButton getSaveButton() {
		return saveButton;
	}
	
	public Component addButton(ActionButton button){
    	extraButtons.addComponent(button);
    	return this;
	}
}

