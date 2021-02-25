package com.design.patterns.factorydesignpattern;

public class OSFactory {

	public OS getInstance(String os) {
		if (os.equals("Android"))
			return new Android();
		else if (os.equals("IOS"))
			return new IOS();
		else
			return new Windows();
	}
}