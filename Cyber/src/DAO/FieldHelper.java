package DAO;

import java.sql.Array;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;



//import view.DatabaseMetaData;
import view.addTable;
import model.*;


public class FieldHelper {
private static final Throwable Exceptions = null;
private String name;
private static ArrayList<String> FieldData = new ArrayList<String>();
public FieldHelper(String name){
	this.name=name;
}




public static  ArrayList<Fielddb> GetField(String tablename){
	
	//public static List<DepartmanDomain> comboboxItem() {

	ArrayList<Fielddb> liste = new ArrayList<Fielddb>();
	ConnectionDB mgr = ConnectionDB.getInstance();
	Connection con = (Connection) mgr.getConnection(); 
		   try {
		         Statement stmt = con.createStatement();
		         StringBuilder sb = new StringBuilder();
		 		sb.append("select Column_name from all_tab_cols WHERE table_name = '");
		 		sb.append(tablename);
		 		sb.append("'");
		 		String sql =sb.toString();
		 		ResultSet rs = (stmt).executeQuery(sql);
		 		
	 
	             
			 	while (rs.next()){
		        
			 		System.out.println(rs.getString(tablename));
		        }
			
	
			
		            } catch (SQLException e) {
		    			// TODO Auto-generated catch block
		    			e.printStackTrace();
		    		}
		return liste;

		
		   }
}

