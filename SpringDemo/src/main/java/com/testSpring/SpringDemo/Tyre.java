package com.testSpring.SpringDemo;

import org.springframework.stereotype.Component;

@Component
public class Tyre {
	/*
	 * private Tyre(String brand) { super(); this.brand = brand; }
	 */
private String brand;

public String getBrand() {
	return brand;
}

public void setBrand(String brand) {
	this.brand = brand;
}

@Override
public String toString() {
	return "MRF";
}
public void init()
{
	System.out.println("Inside init method:");
}
public void destroy()
{
	System.out.println("iniside destroy method");
}

}
