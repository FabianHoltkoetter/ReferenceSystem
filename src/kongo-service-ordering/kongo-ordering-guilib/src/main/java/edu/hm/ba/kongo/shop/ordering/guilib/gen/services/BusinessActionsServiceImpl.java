package edu.hm.ba.kongo.shop.ordering.guilib.gen.services;


import edu.hm.ba.kongo.shop.ordering.client.businessactions.BusinessActionsRestClientImpl;

import de.muenchen.vaadin.guilib.services.SecurityService;
import de.muenchen.vaadin.guilib.BaseUI;
import de.muenchen.vaadin.guilib.components.GenericErrorNotification;
import de.muenchen.vaadin.demo.i18nservice.I18nPaths;
import de.muenchen.vaadin.demo.i18nservice.buttons.SimpleAction;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.vaadin.server.Page;
import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.spring.annotation.UIScope;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.client.RestTemplate;
		
import java.net.URI;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static de.muenchen.vaadin.demo.i18nservice.I18nPaths.getNotificationPath;

/**
 * Provides a simple Implementation for a GUI-Service that can perform BusinessActions.
 */
@SpringComponent("ordering_BusinessActionsService")
@UIScope
public class BusinessActionsServiceImpl implements BusinessActionsService {
	/** The Logger of the Class*/
    private static final Logger LOG = LoggerFactory.getLogger(BusinessActionsServiceImpl.class);
    /** Constant String for the timeout*/
    public static final String TIMEOUT_I18N = "timeout";
    /** Constant int for the timeout*/
	public static final int TIMEOUT_VAL = 5;

	/** The service used for getting the right RestTemplate. */
	private final SecurityService securityService;
	/** The Client used for the BusinessActions Operations. */
	private final BusinessActionsRestClientImpl client;
	/** The Template used to make the REST calls. */
	private RestTemplate template;
	
	/**
	 * Create a new BusinessActionsService to execute the BusinessActions in the GUI.
	 * @param infoService The infoService used for the base path of the Microservice.
	 * @param securityService The securityService.
	 */
	@Autowired
	public BusinessActionsServiceImpl(SecurityService securityService, @Value("${ORDERING.microservice.basePath}") String basePath) {
		this.securityService=securityService;
		
		final URI baseUri = URI.create(basePath);
		this.client = new BusinessActionsRestClientImpl(getTemplate(), baseUri);
	}
	
	/**
	 * Gets the resttemplate from the security if not present
	 * @return resttemplate of this session
	 */
	public RestTemplate getTemplate() {
		if (template != null) {
			return template;
		}
		return securityService.getRestTemplate().orElse(null);
	}
	
	@Override
	@HystrixCommand(fallbackMethod = "defaultOrderCart")
	public void orderCart(String cartID){
		client.orderCart(cartID);
		LOG.debug("Executed BusinessAction: orderCart " + "With Parameters:" +  " cartID: " + cartID);
	}
	public void defaultOrderCart(String cartID){
		LOG.error("Error during BusinessAction: orderCart " + "With Parameters:" +  " cartID: " + cartID);
		showErrorNotification(I18nPaths.NotificationType.error, SimpleAction.none);
	}
	
	@Override
	@HystrixCommand(fallbackMethod = "defaultSendInvoice")
	public void sendInvoice(String orderID){
		client.sendInvoice(orderID);
		LOG.debug("Executed BusinessAction: sendInvoice " + "With Parameters:" +  " orderID: " + orderID);
	}
	public void defaultSendInvoice(String orderID){
		LOG.error("Error during BusinessAction: sendInvoice " + "With Parameters:" +  " orderID: " + orderID);
		showErrorNotification(I18nPaths.NotificationType.error, SimpleAction.none);
	}
	
	@Override
	@HystrixCommand(fallbackMethod = "defaultCancelOrder")
	public void cancelOrder(String orderID){
		client.cancelOrder(orderID);
		LOG.debug("Executed BusinessAction: cancelOrder " + "With Parameters:" +  " orderID: " + orderID);
	}
	public void defaultCancelOrder(String orderID){
		LOG.error("Error during BusinessAction: cancelOrder " + "With Parameters:" +  " orderID: " + orderID);
		showErrorNotification(I18nPaths.NotificationType.error, SimpleAction.none);
	}

	/**
     * Shows an error notification
     * @param type the type of the notification
     * @param action the type of action performed
     */
    private void showErrorNotification(I18nPaths.NotificationType type, SimpleAction action) {
        GenericErrorNotification succes = new GenericErrorNotification(
                BaseUI.getCurrentI18nResolver().resolve("buisnessAction"+getNotificationPath(type, action, I18nPaths.Type.label)),
                BaseUI.getCurrentI18nResolver().resolve("buisnessAction"+getNotificationPath(type, action, I18nPaths.Type.text)));
        succes.show(Page.getCurrent());
    }

	/**
     * Shows an error notification specified by a status code
     * @param type the type of the notification
     * @param action the type of action performed
     * @param statusCode the status code
     */
    private void showErrorNotification(I18nPaths.NotificationType type, SimpleAction action, String statusCode) {
        GenericErrorNotification succes = new GenericErrorNotification(
                BaseUI.getCurrentI18nResolver().resolve("buisnessAction"+getNotificationPath(type, action, I18nPaths.Type.label, statusCode)),
                BaseUI.getCurrentI18nResolver().resolve("buisnessAction"+getNotificationPath(type, action, I18nPaths.Type.text, statusCode)));
        succes.show(Page.getCurrent());
    }
}
