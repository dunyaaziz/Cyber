package model;

import java.sql.Date;

public class Report {
	
	private int report_id;
	private String ReportName;
	private Date Report_Date;
	private boolean HasDetail;
	private boolean HasSummary;
	private boolean HasCriteria;
	private long preparedSql;
	
	
	public Report()
	{
		
	}
	
	public int getReport_id() {
		return report_id;
	}
	public void setReport_id(int report_id) {
		this.report_id = report_id;
	}
	public String getReportName() {
		return ReportName;
	}
	public void setReportName(String reportName) {
		ReportName = reportName;
	}
	public boolean isHasDetail() {
		return HasDetail;
	}
	public void setHasDetail(boolean hasDetail) {
		HasDetail = hasDetail;
	}
	public Date getReport_Date() {
		return Report_Date;
	}
	public void setReport_Date(Date report_Date) {
		Report_Date = report_Date;
	}
	public boolean isHasSummary() {
		return HasSummary;
	}
	public void setHasSummary(boolean hasSummary) {
		HasSummary = hasSummary;
	}
	public boolean isHasCriteria() {
		return HasCriteria;
	}
	public void setHasCriteria(boolean hasCriteria) {
		HasCriteria = hasCriteria;
	}
	public long getPreparedSql() {
		return preparedSql;
	}
	public void setPreparedSql(long preparedSql) {
		this.preparedSql = preparedSql;
	}
	

}
