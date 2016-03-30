/**
 * 
 */
package com.hypernovae.carpus.batch.scheduler.stop;

import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;

/**
 * @author LOMPO
 *
 */
public class InfiniteReader implements ItemReader<String> {
	
	private int count = 0;

	/* (non-Javadoc)
	 * @see org.springframework.batch.item.ItemReader#read()
	 */
	@Override
	public String read() throws Exception, UnexpectedInputException,
			ParseException, NonTransientResourceException {
		return ++count+"";
	}

}
