package model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class carDetailsDao {

	public carDetailsDao(Connection connect) {
		this.connection = connect;
		if (connection != null) {
			System.out.println("Established Connection successfully");
		} else {
			System.err.println("Failed to establish Connection");
		}

	}

	public void approveCarDetails_insert() {
		try {
			statement = connection.createStatement();
			String sql = "LOAD XML LOCAL INFILE 'C:/Users/vaish/itmdev/src/main/webapp" + "/XML/ApproveCarDetails.xml' "
					+ "INTO TABLE carDetails_admin ROWS IDENTIFIED BY '<carDetails>';";
			statement.execute(sql);
			System.out.println("XML data is pushed into the database");

		} catch (SQLException e) {
			System.err.println("Failed in Updating Data to OTP Table");
		}
	}

	public static ResultSet getResultSet() throws Exception {
		ResultSet rs = null;
		try {
			statement = connection.createStatement();
			String sql = "select * from login";
			rs = statement.executeQuery(sql);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return rs;
	}

	public void addCar(){
		try {
			statement = connection.createStatement();
			String sql = "LOAD XML LOCAL INFILE 'C:/Users/vaish/itmdev/src/main/webapp" 
			+ "/XML/addCar.xml' "
					+ "INTO TABLE addCar ROWS IDENTIFIED BY '<AddCar>';";
			statement.execute(sql);
			System.out.println("XML data is pushed into the database");

		} catch (SQLException e) {
			System.err.println("Failed in Updating Data to OTP Table");
		}
	}
	public void close() {

		try {
			statement.close();
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static Statement statement = null;
	private static Connection connection = null;
}
