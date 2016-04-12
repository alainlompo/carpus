package com.hypernovae.fixtures.reference;

import com.hypernovae.maths.services.ArithmeticService;

public class ArithmeticServiceFixture {
	
	private final com.hypernovae.maths.services.ArithmeticService SERVICE = new com.hypernovae.maths.services.ArithmeticService();
	
	private String number1, number2, number3, number4;
	private String numToDivide, divider;
	
	public ArithmeticServiceFixture() {}
	
	public String getNumber1() {
		return number1;
	}
	public void setNumber1(String number1) {
		this.number1 = number1;
	}
	public String getNumber2() {
		return number2;
	}
	public void setNumber2(String number2) {
		this.number2 = number2;
	}
	public String getNumber3() {
		return number3;
	}
	public void setNumber3(String number3) {
		this.number3 = number3;
	}
	public String getNumber4() {
		return number4;
	}
	public void setNumber4(String number4) {
		this.number4 = number4;
	}
	public String getNumToDivide() {
		return numToDivide;
	}
	public void setNumToDivide(String numToDivide) {
		this.numToDivide = numToDivide;
	}
	public String getDiviser() {
		return divider;
	}
	public void setDivider(String divider) {
		this.divider = divider;
	}
	
	public int sum() {
				
		String[] numbers = {number1, number2, number3, number4};
		int numOfVals =0;
		for (int i = 0; i < 4; i++) {
			if ( numbers[i] != null && (!numbers[i].trim().equals("")) ) {
				numOfVals++;
			}
		}
		int[] values = new int[numOfVals];
		for (int i = 0; i < numOfVals;i++) {
			values[i] =Integer.parseInt( numbers[i]);
		}
		
		return SERVICE.sum(values);
		
	}
	
	public int modulo() {
		int nToDivide = Integer.parseInt(numToDivide);
		int dvDer = Integer.parseInt(divider);
		return SERVICE.modulo(nToDivide, dvDer);
	}
}
