package com.design.patterns.factorydesignpattern;

public class FactoryMain {

	public static void main(String[] args) {
		OSFactory osf = new OSFactory();
		OS obj = osf.getInstance("IOS");
		obj.spec();
	}
	public static void main(char[] args) {
		OSFactory osf = new OSFactory();
		OS obj = osf.getInstance("IOS");
		obj.spec();
	}
}
