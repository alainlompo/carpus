package com.hypernovae.carpus.batch.tools;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class KeyboardUtils {
	
	private static BufferedReader kbReader;
	private static InputStream kbStream;
	private static InputStreamReader streamConverter;
	
	public static void  init() {
		kbStream = System.in;
		streamConverter = new InputStreamReader(kbStream);
		kbReader = new BufferedReader(streamConverter);
		
	}
	
	public static String readLine() throws IOException {
		return kbReader.readLine();
		
	}
	
	

}
