package edu.hm.ba.kongo.shop.ordering.guilib.gen.ui.components.entity.orderingItem;

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

import edu.hm.ba.kongo.shop.ordering.client.local.OrderingItem_;
import de.muenchen.vaadin.guilib.util.FormUtil;
import de.muenchen.vaadin.guilib.components.BaseComponent;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Provides a very simple and basic Form for a OrderingItem_.
 * <p/>
 * If no OrderingItem_ is set, a blank user without an ID will be used. It has no buttons or additional components but can be
 * used for any OrderingItem_ you set it to.
 */
public class OrderingItem_Form extends BaseComponent {

    /** The class of the Entity of this Form. */
    public static final Class<OrderingItem_> ENTITY_CLASS = OrderingItem_.class;
    
    /** The FormLayout that contains all the form fields. */
    protected final FormLayout formLayout;
    
    /** Contains the current OrderingItem_ and handles the data binding. */
    protected final BeanFieldGroup<OrderingItem_> binder = new BeanFieldGroup<>(ENTITY_CLASS);
    
    /** A list of all the Fields. */
    protected final List<Field> fields;

    /**
     * Create a new OrderingItem_Form using the specified i18nResolver and the eventbus.
     * <p/>
     * This Form is only the plain fields for input, and has no additional components or buttons. You can use {@link
     * OrderingItem_Form#setReadOnly(boolean)} for a readonly mode.
     */
    public OrderingItem_Form() {
        binder.setItemDataSource(new OrderingItem_());
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
     * The Fields are data binded to the OrderingItem_.
     *
     * @return A List of all Components.
     */
    protected List<Field> buildFields() {
        final FormUtil formUtil = new FormUtil(getBinder());
        		
		final TextField cart = formUtil.createTextField(OrderingItem_.Field.cart.name());
		final DateField orderedOn = formUtil.createDateField(OrderingItem_.Field.orderedOn.name());
		
        return Arrays.asList(cart, orderedOn);
    }
    

    /**
     * Get the Data-Binder of this Form.
     *
     * @return The binder.
     */
    protected BeanFieldGroup<OrderingItem_> getBinder() {
        return binder;
    }

    /**
     * Get the OrderingItem_ object of this form.
     *
     * @return The OrderingItem_.
     */
    public OrderingItem_ getOrderingItem() {
        try {
            getBinder().commit();
        } catch (FieldGroup.CommitException e) {
            throw new Validator.InvalidValueException(FormUtil.getValidationErrorMessage(e));
        }
        OrderingItem_ orderingItem = getBinder().getItemDataSource().getBean();
        return orderingItem;
    }

    /**
     * Set the OrderingItem_ of this Form.
     *
     * @param orderingItem The new OrderingItem_.
     */
    public void setOrderingItem(OrderingItem_ orderingItem) {
        getBinder().setItemDataSource(orderingItem == null ? new OrderingItem_() : orderingItem);
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
