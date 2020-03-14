package com.testSpring.SpringDemo;


import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
//import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class App 
{
    public static void main( String[] args )
    {
    	ApplicationContext context=new ClassPathXmlApplicationContext("spring.xml");
		/*
		 * Vehicle v=(Vehicle) context.getBean("car"); Vehicle v1=(Vehicle)
		 * context.getBean("bike"); v.drive(); v1.drive();
		 */
    	
    	Tyre tyre=(Tyre)context.getBean("tyre");
    	System.out.println(tyre);
       ((ConfigurableApplicationContext)context).close();
       
       
      
    }
}
