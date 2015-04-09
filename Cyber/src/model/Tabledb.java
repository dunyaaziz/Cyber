package model;


public class Tabledb {
	private int table_id;
	private String TableName;
	private String TableName_report;
	
	
	public Tabledb(){
		
	}
	public String getTableName_report() {
		return TableName_report;
	}


	public void setTableName_report(String tableName_report) {
		TableName_report = tableName_report;
	}


	public String getTableName() {
		return TableName;
	}


	public void setTableName(String tableName) {
		TableName = tableName;
	}


	public int getTable_id() {
		return table_id;
	}


	public void setTable_id(int table_id) {
		this.table_id = table_id;
	}

	
}
