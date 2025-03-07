package TestNG;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertEx {
	
	//all methods are non static in nature
	//if assert fail it will not stiop the execution,it will continue the execution
	//assertAll() method is mandatory...code/method required to track the fail status
	//if Assert fails throws AssertError exception
	//used for non mandatory fields
	
	@Test
	public void m1()
	{
		System.out.println("step1");
		System.out.println("step2");
        SoftAssert soft = new SoftAssert();
        soft.assertEquals(true, false);
		System.out.println("step3");
		System.out.println("step4");
		soft.assertAll();
	}

}
