package com.matteo.academicSystem.enums;

public enum TestClassification {
	
	P1(1),
	P2(2),
	P3(3);
	
	private int code;
	
	private TestClassification(int code) {
		this.code = code;
	}
	
	public int getCode() {
		return code;
	}
	
	public static TestClassification valueOf(int code) {
		for(TestClassification value : TestClassification.values()){
			if(code == value.getCode()) {
				return value;
			}
		}
		throw new IllegalArgumentException("Invalid order status code!");
	}
}
