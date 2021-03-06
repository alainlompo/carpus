/**
 * 
 */
package com.hypernovae.carpus.batch.tools.structure;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author LOMPO
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class JobStructureSimpleTest {

	@Autowired
	private Job job;
	
	@Autowired
	private JobLauncher jobLauncher;
	
	@Test public void simpleJob() throws Exception {
		jobLauncher.run(job, new JobParameters());
	}
	
	
}
