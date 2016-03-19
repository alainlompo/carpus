/**
 * 
 */
package com.hypernovae.product.poc.domain;

import junit.framework.Assert;

import org.junit.Test;
import org.springframework.batch.core.JobParameters;
import org.springframework.test.context.ContextConfiguration;

/**
 * @author LOMPO
 *
 */
@ContextConfiguration()
public class JobStructureTest extends AbstractJobStructureTest {

	@Test public void delimitedJob() throws Exception {
		jobLauncher.run(job, new JobParameters());
		
	}
	
	
}
