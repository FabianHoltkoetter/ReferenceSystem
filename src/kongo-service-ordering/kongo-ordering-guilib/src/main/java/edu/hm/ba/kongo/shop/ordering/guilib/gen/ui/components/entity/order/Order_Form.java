package edu.hm.ba.kongo.shop.ordering.guilib.gen.ui.components.entity.order;

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

import edu.hm.ba.kongo.shop.ordering.client.local.Order_;
import de.muenchen.vaadin.guilib.util.FormUtil;
import de.muenchen.vaadin.guilib.components.BaseComponent;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Provides a very simple and basic Form for a Order_.
 * <p/>
 * If no Order_ is set, a blank user without an ID will be used. It has no buttons or additional components but can be
 * used for any Order_ you set it to.
 */
public class Order_Form extends BaseComponent {

    /** The class of the Entity of this Form. */
    public static final Class<Order_> ENTITY_CLASS = Order_.class;
    
    /** The FormLayout that contains all the form fields. */
    protected final FormLayout formLayout;
    
    /** Contains the current Order_ and handles the data binding. */
    protected final BeanFieldGroup<Order_> binder = new BeanFieldGroup<>(ENTITY_CLASS);
    
    /** A list of all the Fields. */
    protected final List<Field> fields;

    /**
     * Create a new Order_Form using the specified i18nResolver and the eventbus.
     * <p/>
     * This Form is only the plain fields for input, and has no additional components or buttons. You can use {@link
     * Order_Form#setReadOnly(boolean)} for a readonly mode.
     */
    public Order_Form() {
        binder.setItemDataSource(new Order_());
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
     * The Fields are data binded to the Order_.
     *
     * @return A List of all Components.
     */
    protected List<Field> buildFields() {
        final FormUtil formUtil = new FormUtil(getBinder());
        		
		final TextField cart = formUtil.createTextField(Order_.Field.cart.name());
		final DateField orderedOn = formUtil.createDateField(Order_.Field.orderedOn.name());
		
        return Arrays.asList(cart, orderedOn);
    }
    

    /**
     * Get the Data-Binder of this Form.
     *
     * @return The binder.
     */
    protected BeanFieldGroup<Order_> getBinder() {
        return binder;
    }

    /**
     * Get the Order_ object of this form.
     *
     * @return The Order_.
     */
    public Order_ getOrder() {
        try {
            getBinder().commit();
        } catch (FieldGroup.CommitException e) {
            throw new Validator.InvalidValueException(FormUtil.getValidationErrorMessage(e));
        }
        Order_ order = getBinder().getItemDataSource().getBean();
        return order;
    }

    /**
     * Set the Order_ of this Form.
     *
     * @param order The new Order_.
     */
    public void setOrder(Order_ order) {
        getBinder().setItemDataSource(order == null ? new Order_() : order);
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
