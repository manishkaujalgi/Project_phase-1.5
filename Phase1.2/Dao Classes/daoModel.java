/**Controller.java 10/01/2017 4:32 pm
 *Program to Database CRUD operations.
 *Programmer: Vaishnavi Bhadresh , FileName: daoModel.java , Lab Number: Lab 4
 * @author vaish
 */
// packageName
package model;

// import statements
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;


public class daoModel {
	// daoModel Constructor to create Connection with Database
	public daoModel() {
		connector = new Connector();
		connectDB();
	}

	private void connectDB() {
		try {
			connection = connector.getConnection();
			System.out.println("MySQL JDBC Driver established successfully");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Connection getConnection() {
		return connection;
	}

	public void updateOTP(String otp,String id) {
		String query = "Insert into  login_db (otp,id) values("+otp+","+ id+")";
		try {
			statement = connection.createStatement();
			statement.executeUpdate(query);
		} catch (Exception e) {

		}
	}

	public void close() {
		try {
			connection.close();
			connection = null;
		} catch (Exception e) {
			System.err.println("Failed to close DB Connection");
		}
	}

	// declaring class variables
	private static Connector connector = null;
	private static Connection connection = null;
	private static Statement statement = null;

}
