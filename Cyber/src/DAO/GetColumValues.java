package DAO;

	import java.sql.Connection;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.sql.Statement;
	import java.util.ArrayList;

	public class GetColumValues {
		static ConnectionDB connection=new ConnectionDB();
		
		public static ArrayList<String> GetColumValuesMethod(String columnName) throws SQLException{
			Connection con=connection.getConnection();
			Statement statement =con.createStatement();
			String tableName=findcolumnhastable(columnName);
			StringBuilder sb = new StringBuilder();
			sb.append("select * from ");
			sb.append(tableName);
			
			String sql =sb.toString();
			int i=0;
			ResultSet rs = (statement).executeQuery(sql);
			ArrayList<String> list1= new ArrayList<String>();
			while (rs.next()){
	        	list1.add(rs.getString(columnName));
	        }
			for(i=0;i<list1.size();i++){
	        	System.out.println(list1.get(i));
	        }
	        rs.close();	
			return list1;
		}
		
		public static String findcolumnhastable(String columntable) throws SQLException  {
			GetTableName tableconnection=new GetTableName();
		    GetFieldName fieldname=new GetFieldName();
			ArrayList<String> fieldlist=null;
			String table=null;
			ArrayList<String> tablelist=  tableconnection.GetTableNameFromDb();
			int i,a=0;
			for(i=0;i<tablelist.size();i++){
			   	 fieldlist=fieldname.GetFieldNameMethod(tablelist.get(i));
		    	 for(a=0;a<fieldlist.size();a++){
		    		 if(columntable.equals(fieldlist.get(a).toString()))
		    		 {
			    		 table=tablelist.get(i);
			   		 }
			   	 }
			}
		   return table;
		}
		
		public static void main(String[] args) throws SQLException{
			
				System.out.println(findcolumnhastable("EMPLOYEENAME"));
				ArrayList<String>a=GetColumValuesMethod("EMPLOYEENAME");
				for(int i=0;i<a.size();i++){
					System.out.println(a.get(i));
				}
			
		}
}

