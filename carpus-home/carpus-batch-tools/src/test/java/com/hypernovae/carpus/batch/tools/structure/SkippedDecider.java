/**
 * 
 */
package com.hypernovae.carpus.batch.tools.structure;

import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.job.flow.FlowExecutionStatus;
import org.springframework.batch.core.job.flow.JobExecutionDecider;

/**
 * @author LOMPO
 *
 */
public class SkippedDecider implements JobExecutionDecider {

	/* (non-Javadoc)
	 * @see org.springframework.batch.core.job.flow.JobExecutionDecider#decide(org.springframework.batch.core.JobExecution, org.springframework.batch.core.StepExecution)
	 */
	@Override
	public FlowExecutionStatus decide(JobExecution jobExecution,
			StepExecution stepExecution) {
		return stepExecution.getSkipCount() == 0 ? FlowExecutionStatus.COMPLETED : new FlowExecutionStatus("SKIPPED");
	}

}
