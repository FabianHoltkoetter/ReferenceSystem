package edu.hm.ba.kongo.shop.warehouse.guilib.gen.ui.components.entity.product;

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

import edu.hm.ba.kongo.shop.warehouse.client.local.Product_;
import de.muenchen.vaadin.guilib.util.FormUtil;
import de.muenchen.vaadin.guilib.components.BaseComponent;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Provides a very simple and basic Form for a Product_.
 * <p/>
 * If no Product_ is set, a blank user without an ID will be used. It has no buttons or additional components but can be
 * used for any Product_ you set it to.
 */
public class Product_Form extends BaseComponent {

    /** The class of the Entity of this Form. */
    public static final Class<Product_> ENTITY_CLASS = Product_.class;
    
    /** The FormLayout that contains all the form fields. */
    protected final FormLayout formLayout;
    
    /** Contains the current Product_ and handles the data binding. */
    protected final BeanFieldGroup<Product_> binder = new BeanFieldGroup<>(ENTITY_CLASS);
    
    /** A list of all the Fields. */
    protected final List<Field> fields;

    /**
     * Create a new Product_Form using the specified i18nResolver and the eventbus.
     * <p/>
     * This Form is only the plain fields for input, and has no additional components or buttons. You can use {@link
     * Product_Form#setReadOnly(boolean)} for a readonly mode.
     */
    public Product_Form() {
        binder.setItemDataSource(new Product_());
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
     * The Fields are data binded to the Product_.
     *
     * @return A List of all Components.
     */
    protected List<Field> buildFields() {
        final FormUtil formUtil = new FormUtil(getBinder());
        		
		final TextField name = formUtil.createTextField(Product_.Field.name.name());
		final TextArea description = formUtil.createTextArea(Product_.Field.description.name());
		final TextField price = formUtil.createTextField(Product_.Field.price.name());
		final TextField quantity = formUtil.createTextField(Product_.Field.quantity.name());
		
        return Arrays.asList(name, description, price, quantity);
    }
    

    /**
     * Get the Data-Binder of this Form.
     *
     * @return The binder.
     */
    protected BeanFieldGroup<Product_> getBinder() {
        return binder;
    }

    /**
     * Get the Product_ object of this form.
     *
     * @return The Product_.
     */
    public Product_ getProduct() {
        try {
            getBinder().commit();
        } catch (FieldGroup.CommitException e) {
            throw new Validator.InvalidValueException(FormUtil.getValidationErrorMessage(e));
        }
        Product_ product = getBinder().getItemDataSource().getBean();
        return product;
    }

    /**
     * Set the Product_ of this Form.
     *
     * @param product The new Product_.
     */
    public void setProduct(Product_ product) {
        getBinder().setItemDataSource(product == null ? new Product_() : product);
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
