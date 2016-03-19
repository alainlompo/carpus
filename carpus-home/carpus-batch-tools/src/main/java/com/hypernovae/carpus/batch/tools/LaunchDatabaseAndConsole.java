/**
 * 
 */
package com.hypernovae.carpus.batch.tools;

import org.h2.tools.Console;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author LOMPO
 *
 */
public class LaunchDatabaseAndConsole {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		new ClassPathXmlApplicationContext(
			"/com/hypernovae/batch/corecontexts/batch-infrastructure-context.xml",
			"/com/hypernovae/batch/corecontexts/root-database-context.xml"
		);
		Console.main(args);
	}

}
