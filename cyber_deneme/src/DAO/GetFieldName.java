package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class GetFieldName {
	static ConnectionDB connection=new ConnectionDB();
	
	public ArrayList<String> GetFieldNameMethod(String tableName) throws SQLException{
		Connection con=connection.getConnection();
		Statement statement =con.createStatement();
		StringBuilder sb = new StringBuilder();
		sb.append("select Column_name from all_tab_cols WHERE table_name = '");
		sb.append(tableName);
		sb.append("'");
		String sql =sb.toString();
		int i=0;
		ResultSet rs = (statement).executeQuery(sql);
		ArrayList<String> list1= new ArrayList<String>();
		while (rs.next()){
        	list1.add(rs.getString("Column_name")+",");
        }
		for(i=0;i<list1.size();i++){
        	System.out.println(list1.get(i));
        }
        rs.close();	
		return list1;
	}

}
