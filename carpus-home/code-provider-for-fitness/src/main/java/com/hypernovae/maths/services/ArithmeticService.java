package com.hypernovae.maths.services;

public class ArithmeticService {
	
	public int sum(int...values) {
		int result = 0;
		for (int val:values) {
			result +=val;
		}
		return result;
	}
	
	public int modulo(int number, int diviser) {
		return number % diviser;
	}

}
