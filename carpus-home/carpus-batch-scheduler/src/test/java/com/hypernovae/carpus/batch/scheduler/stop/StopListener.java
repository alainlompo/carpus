/**
 * 
 */
package com.hypernovae.carpus.batch.scheduler.stop;

import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.annotation.AfterRead;
import org.springframework.batch.core.annotation.BeforeStep;

/**
 * @author LOMPO
 *
 */
public class StopListener {

	private StepExecution stepExecution;
	
	private boolean stop = false;
	
	@BeforeStep
	public void beforeStep(StepExecution stepExecution) {
		this.stepExecution = stepExecution;
	}
	
	@AfterRead
	public void afterRead() {
		if(stopConditionsMet()) {
			stepExecution.setTerminateOnly();
		}
	}

	private boolean stopConditionsMet() {
		return stop;
	}
	
	public void setStop(boolean stop) {
		this.stop = stop;
	}
	
}
