/**
 * 
 */
package com.hypernovae.carpus.batch.tools.structure;

import java.util.ArrayList;
import java.util.List;

import org.springframework.batch.item.ItemWriter;
import com.hypernovae.carpus.batch.core.domain.Product;


/**
 * @author acogoluegnes
 *
 */
public class DummyItemWriter implements ItemWriter<Product> {
	
	public List<Product> products = new ArrayList<Product>();

	/* (non-Javadoc)
	 * @see org.springframework.batch.item.ItemWriter#write(java.util.List)
	 */
	@Override
	public void write(List<? extends Product> items) throws Exception {
		products.addAll(items);
	}

}
