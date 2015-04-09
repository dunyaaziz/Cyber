package createreportcontroller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import create_report_view.Create_Report_View;
import createreportmodel.CreateReportModel;

public class CreateReportController {
	
	private CreateReportModel model;
	private Create_Report_View view;

	public CreateReportController(CreateReportModel model,Create_Report_View view){
		this.view=view;
		this.model=model;
		view.editSaveReport(new SaveReport());
		//view.editCancelReport(edit);
	}
	
	public class SaveReport implements ActionListener {
        public void actionPerformed(ActionEvent e) {
        	model.setReportName(view.getReportName());
        	model.setWhoUseThisReport(view.getReportOwner());
        	System.out.println(model.getReportName());
        	PrepareSQL();
        }
	}
	private String PrepareSQL(){
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
	     System.out.println(valueforDetail.get(a));
		}
		
		ArrayList<String> valueforCriter=new ArrayList<String>();
		String strCriter = getCriter;
		String[] resultCriter = strCriter.split(",");

		for(int a=0;a<resultCriter.length;a++){
			valueforCriter.add(resultCriter[a]);
	     System.out.println(valueforCriter.get(a));
		}
		return null;
		
	}
}
