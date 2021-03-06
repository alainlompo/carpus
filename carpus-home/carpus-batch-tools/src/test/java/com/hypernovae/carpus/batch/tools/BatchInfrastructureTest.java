/**
 * 
 */
package com.hypernovae.carpus.batch.tools;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Checks that the database infrastructure is ok.
 * @author acogoluegnes
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={
	"/com/hypernovae/batch/corecontexts/batch-infrastructure-context.xml",
	"/com/hypernovae/batch/corecontexts/root-database-context.xml"
})
public class BatchInfrastructureTest {

	@Autowired
	private JobRepository jobRepository;
	
	@Test public void jobRepository() {
		Assert.assertFalse(jobRepository.isJobInstanceExists("dummy-job", new JobParameters()));
	}
	
}
