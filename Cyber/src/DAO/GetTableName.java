package DAO;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class GetTableName {
		static ConnectionDB connection=new ConnectionDB();  
	
		public ArrayList<String> GetTableNameFromDb() throws SQLException{
		Connection con=connection.getConnection();
		String selectTableSQL = "SELECT table_name FROM user_tables";
		Statement statement =con.createStatement();
		ResultSet rs = (statement).executeQuery(selectTableSQL);
		 ArrayList<String> list= new ArrayList<String>();
		 ArrayList<String> list1= new ArrayList<String>();
		 ArrayList<String> list2= new ArrayList<String>();
		 list.add("DEPT");
		 list.add("EMP");
		 list.add("DEMO_USERS");
		 list.add("DEMO_CUSTOMERS");
		 list.add("APEX$_ACL");
		 list.add("APEX$_WS_WEBPG_SECTIONS");
		 list.add("APEX$_WS_WEBPG_SECTION_HISTORY");
		 list.add("DEMO_STATES");
		 list.add("DEMO_ORDERS");
		 list.add("DEMO_PRODUCT_INFO");
		 list.add("DEMO_ORDER_ITEMS");
		 list.add("APEX$_WS_ROWS");
		 list.add("APEX$_WS_HISTORY");
		 list.add("APEX$_WS_NOTES");
		 list.add("APEX$_WS_LINKS");
		 list.add("APEX$_WS_TAGS");
		 list.add("APEX$_WS_FILES");
	     list.add("USERDB");
	        list.add("USERHASTABLE");
	        list.add("USERHASREPORT");
	        list.add("REPORTHASFIELD");
	        list.add("REPORT");
	        list.add("RELATIONDB");
	        list.add("FIELDDB");
	        list.add("TABLEDB");
	        int i=0;
	        int a=0;
	        int b;
	        while (rs.next()){
	        	list1.add(rs.getString("table_name"));
	        }
	        
	        for (i=0;i<list1.size();i++)
	        {
	        	for(b=0;b<list.size();b++){
	        		if(list.get(b).equals(list1.get(i))){
	        		a=1;
	        		}
	        		
	        	}
	        	if(a==0){
	        		list2.add(list1.get(i));
	        	}
	        	a=0;
	      }
	        for(i=0;i<list2.size();i++){
	        	System.out.println(list2.get(i));
	        }
	        return list2;
	}
}