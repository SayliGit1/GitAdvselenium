package TestNG;

import org.testng.annotations.Test;

public class DependsOnMethod {
	@Test
	public void createProduct()
	{
		System.out.println("Product created successfully");
	}

	@Test(dependsOnMethods = "createProduct")
	public void modifiedProduct()
	{
		System.out.println("Product modified successfully");
	}
	
	@Test(dependsOnMethods = "createProduct")
	public void deleteProduct()
	{
		System.out.println("Product deleted successfully");
	}
}



