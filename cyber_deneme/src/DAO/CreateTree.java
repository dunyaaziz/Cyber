package DAO;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.TreeMap;

public class CreateTree {
	TreeMap<String, String> treeMap;
	
	public TreeMap GetTreeForFindTableName() throws SQLException{ 
		treeMap = new TreeMap(); 
		GetFieldName fieldnameclass=new GetFieldName();
		GetTableName tablenameclass=new GetTableName();
		ArrayList<String> tablearray=tablenameclass.GetTableNameFromDb();
		int i,j;
		ArrayList<String> fieldarray=null;
		for(i=0;i<tablearray.size();i++){
			String TableName = tablearray.get(i);	
			fieldarray=fieldnameclass.GetFieldNameMethod(tablearray.get(i));
			
			for(j=0;j<fieldarray.size();j++){
				String FieldName = fieldarray.get(j);
				treeMap.put(FieldName, TableName);
    		}
    	}
	return treeMap;
	}
}