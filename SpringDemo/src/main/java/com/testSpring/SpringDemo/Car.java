package com.testSpring.SpringDemo;

import org.springframework.stereotype.Component;

@Component
public class Car implements Vehicle{

public void drive()
{
	System.out.println("Driving car");
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
