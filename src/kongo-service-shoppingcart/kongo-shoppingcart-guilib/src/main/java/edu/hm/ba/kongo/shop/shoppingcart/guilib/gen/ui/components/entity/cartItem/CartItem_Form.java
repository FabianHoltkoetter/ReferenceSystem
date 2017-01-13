package edu.hm.ba.kongo.shop.shoppingcart.guilib.gen.ui.components.entity.cartItem;

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

import edu.hm.ba.kongo.shop.shoppingcart.client.local.CartItem_;
import de.muenchen.vaadin.guilib.util.FormUtil;
import de.muenchen.vaadin.guilib.components.BaseComponent;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Provides a very simple and basic Form for a CartItem_.
 * <p/>
 * If no CartItem_ is set, a blank user without an ID will be used. It has no buttons or additional components but can be
 * used for any CartItem_ you set it to.
 */
public class CartItem_Form extends BaseComponent {

    /** The class of the Entity of this Form. */
    public static final Class<CartItem_> ENTITY_CLASS = CartItem_.class;
    
    /** The FormLayout that contains all the form fields. */
    protected final FormLayout formLayout;
    
    /** Contains the current CartItem_ and handles the data binding. */
    protected final BeanFieldGroup<CartItem_> binder = new BeanFieldGroup<>(ENTITY_CLASS);
    
    /** A list of all the Fields. */
    protected final List<Field> fields;

    /**
     * Create a new CartItem_Form using the specified i18nResolver and the eventbus.
     * <p/>
     * This Form is only the plain fields for input, and has no additional components or buttons. You can use {@link
     * CartItem_Form#setReadOnly(boolean)} for a readonly mode.
     */
    public CartItem_Form() {
        binder.setItemDataSource(new CartItem_());
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
     * The Fields are data binded to the CartItem_.
     *
     * @return A List of all Components.
     */
    protected List<Field> buildFields() {
        final FormUtil formUtil = new FormUtil(getBinder());
        		
		final TextField product = formUtil.createTextField(CartItem_.Field.product.name());
		final TextField quantity = formUtil.createTextField(CartItem_.Field.quantity.name());
		
        return Arrays.asList(product, quantity);
    }
    

    /**
     * Get the Data-Binder of this Form.
     *
     * @return The binder.
     */
    protected BeanFieldGroup<CartItem_> getBinder() {
        return binder;
    }

    /**
     * Get the CartItem_ object of this form.
     *
     * @return The CartItem_.
     */
    public CartItem_ getCartItem() {
        try {
            getBinder().commit();
        } catch (FieldGroup.CommitException e) {
            throw new Validator.InvalidValueException(FormUtil.getValidationErrorMessage(e));
        }
        CartItem_ cartItem = getBinder().getItemDataSource().getBean();
        return cartItem;
    }

    /**
     * Set the CartItem_ of this Form.
     *
     * @param cartItem The new CartItem_.
     */
    public void setCartItem(CartItem_ cartItem) {
        getBinder().setItemDataSource(cartItem == null ? new CartItem_() : cartItem);
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
