package com.test.spring.springanno;

//import org.springframework.context.annotation.Primary;
//import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
//@Primary
public class MediaTech implements MobileProcessor {

	public void process() {
		System.out.println("2nd cbestr cpu");

	}

}
