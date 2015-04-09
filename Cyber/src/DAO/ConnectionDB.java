package DAO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB {
  
	private String className = "oracle.jdbc.driver.OracleDriver";
	private String userName = "tezz";
	private String password = "123";
	private String url = "jdbc:oracle:thin:@localhost:1521:XE";
	private static ConnectionDB connectionInstance = null;
  
  
  public static synchronized ConnectionDB getInstance() {
	if(connectionInstance == null) {
	  connectionInstance = new ConnectionDB(); 		
	}
	return connectionInstance;
  }
  
  public Connection getConnection(){
	  
	  Connection conn = null;
	  try {
		  Class.forName(className);
		  conn = DriverManager.getConnection (url, userName, password);
		  //System.out.println("Connection Established");
	  }  catch (ClassNotFoundException e) {
		  e.printStackTrace();
	  }	 catch (SQLException e) {
		  e.printStackTrace();
	  }
	  return conn;
  }

  public void closeConnection(Connection conn){
	  try {
		  conn.close();
	  } catch (SQLException e) {
		  e.printStackTrace();
	  }
  } 
}
