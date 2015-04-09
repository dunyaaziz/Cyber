package model;

public class Fielddb {
	
	private int field_id;
	private String FieldName;
	private String FieldName_report;
	private String FieldType;
	private Tabledb tabledb_id;
	
	Fielddb()
	{
		
	}

	public int getField_id() {
		return field_id;
	}

	public void setField_id(int field_id) {
		this.field_id = field_id;
	}

	public String getFieldName() {
		return FieldName;
	}

	public void setFieldName(String fieldName) {
		FieldName = fieldName;
	}

	public String getFieldName_report() {
		return FieldName_report;
	}

	public void setFieldName_report(String fieldName_report) {
		FieldName_report = fieldName_report;
	}

	public String getFieldType() {
		return FieldType;
	}

	public void setFieldType(String fieldType) {
		FieldType = fieldType;
	}

	public Tabledb getTabledb_id() {
		return tabledb_id;
	}

	public void setTabledb_id(Tabledb tabledb_id) {
		this.tabledb_id = tabledb_id;
	}
}
