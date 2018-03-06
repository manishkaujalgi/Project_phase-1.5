package model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class mechanicServicesdao {
	
	public void addmechanicServices(){}
	public void updatemechanicServices(){}
	public void deletemechanicServices(){}
	
	public mechanicServicesdao(Connection connect){
		this.connection=connect;
		if(connection!=null){
			System.out.println("Established Connection successfully");
		}
		else{
			System.err.println("Failed to establish Connection");
		}
		
	}
	public void approveMechanicServices(){
		try {
			statement= connection.createStatement();
			String sql="LOAD XML LOCAL INFILE 'C:/Users/vaish/itmdev/src/main/webapp"
					+ "/XML/MechanicServices_admin.xml' "
					+ "INTO TABLE mechanicServices_admin ROWS IDENTIFIED BY '<mechanicServices>';";
			statement.execute(sql);
			System.out.println("XML data is pushed into the database");
			
		} catch (SQLException e) {
			System.err.println("Failed in Updating Data to OTP Table");
		}
	}
	public static ResultSet getResultSet() throws Exception
	{	
		ResultSet rs = null;
		try
		{
			statement = connection.createStatement();
			String sql = "select * from login";
			rs = statement.executeQuery(sql);
		}
		catch(SQLException e)
		{
			System.out.println(e.getMessage());
		}
		return rs;
	}

		
		public void close(){
			
			try {
				statement.close();
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		private static Statement statement = null;
		private static Connection connection=null;
}
