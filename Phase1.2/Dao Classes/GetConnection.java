package model;

import java.sql.Connection;
import java.sql.DriverManager;

public class GetConnection {
	
	
	public GetConnection(){
		System.out.println("Establishing Connection to MySQL DataBase");
	}
	
	public Connection getConnection(){
		try{
		 Class.forName("com.mysql.jdbc.Driver");
		 System.out.println("MySQL JDBC Driver Registered");
		  connection = DriverManager.getConnection("jdbc:mysql://www.papademas.net:3306/510labs?", "db510","510");
		  return connection;
		}
		catch(Exception e){
			System.err.println("Failed to establish Connection to DataBase "+e);
		}
		return null;
	}
	
	private static Connection connection=null;
}
