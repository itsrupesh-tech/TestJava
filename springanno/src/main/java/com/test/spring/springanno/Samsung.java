package com.test.spring.springanno;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
@Component

public class Samsung {
	@Autowired
	@Qualifier("mediaTech")
	MobileProcessor pm;
	
	public MobileProcessor getPm() {
		return pm;
	}

	public void setPm(MobileProcessor pm) {
		this.pm = pm;
	}

	public void config()
	{
		
		System.out.println("8gb ram 64 mp camera with octa core processor");
		pm.process();
		
	}

}
