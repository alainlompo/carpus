package com.hypernovae.carpus.batch.core.domain;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import com.hypernovae.fitnesse.utils.BatchUtils;

public class ProductFixture {
	private String id;
	private String name;
	private String description;
	private String price;
	private final Map<String,Product> PRODUCT_MAP = new HashMap<String,Product>(); 
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String creer() {
		if (PRODUCT_MAP.containsKey(id)) {			
			return BatchUtils.ALREADY_EXITS;
		}
		Product product = new Product(id);
		product.setDescription(description);
		product.setName(name);
		product.setPrice(BigDecimal.valueOf(Double.parseDouble(price)));
		PRODUCT_MAP.put(id, product);
		return id;
	}
}
