/**
 * 
 */
package com.hypernovae.carpus.batch.scheduler;

import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.launch.support.ExitCodeMapper;

/**
 * @author LOMPO
 *
 */
public class SkippedAwareExitCodeMapper implements ExitCodeMapper {

	/* (non-Javadoc)
	 * @see org.springframework.batch.core.launch.support.ExitCodeMapper#intValue(java.lang.String)
	 */
	@Override
	public int intValue(String exitCode) {
		if(ExitStatus.COMPLETED.getExitCode().equals(exitCode)) {
			return 0;
		} else if(ExitStatus.FAILED.getExitCode().equals(exitCode)) {
			return 1;
		} else if("COMPLETED WITH SKIPS".equals(exitCode)) {
			return 3;
		} else {
			return 2;
		}
	}

}
