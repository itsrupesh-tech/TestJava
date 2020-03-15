package com.test.spring.springanno;
//import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;


@Component
public class SsnapDragon implements MobileProcessor {

	public void process() {
		System.out.println("World best cpu");

	}

}
