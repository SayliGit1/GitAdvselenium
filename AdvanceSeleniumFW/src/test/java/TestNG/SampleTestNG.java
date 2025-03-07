package TestNG;

import org.testng.annotations.Test;

public class SampleTestNG {
	
	@Test(priority = -10)
	public void createProduct()
	{
		System.out.println("Product created successfully");
	}

	@Test(priority = 1)
	public void modifiedProduct()
	{
		System.out.println("Product modified successfully");
	}
	
	@Test(priority = 12)
	public void deleteProduct()
	{
		System.out.println("Product deleted successfully");
	}
}
