package com.testSpring.SpringDemo;

import org.springframework.stereotype.Component;

@Component
public class Bike implements Vehicle {
 public void drive() {
	 
	 System.out.println("Driving bike:");
	
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
