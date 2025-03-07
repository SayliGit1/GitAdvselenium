package TestNG;

import org.testng.annotations.Test;

public class enabledAnnotation {
	@Test
	public void createProduct()
	{
		System.out.println("Product created successfully");
	}

	@Test(enabled = false)
	public void modifiedProduct()
	{
		System.out.println("Product modified successfully");
	}
	
	@Test
	public void deleteProduct()
	{
		System.out.println("Product deleted successfully");
	}

}
