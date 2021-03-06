package edu.hm.ba.kongo.shop.warehouse.service.gen.controller.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.core.event.AbstractRepositoryEventListener;
import org.springframework.stereotype.Component;

import edu.hm.ba.kongo.shop.warehouse.service.gen.domain.Product_;
import edu.hm.ba.kongo.shop.warehouse.service.gen.services.event.Product_EventService;

/*
 * This file will be overwritten on every change of the model!
 * This file was automatically generated by GAIA.
 */
/**
 * This event-listener allows a Product_EventService to implement logic before and after Events.
 */
@Component
public class Product_EventListener extends AbstractRepositoryEventListener<Product_>{
	@Autowired
	Product_EventService service;
	
	@Override
	protected void onAfterCreate(Product_ entity) {
		service.onAfterCreate(entity);
	}
	@Override
	protected void onBeforeCreate(Product_ entity) {
		service.onBeforeCreate(entity);
	}
	@Override
	protected void onBeforeSave(Product_ entity) {
		service.onBeforeSave(entity);
	}
	@Override
	protected void onAfterSave(Product_ entity) {
		service.onAfterSave(entity);
	}
	@Override
	protected void onBeforeLinkSave(Product_ parent, Object linked) {
		service.onBeforeLinkSave(parent, linked);
	}
	@Override
	protected void onAfterLinkSave(Product_ parent, Object linked) {
		service.onAfterLinkSave(parent, linked);
	}
	@Override
	protected void onBeforeLinkDelete(Product_ parent, Object linked) {
		service.onBeforeLinkDelete(parent, linked);
	}
	@Override
	protected void onBeforeDelete(Product_ entity) {
		service.onBeforeDelete(entity);
	}
	@Override
	protected void onAfterDelete(Product_ entity) {
		service.onAfterDelete(entity);
	}
	@Override
	protected void onAfterLinkDelete(Product_ parent, Object linked) {
		service.onAfterLinkDelete(parent, linked);
	}
}
