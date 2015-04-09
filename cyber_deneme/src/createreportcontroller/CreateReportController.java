package createreportcontroller;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeMap;

import DAO.CreateTree;
import DAO.ReportList;
import create_report_view.Create_Report_View;
import create_report_view.report_runner_time;
import createreportmodel.CreateReportModel;
import createreportmodel.Save_Report;

public class CreateReportController {
	
	private CreateReportModel model;
	private Create_Report_View view;
	private report_runner_time reportRunner;
	public CreateReportController(CreateReportModel model,Create_Report_View view,report_runner_time reportRunner){
		this.view=view;
		this.model=model;
		this.reportRunner=reportRunner;
		view.editSaveReport(new SaveReport());
		//view.editCancelReport(edit);
	}
	
	public class SaveReport implements ActionListener {
        public void actionPerformed(ActionEvent e) {
        	model.setReportName(view.getReportName());
        	model.setWhoUseThisReport(view.getReportOwner());
        	try {
				model.setPreparedSql(PrepareSQL());
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
        	 Save_Report save=new Save_Report();
             save.Insert(model);
             
             ReportList reportliste=new ReportList();
             try {
				reportliste.GetReportName();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
        }
      
	}
	private String PrepareSQL() throws SQLException{
		String getCriter=view.getReportCriter();
		String getDetail=view.getReportDetail();
		
		if(getCriter!=null){
			model.setHasCriteria(true);
		}else{
			model.setHasCriteria(false);
		}
		
		if(getDetail!=null){
			model.setHasDetail(true);
		}else{
			model.setHasDetail(false);
		}
		ArrayList<String> valueforDetail=new ArrayList<String>();
		String str = getDetail;
		String[] result = str.split(",");

		for(int a=0;a<result.length;a++){
			valueforDetail.add(result[a]);
		}
		
		ArrayList<String> valueforCriter=new ArrayList<String>();
		String strCriter = getCriter;
		String[] resultCriter = strCriter.split(",");

		for(int a=0;a<resultCriter.length;a++){
			valueforCriter.add(resultCriter[a]);
		}
		
		CreateTree tree=new CreateTree();
		TreeMap<String,String> treeMap=new TreeMap<String, String>();
		treeMap=tree.GetTreeForFindTableName();
		Set<String> SetForTableName=new HashSet<String>();
		ArrayList<String> arrayfortable=new ArrayList<String>();
		for(int a=0;a<valueforDetail.size();a++){
			String treemap=treeMap.get(valueforDetail.get(a)+",");
			SetForTableName.add(treemap);
		}
		
		Iterator it = SetForTableName.iterator(); 
		while (it.hasNext()) {
			 String stri = (String) it.next();
			 arrayfortable.add(stri);
		}
		
		StringBuilder sb = new StringBuilder();
		sb.append(" select ");
		int a=0;
		for(int i=0;i<valueforDetail.size()-1;i++){
			sb.append(valueforDetail.get(i));
			sb.append(",");
			a++;
		}
		sb.append(valueforDetail.get(a++));
		sb.append(" from ");
		a=0;
		for(int i=0;i<arrayfortable.size()-1;i++){
			sb.append(arrayfortable.get(i));
			sb.append(",");
			a++;
		}
		sb.append(arrayfortable.get(a++));
		a=0;
		if(!getCriter.isEmpty()){
			sb.append(" where ");
			System.out.println(getCriter);
			for(int i=0;i<valueforCriter.size()-1;i++){			
				sb.append(valueforCriter.get(i)+" = ");
				sb.append("?");
				sb.append(" and ");
				a++;
			}
			sb.append(valueforCriter.get(a++)+"=");
			sb.append("?");
		}
		String sql =sb.toString();		
		return sql;
	}
}
