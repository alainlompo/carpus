/**
 * 
 */
package com.hypernovae.carpus.batch.core.batch;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.core.io.ClassPathResource;


/**
 * @author LOMPO
 *
 */
public class DecompressTaskletTest {

	private static final String[] EXPECTED_CONTENT = new String[] {
		"ISBN,NAME,DESCRIPTION,PRICE",
		"ABS985-8354S,4 principes fondamentaux, supernatural healing,1.60",
		"ACR185-8254S,allons et guérissons les malades, supernatural healing,1.60",
		"ADQ285-8154S,back to reality, supernatural living,1.60",
		"AEP385-8254S,cleansing the conscience, supernatural righteousness,1.60",
		"AFO485-8354S,faith builders, supernatural faith,1.60",
		"AGN585-8454S,new creation, supernatural living,1.60",
		"AHM685-8554S,The new self, supernatural living,1.60"
	};
	
	@Test public void execute() throws Exception {
		DecompressTasklet tasklet = new DecompressTasklet();
		tasklet.setInputResource(new ClassPathResource("/input/books.zip"));
		File outputDir = new File("./target/decompresstasklet");
		if(outputDir.exists()) {
			FileUtils.deleteDirectory(outputDir);
		}
		tasklet.setTargetDirectory(outputDir.getAbsolutePath());
		tasklet.setTargetFile("books.txt");
		
		tasklet.execute(null, null);
		
		File output = new File(outputDir,"books.txt");
		Assert.assertTrue(output.exists());
		
		Assert.assertArrayEquals(EXPECTED_CONTENT, FileUtils.readLines(output).toArray());
		
	}
	
	@Test public void corruptedArchive() throws Exception {
		DecompressTasklet tasklet = new DecompressTasklet();
		tasklet.setInputResource(new ClassPathResource("/input/books_corrupted.zip"));
		File outputDir = new File("./target/decompresstasklet");
		if(outputDir.exists()) {
			FileUtils.deleteDirectory(outputDir);
		}
		tasklet.setTargetDirectory(outputDir.getAbsolutePath());
		tasklet.setTargetFile("books.txt");
		
		try {
			tasklet.execute(null, null);
			Assert.fail("corrupted archive, the tasklet should have thrown an exception");
		} catch (Exception e) {
			// OK
		}
	}
	
}
