package DAO;

import java.sql.Array;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import view.addTable;
import model.*;


public class TableHelper {
private String name;
private static ArrayList<String> tableDatas = new ArrayList<String>();
public TableHelper(String name){
	this.name=name;
}




public static  ArrayList<String> GetTables(){
	
	//public static List<DepartmanDomain> comboboxItem() {

	ArrayList<Tabledb> liste = new ArrayList<Tabledb>();
	ConnectionDB mgr = ConnectionDB.getInstance();
	Connection con = (Connection) mgr.getConnection(); 
		   try {
		             Statement stmt = con.createStatement();
		          
		            ResultSet rs = stmt.executeQuery("SELECT table_name FROM user_tables");
		            //ResultSet rs = stmt.executeQuery("SELECT TABLE_NAME FROM ALL_TABLES");
		             ResultSetMetaData rsMetaData = rs.getMetaData();
		             
		             int columnsNumber = rsMetaData.getColumnCount();
		             while (rs.next()) {
		            	    
		            	        String columnValue = rs.getString(1);
		            	        tableDatas.add(columnValue);
		            	        System.out.print(columnValue + " " + rsMetaData.getColumnName(1));
		            	    
		            	    System.out.println("");
		            	}
		   while (rs.next()) {
			   Tabledb siradakiDepartmanDomain = new Tabledb();
//		         siradakiDepartmanDomain.setTable_id(rs.getInt("id"));
		         siradakiDepartmanDomain.setTableName(rs.getString("TABLE_NAME"));
		         liste.add(siradakiDepartmanDomain);
		         
		         
		  }

		     stmt.close();
		     con.close();
		  } catch (SQLException e) {
		     e.printStackTrace();
		  }

		  return tableDatas;
		            }
}
/*
public static ArrayList<Tabledb> getTables(String tableOwner){
	
	
	ConnectionDB mgr = ConnectionDB.getInstance();
	Connection con = (Connection) mgr.getConnection(); 
    ArrayList<Tabledb> list = null;

    if (con!=null){

    	
        try{
            Tabledb pr = null;
            String a;
            list = new ArrayList<Tabledb>();
            Statement st = con.createStatement();
            ResultSet rs=st.executeQuery("select tablename from tabledb");
            while (rs.next())
            {
                a=rs.getString("");
                pr  = new Tabledb();
               // pr.setTableName(a);
                list.add(pr);
                System.out.println(list);
            }
    }
        catch(SQLException e ) {

            // System.out.print(e.getMessage());
            System.out.println("Error = " + e.getMessage());
           }

    }  else
    {

    }
    return list;
   
}

}
*/