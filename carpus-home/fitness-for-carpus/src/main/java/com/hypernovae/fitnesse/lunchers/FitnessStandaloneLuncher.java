package com.hypernovae.fitnesse.lunchers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FitnessStandaloneLuncher {
	private static final String DEFAULT_PATH = "./src/main/resources/";
	private static final String DEFAUL_PORT = "9899";
	private static final String COMMAND = "java -jar";
	private static final String STANDALONE_FITNESS = "fitnesse-standalone.jar";
	private static final String WHITE_SPACE = " ";
	private static final String PORT_SWITCH = "-p";
	
	public static void main(String[] args) throws IOException {
		String path = null;
		String port = null;
		
		path = (args != null && args.length>= 1)?args[0]:DEFAULT_PATH;
		port = (args != null && args.length==2)?args[1]:DEFAUL_PORT;
		
		StringBuilder requestBuilder = new StringBuilder();
		requestBuilder.append(COMMAND)
		.append(WHITE_SPACE)
		.append(path)
		.append(STANDALONE_FITNESS)
		.append(WHITE_SPACE)
		.append(PORT_SWITCH)
		.append(WHITE_SPACE)
		.append(port);
			
		// TODO: complete the request and 
		// TODO: look here: http://stackoverflow.com/questions/1320476/execute-another-jar-in-a-java-program
		
		System.out.println("Executing fitness via the command ...." + requestBuilder.toString());
		Process process = Runtime.getRuntime().exec(requestBuilder.toString());
	
		String consoleRequest = null;
		BufferedReader consoleReader = new BufferedReader (new InputStreamReader(System.in));
		while (true) {
			consoleRequest = consoleReader.readLine();
			if (consoleRequest != null && "EXIT".equalsIgnoreCase(consoleRequest)) {
				System.out.println("Exiting the standalone fitnesse execution....");
				process.destroy();
				break;
			}
		}
	
	}

}