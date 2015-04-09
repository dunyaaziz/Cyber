package main;

import java.sql.SQLException;
import java.util.ArrayList;

import DAO.ReportList;
import create_report_view.Create_Report_View;
import create_report_view.report_runner_time;
import createreportcontroller.CreateReportController;
import createreportmodel.CreateReportModel;

public class Main {
	public static void main(String args[]) throws SQLException {
		CreateReportModel model= new CreateReportModel();
		Create_Report_View view=new Create_Report_View();
		report_runner_time view2=new report_runner_time();
		 CreateReportController report=new CreateReportController(model,view,view2);
		view.setVisible(true);	
//		ReportList reportlist=new ReportList();
//	reportlist.GetReportName();
//		
		}
		}

