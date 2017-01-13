package edu.hm.ba.kongo.shop.warehouse.guilib.services;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import edu.hm.ba.kongo.shop.warehouse.client.local.Product_;

/*
 * This file will be overwritten on every change of the model!
 * This file was automatically generated by GAIA.
 */
public class Product_FallbackDataGenerator{
	
	/** Fallback-Daten generierung. Diese Methoden werden durch Barrakuda mit dem gewünschten Verhalten befüllt. */
	
	
	/**
	 * Generiert Fallback-Daten für Methoden, die einen einzelnen Product_ zurückliefern.
	 * 
	 * @return Generierter fallback-Wert
	 */
	public static Product_ createProductFallback(){
		return null;
	}
	
	/**
	 * Generiert Fallback-Daten für Methoden, die eine Liste von Product_ zurückliefern.
	 * 
	 * @return Generierter fallback-Wert
	 */
	public static List<Product_> createProductsFallback(){
		return new ArrayList<>();
	}
	
	/**
	 * Generiert Fallback-Daten für Methoden, die ein Optional von Product_ zurückliefern.
	 * 
	 * @return Generierter fallback-Wert
	 */
	public static Optional<Product_> createOptionalProductFallback(){
		return Optional.empty();
	}
	
}