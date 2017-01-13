package edu.hm.ba.kongo.shop.shoppingcart.guilib.gen.ui.components.entity.cart;

import com.vaadin.data.fieldgroup.BeanFieldGroup;
import com.vaadin.data.fieldgroup.FieldGroup;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.DateField;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.TextField;
import com.vaadin.ui.TextArea;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.CheckBox;
import com.vaadin.ui.Field;
import com.vaadin.ui.themes.ValoTheme;
import org.vaadin.tokenfield.TokenField;
import com.vaadin.data.Validator;

import edu.hm.ba.kongo.shop.shoppingcart.client.local.Cart_;
import de.muenchen.vaadin.guilib.util.FormUtil;
import de.muenchen.vaadin.guilib.components.BaseComponent;
import edu.hm.ba.kongo.shop.shoppingcart.guilib.gen.ui.components.entity.cartItem.CartItem_Form;
import edu.hm.ba.kongo.shop.shoppingcart.guilib.gen.ui.components.entity.cartItem.CartItem_Accordion;
import de.muenchen.vaadin.demo.i18nservice.I18nPaths;
import com.vaadin.ui.AbstractField;
import java.util.HashSet;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Provides a very simple and basic Form for a Cart_.
 * <p/>
 * If no Cart_ is set, a blank user without an ID will be used. It has no buttons or additional components but can be
 * used for any Cart_ you set it to.
 */
public class Cart_Form extends BaseComponent {

    /** The class of the Entity of this Form. */
    public static final Class<Cart_> ENTITY_CLASS = Cart_.class;
    
    /** The FormLayout that contains all the form fields. */
    protected final FormLayout formLayout;
    
    /** Contains the current Cart_ and handles the data binding. */
    protected final BeanFieldGroup<Cart_> binder = new BeanFieldGroup<>(ENTITY_CLASS);
    
    /** A list of all the Fields. */
    protected final List<Field> fields;

	/**
	 * Form of the items of this Cart.
	 */
	protected final CartItem_Form items_Form = new CartItem_Form();

    /**
     * Create a new Cart_Form using the specified i18nResolver and the eventbus.
     * <p/>
     * This Form is only the plain fields for input, and has no additional components or buttons. You can use {@link
     * Cart_Form#setReadOnly(boolean)} for a readonly mode.
     */
    public Cart_Form() {
        binder.setItemDataSource(new Cart_());
        fields = buildFields();

        final FormLayout formLayout = new FormLayout();
        formLayout.addStyleName(ValoTheme.FORMLAYOUT_LIGHT);
        fields.stream().forEach(formLayout::addComponent);
        

        this.formLayout = formLayout;
        setCompositionRoot(formLayout);
    }


    /**
     * Build all the (input) Fields used by this form.
     * <p/>
     * The Fields are data binded to the Cart_.
     *
     * @return A List of all Components.
     */
    protected List<Field> buildFields() {
        final FormUtil formUtil = new FormUtil(getBinder());
        		
		final TextField userID = formUtil.createTextField(Cart_.Field.userID.name());
		final TextField totalPrice = formUtil.createTextField(Cart_.Field.totalPrice.name());
		
        return Arrays.asList(userID, totalPrice);
    }
    

    /**
     * Get the Data-Binder of this Form.
     *
     * @return The binder.
     */
    protected BeanFieldGroup<Cart_> getBinder() {
        return binder;
    }

    /**
     * Get the Cart_ object of this form.
     *
     * @return The Cart_.
     */
    public Cart_ getCart() {
        try {
            getBinder().commit();
        } catch (FieldGroup.CommitException e) {
            throw new Validator.InvalidValueException(FormUtil.getValidationErrorMessage(e));
        }
        Cart_ cart = getBinder().getItemDataSource().getBean();
        return cart;
    }

    /**
     * Set the Cart_ of this Form.
     *
     * @param cart The new Cart_.
     */
    public void setCart(Cart_ cart) {
        getBinder().setItemDataSource(cart == null ? new Cart_() : cart);
    }

    /**
     * Get the layout of this form, containing all the Fields.
     *
     * @return The base Layout.
     */
    public FormLayout getFormLayout() {
        return formLayout;
    }

    @Override
    public void setReadOnly(boolean readOnly) {
        getBinder().setReadOnly(readOnly);
    }

    /**
     * Get all the (input) Fields of this form as a list.
     *
     * @return The list of components.
     */
    public List<Field> getFields() {
        return Collections.unmodifiableList(fields);
    }

}
