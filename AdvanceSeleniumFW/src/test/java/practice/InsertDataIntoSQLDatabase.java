package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class InsertDataIntoSQLDatabase {

	public static void main(String[] args) throws Throwable {


	    //step1 -register driver
			Driver DriverRef = new Driver();
			DriverManager.registerDriver(DriverRef);
			
			//step2- get connection to database
			Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/empoyedata", "ROCKSTARSALES", "Sayli@123"); //giver username & password
			
			//step3- create SQL statement
			Statement state = connect.createStatement();
			String Query = "insert into employee(regno,firstname,lastname,address)values('3','harry','potter','london')";                                                                                                                                                                                                                                                                                                                                                                                             			
          int result = state.executeUpdate(Query);
          
          if(result==1)
          {
        	  System.out.println("user is created");
          }
          else
          {
        	System.out.println("user  is not created");  
          }	
			
			connect.close();		
			
	}

}
