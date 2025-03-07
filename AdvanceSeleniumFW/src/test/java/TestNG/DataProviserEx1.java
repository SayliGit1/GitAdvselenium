package TestNG;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviserEx1 {
	
	//executing the same method multiple time with diff set of test data
	@Test(dataProvider = "getData")
	public void bookTickets(String src,String dest, int NoOfPeople )
	{
		System.out.println("Book tickets from "+src+ " to "+dest+ " with "+NoOfPeople+"");
	}
	
	@DataProvider
	public Object[][] getData(){
	Object[][] objArr = new Object[3][3];
	
	
	objArr[0][0] = "Goa";
	objArr[0][1] = "Banglore";
	objArr[0][2] = 4;
	
	objArr[1][0] = "manali";
	objArr[1][1] = "mumbai";
	objArr[1][2] = 3;
	
	objArr[2][0] = "Mumbai";
	objArr[2][1] = "Kashmir";
	objArr[2][2] = 2;
	
	return objArr;
	
	}	

}
