/**
 * 
 */
package com.hypernovae.carpus.batch.iostructure.file;

import org.junit.Test;
import org.springframework.batch.core.JobParameters;
import org.springframework.test.context.ContextConfiguration;

import com.hypernovae.carpus.batch.iostructure.AbstractJobStructureTest;

/**
 * @author LOMPO
 *
 */
@ContextConfiguration
public class JobStructureDelimitedMultiFlatFileTest extends AbstractJobStructureTest {

	@Test public void delimitedJob() throws Exception {
		jobLauncher.run(job, new JobParameters());
		checkProducts(writer.getProducts(), new String[] { "PRM....210", "PRM....211", "PRB....734",
						 "PRM....212", "PRB....735", "PRM....213", "PRB....736", "PRM....214" });
	}
	
	
}
