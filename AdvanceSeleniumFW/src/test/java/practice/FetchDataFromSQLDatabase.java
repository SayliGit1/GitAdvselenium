package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class FetchDataFromSQLDatabase {

	public static void main(String[] args) throws Throwable {

    //step1 -register driver
		Driver DriverRef = new Driver();
		DriverManager.registerDriver(DriverRef);
		
		//step2- get connection to database
		Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql", "", ""); //giver username & password
		
		//step3- create SQL statement
		Statement state = connect.createStatement();
		String Query = "select * from employee";
		
		//step4- execute statement/query
		ResultSet result = state.executeQuery(Query);
		
		while (result.next())
		{
		System.out.println(result.getInt(1) +"/t" + result.getString(2) + "/t" + result.getString(3) + "/t" + result.getString(4));	
			
		}
		//step5-  close database connection
		connect.close();
	}

}
