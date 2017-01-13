package edu.hm.ba.kongo.shop.shoppingcart.guilib.gen.ui.components.entity.cartItem;

import com.vaadin.data.Validator;
import com.vaadin.server.Page;
import com.vaadin.ui.AbstractField;
import com.vaadin.ui.Component;
import com.vaadin.ui.CustomField;
import com.vaadin.ui.VerticalLayout;
import edu.hm.ba.kongo.shop.shoppingcart.client.local.CartItem_;
import de.muenchen.vaadin.demo.i18nservice.I18nPaths;
import de.muenchen.vaadin.demo.i18nservice.buttons.SimpleAction;
import de.muenchen.vaadin.guilib.BaseUI;
import de.muenchen.vaadin.guilib.components.BetterAccordion;
import de.muenchen.vaadin.guilib.components.GenericWarningNotification;
import de.muenchen.vaadin.guilib.components.buttons.ActionButton;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
/**
 * Created by rene.zarwel on 02.03.16.
 *
 * Custom Field for a Value Object List of CartItem_
 */
public class CartItem_Accordion extends CustomField<Set<CartItem_>> {
	/** Accordion is by default expanded on every tab **/
	private static final boolean DEFAULT_EXPAND = true;
	/** Accordion of CartItems **/
	private final BetterAccordion root = new BetterAccordion(DEFAULT_EXPAND);
	/** Container to save the CartItem linked by the Binder**/
	private Set<CartItem_> cartItemContainer;
	/** Components **/
	private List<CartItem_Form> cartItemForms = new ArrayList<>();
	/** The Formlayout**/
	private VerticalLayout formLayout = new VerticalLayout();
	
	public CartItem_Accordion() {
		super();
		initCreate();
	}
	/**
	* Initializes the Create form of a new CartItem_
	*/
	private void initCreate(){
		CartItem_Form form = new CartItem_Form();
		form.setReadOnly(false);
		//Configure Button to add an CartItem_
		ActionButton add = new ActionButton(CartItem_.class, SimpleAction.add);
		add.addActionPerformer(clickEvent -> {
			try {
				CartItem_ cartItem = form.getCartItem();
				if (!cartItemContainer.contains(cartItem)) {
					//Add CartItem Form
					addCartItemForm(cartItem);
					//Add CartItem to Container
					cartItemContainer.add(cartItem);
					//Reset CreateForm
					form.setCartItem(new CartItem_());
					form.getFields().stream()
					.map(field -> (AbstractField) field)
					.forEach(field -> field.setValidationVisible(false));
					return true;
				}
				else {
					GenericWarningNotification warn = new GenericWarningNotification(
					BaseUI.getCurrentI18nResolver().resolveRelative(CartItem_.class, I18nPaths.getNotificationPath(I18nPaths.NotificationType.warning, SimpleAction.add, I18nPaths.Type.label)),
					BaseUI.getCurrentI18nResolver().resolveRelative(CartItem_.class, I18nPaths.getNotificationPath(I18nPaths.NotificationType.warning, SimpleAction.add, I18nPaths.Type.text)));
					warn.show(Page.getCurrent());
					return false;
				}
			} catch (Exception e){
				return false;
			}
		});
		//Add Components
		form.getFormLayout().addComponent(add);
		formLayout.addComponents(form);
		root.addStaticContent(formLayout);
	}
	/**
	* Clears the whole Field and initializes the new Container
	* @param cartItemList
	*/
	public void setCartItemContainer(Set<CartItem_> cartItemList) {
		//Drop everything
		root.removeAllTabs();
		cartItemForms.clear();
		//Build new on new container
		cartItemContainer = cartItemList;
		cartItemList.forEach(this::addCartItemForm);
	}
	/**
	* Adds a single CartItemForm.
	* @param cartItem CartItem_ of new Form
	*/
	private void addCartItemForm(CartItem_ cartItem){
		//Build CartItemForm-Tab
		CartItem_Form form = new CartItem_Form();
		form.setCartItem(cartItem);
		cartItemForms.add(form);
		//Build Delete Button
		ActionButton delete = new ActionButton(CartItem_.class, SimpleAction.delete);
		//Build ReadOnly Listener to change Visibility
		ReadOnlyStatusChangeListener deleteListener = (ReadOnlyStatusChangeListener) event -> delete.setVisible(!isReadOnly());
		addReadOnlyStatusChangeListener(deleteListener);
		//On click remove everything of this cartItem and its components
		delete.addActionPerformer(clickEvent -> {
			cartItemContainer.remove(form.getCartItem());
			setCartItemContainer(cartItemContainer);
			removeReadOnlyStatusChangeListener(deleteListener);
			return true;
		});
		
		form.getFormLayout().addComponent(delete);
		root.addTab(form, String.valueOf(cartItemForms.size()));
	}
	
	@Override
	public void setReadOnly(boolean readOnly){
		super.setReadOnly(readOnly);
		cartItemForms.forEach(form -> form.setReadOnly(readOnly));
		formLayout.setVisible(!readOnly);
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public Class<? extends Set<CartItem_>> getType() {
		return (Class<Set<CartItem_>>)(Object)Set.class;
	}
	
	@Override
	protected Component initContent() {
		return root;
	}
	
	@Override
	protected void setInternalValue(Set<CartItem_> cartItem) {
		super.setInternalValue(cartItem);
		setCartItemContainer(cartItem);
	}
	
	@Override
	public void commit() throws SourceException, Validator.InvalidValueException {
		//Commit changes in the underlying forms too
		cartItemForms.forEach(CartItem_Form::getCartItem);
		super.commit();
	}
}
