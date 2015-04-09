package main;

import java.util.ArrayList;

import create_report_view.Create_Report_View;
import createreportcontroller.CreateReportController;
import createreportmodel.CreateReportModel;

public class Main {
	public static void main(String args[]) {
		CreateReportModel model= new CreateReportModel();
		Create_Report_View view=new Create_Report_View();
		 CreateReportController report=new CreateReportController(model,view);
		view.setVisible(true);	
		
		String s = new String("Afyon,Bayat,Ýstanbul");
		String[] result = s.split(",");
		ArrayList<String> ab=new ArrayList<String>();
		for(int a=0;a<result.length;a++){
	     ab.add(result[a]);
	     System.out.println(result[a]);
		}
		}
}
