package TestNG;

import org.testng.annotations.Test;

public class DependsOnAndPriority {
	//only depnedsOnmethods will get execute ,if priority and depends methods given together
	@Test
	public void createProduct()
	{
		System.out.println("Product created successfully");
	}

	@Test(dependsOnMethods = "createProduct" ,priority = 1)
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
