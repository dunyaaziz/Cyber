package createreportmodel;

import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

import javax.swing.JOptionPane;

import DAO.ConnectionDB;

public class Save_Report {

public String Insert(CreateReportModel model){
	 try {
     	ConnectionDB mgr = ConnectionDB.getInstance();
     	Connection con = (Connection) mgr.getConnection();
         Statement st = con.createStatement();
        	 
            	String ReportName=model.getReportName();
            	String WhoUseThisReport=model.getWhoUseThisReport();
            	String PreparedSql=model.getPreparedSql();
            	Boolean HasDetail=model.getHasDetail();
            	Boolean HasCriteria=model.getHasCriteria();
            	int HasDetailInt = HasDetail?1:0;
              	int HasCriteriaInt = HasCriteria?1:0;
              	
                 String str = "insert into Report(reportName,hasDetail,hasCriteria,preparedSQL,Report_owner) values(?,?,?,?,?)";
                 PreparedStatement ps = con.prepareStatement(str);
              
               
                 ps.setString(1,ReportName);
                 ps.setInt(2,HasDetailInt);
                 ps.setInt(3,HasCriteriaInt);
                 ps.setString(4,PreparedSql);
                 ps.setString(5,WhoUseThisReport);
       
                 ps.executeUpdate();
                 
                 JOptionPane.showMessageDialog(null, "Database successfully updated", "Success", JOptionPane.INFORMATION_MESSAGE);
   
           
         }
                 catch (Exception x) {
                     JOptionPane.showMessageDialog(null, "kullanýcý daha önce kullanýlmýþ!!", "Error", JOptionPane.ERROR_MESSAGE);
                 }//inner try catch closed
             
	return null;
                 
               	
}
}


