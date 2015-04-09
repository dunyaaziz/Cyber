package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import create_report_view.Create_Report_View;
import createreportcontroller.CreateReportController;
import createreportmodel.CreateReportModel;

public class ReportList {

	
static ConnectionDB connection=new ConnectionDB();
	
	public static ArrayList<String> GetReportName() throws SQLException{
		

		ArrayList<String> list1= new ArrayList<String>();
		Connection con=connection.getConnection();
				Statement statement =con.createStatement();
				ResultSet rs = (statement).executeQuery("SELECT reportName FROM Report");
				

				while (rs.next()) {
					list1.add(rs.getString("reportName"));
			
					
				}
				return list1;
	}
}
