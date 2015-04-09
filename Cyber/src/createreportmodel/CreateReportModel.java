package createreportmodel;

public class CreateReportModel {

	public String ReportName;
	public String WhoUseThisReport;
	public String PreparedSql;
	public Boolean HasDetail;
	public String HasSummary;
	public Boolean HasCriteria;
	// date 
	
	public CreateReportModel(){
		this.ReportName = null;
		this.WhoUseThisReport = null;
		this.PreparedSql = null;
		this.HasDetail = null;
		this.HasSummary = null;
		this.HasCriteria = null;	
	}
	
	public CreateReportModel(String reportName, String whoUseThisReport,
			String preparedSql) {
		this.ReportName = reportName;
		this.WhoUseThisReport = whoUseThisReport;
		this.PreparedSql = preparedSql;
		this.HasDetail = null;
		this.HasSummary = null;
		this.HasCriteria = null;
	}

	public CreateReportModel(String reportName, String whoUseThisReport,
			String preparedSql, Boolean hasDetail, String hasSummary) {
		this.ReportName = reportName;
		this.WhoUseThisReport = whoUseThisReport;
		this.PreparedSql = preparedSql;
		this.HasDetail = hasDetail;
		this.HasSummary = hasSummary;
		this.HasCriteria = null;
	}
	
	public CreateReportModel(String reportName, String whoUseThisReport,
			String preparedSql, Boolean hasDetail) {
		this.ReportName = reportName;
		this.WhoUseThisReport = whoUseThisReport;
		this.PreparedSql = preparedSql;
		this.HasDetail = hasDetail;
		this.HasSummary = null;
		this.HasCriteria = null;
	}
	
	public CreateReportModel(String reportName, String whoUseThisReport,
			String preparedSql, Boolean hasDetail, String hasSummary,
			Boolean hasCriteria) {
		this.ReportName = reportName;
		this.WhoUseThisReport = whoUseThisReport;
		this.PreparedSql = preparedSql;
		this.HasDetail = hasDetail;
		this.HasSummary = hasSummary;
		this.HasCriteria = hasCriteria;
	}

	public String getReportName() {
		return ReportName;
	}

	public void setReportName(String reportName) {
		ReportName = reportName;
	}

	public String getWhoUseThisReport() {
		return WhoUseThisReport;
	}

	public void setWhoUseThisReport(String whoUseThisReport) {
		WhoUseThisReport = whoUseThisReport;
	}

	public String getPreparedSql() {
		return PreparedSql;
	}

	public void setPreparedSql(String preparedSql) {
		PreparedSql = preparedSql;
	}

	public Boolean getHasDetail() {
		return HasDetail;
	}

	public void setHasDetail(Boolean hasDetail) {
		HasDetail = hasDetail;
	}

	public String getHasSummary() {
		return HasSummary;
	}

	public void setHasSummary(String hasSummary) {
		HasSummary = hasSummary;
	}

	public Boolean getHasCriteria() {
		return HasCriteria;
	}

	public void setHasCriteria(Boolean hasCriteria) {
		HasCriteria = hasCriteria;
	}

}
