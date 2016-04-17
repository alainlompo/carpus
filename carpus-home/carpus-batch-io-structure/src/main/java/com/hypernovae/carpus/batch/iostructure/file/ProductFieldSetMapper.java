/**
 * 
 */
package com.hypernovae.carpus.batch.iostructure.file;

import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;

import com.hypernovae.carpus.batch.iostructure.Product;

/**
 * @author LOMPO
 *
 */
public class ProductFieldSetMapper implements FieldSetMapper<Product> {
	public Product mapFieldSet(FieldSet fieldSet) {
		Product product = new Product();
		product.setId(fieldSet.readString("id"));
		product.setName(fieldSet.readString("name"));
		product.setDescription(fieldSet.readString("description"));
		product.setPrice(fieldSet.readFloat("price"));
		return product;
	}
}

