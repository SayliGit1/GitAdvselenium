package TestNG;

import org.testng.Assert;
import org.testng.annotations.Test;

public class HardAssertEx {
	//hardAssert is static in nature
	//in hardAssert whenever @test/assert is failed,it will stop the execution at the same line
	//If hardAssrt fail it will throws assertaError exception
	//hardAssert is used only for mandatory fields
	
	@Test
	public void m1()
	{
		System.out.println("step1");
		System.out.println("step2");
		Assert.assertEquals("v", "A");
		System.out.println("step3");
		System.out.println("step4");

	}
	
	@Test
	public void m2()
	{
		String exp = "Sayli";
		String act = "sayli";
		Assert.assertEquals(act, exp);
	}

	@Test
	public void m3()
	{
		int e = 10;
		int a = 10;
		Assert.assertEquals(a, e, "both are not equal");
		System.out.println("both are equal");
	}
	
	@Test
	public void m4()
	{
		int e = 10;
		int a = 50;
		Assert.assertEquals(a, e, "both are not equal");
		System.out.println("both are equal");
	}
	
	@Test
	public void m5()
	{
		int e = 10;
		int a = 50;
		Assert.assertNotEquals(a, e, "Equal values"); //if this statement false then this msg will execute
		System.out.println("Values are not equal");
	}
	
	@Test
	public void m6() 
	{
		int e = 200;
		int a = 200;
		Assert.assertNotEquals(a, e ,"Equal values");
		System.out.println("Values are not equal");

	}
	
	@Test
	public void m7()
	{
		String exp = "hello";
		String act = "hello";
		Assert.assertTrue(act.equalsIgnoreCase(exp), "AssertFalse");
		System.out.println("AssertTrue");
	}
	
	@Test
	public void m8()
	{
		String exp = "hello";
		String act = "hello...";
		Assert.assertTrue(act.equalsIgnoreCase(exp), "AssertFail");
		System.out.println("AssertTrue");
	}
	
	@Test
	public void m9()
	{
		String exp = "hello";
		String act = "hello...";
		Assert.assertFalse(act.equalsIgnoreCase(exp), "Assert fail");
		System.out.println("Assert true");
	}
	
	@Test
	public void m10()
	{
		String s =null;
		Assert.assertNull(s, "It is not Null");
		System.out.println("It is null");
	}
	
	@Test
	public void m11()
	{
		String s ="sayli";
        Assert.assertNull(s, "It is not null");
        System.out.println("It is Null");
	}
	
	@Test
	public void m12()
	{
		String s ="sayli";
	    Assert.assertNotNull(s, "It is null");
		System.out.println("It is not null");
	}
	
	@Test
	public void m13()
	{
		String exp = "sayli";
		String act = "sayli";
		Assert.assertSame(act, exp, "Values Not same");
		System.out.println("same");
	}
	
	@Test
	public void m14()
	{
		String exp = "sayli";
		String act = "sayli";
		Assert.assertNotSame(act, exp, "Value r same");
		System.out.println("not same");
	}
	
	@Test
	public void m15()
	{
		Assert.fail("I'm failing this method");
	}
}
