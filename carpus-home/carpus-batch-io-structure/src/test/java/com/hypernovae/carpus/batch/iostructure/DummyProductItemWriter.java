/**
 * 
 */
package com.hypernovae.carpus.batch.iostructure;

import java.util.ArrayList;
import java.util.List;

import org.springframework.batch.item.ItemWriter;

import com.hypernovae.carpus.batch.iostructure.Product;

/**
 * @author LOMPO
 *
 */
public class DummyProductItemWriter implements ItemWriter<Product> {
	
	public List<Product> products = new ArrayList<Product>();

	/* (non-Javadoc)
	 * @see org.springframework.batch.item.ItemWriter#write(java.util.List)
	 */
	@Override
	public void write(List<? extends Product> items) throws Exception {
		//System.out.println("items = "+items.size());
		products.addAll(items);
	}

	public List<Product> getProducts() {
		return products;
	}
}
