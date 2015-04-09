package view;
import java.util.ArrayList;
import java.util.logging.Handler;

import javax.swing.JComponent;
import javax.swing.JTextArea;
import javax.swing.JTree;
import javax.swing.TransferHandler;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

import DAO.GetFieldName;
import DAO.GetTableName;

import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.JTextField;

import java.awt.event.ActionListener;

import javax.swing.JLabel;

public class Create_Report_View extends javax.swing.JFrame {
	
	static ArrayList<String> dropText= new ArrayList<String>();
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JScrollPane jScrollPane3;
	private JTextField ReportName;
	private JTextArea TextArea_For_Criter;
	private JTextField Report_Owner;
	JButton Save_Btn;
	JButton Cancel_Btn;
	private static JTextArea TextArea_For_Detail;
	private static final long serialVersionUID = 1L;

	public Create_Report_View() {
		initComponents();
	}

private void initComponents() {

    jScrollPane1 = new javax.swing.JScrollPane();
    jScrollPane3 = new javax.swing.JScrollPane();

    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
    try{
    GetFieldName fieldnameclass=new GetFieldName();
	GetTableName tablenameclass=new GetTableName();
	ArrayList<String> tablearray=tablenameclass.GetTableNameFromDb();
	DefaultMutableTreeNode Genel = new DefaultMutableTreeNode("Table Name");
	int i,j;
	ArrayList<String> fieldarray=null;

	for(i=0;i<tablearray.size();i++){
		DefaultMutableTreeNode TableName = new DefaultMutableTreeNode(tablearray.get(i));	
		Genel.add(TableName);
		fieldarray=fieldnameclass.GetFieldNamedb(tablearray.get(i));
		for(j=0;j<fieldarray.size();j++){
			DefaultMutableTreeNode field = new DefaultMutableTreeNode(fieldarray.get(j));
			TableName.add(field);
    		}
    	}
	DefaultTreeModel model = new DefaultTreeModel(Genel);
	
	JTree tree = new JTree(model);
    tree.setDragEnabled(true);
    tree.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
        public void mouseMoved(java.awt.event.MouseEvent evt) {
            jTree1MouseMoved(evt);
        }
    });
    jScrollPane1.setViewportView(tree);

}catch (Exception e){
	e.printStackTrace();
}
    TextArea_For_Criter = new javax.swing.JTextArea();
    
        TextArea_For_Criter.setColumns(20);
        TextArea_For_Criter.setRows(5);
     
    Save_Btn = new JButton("Save");
    
    ReportName = new JTextField();
    ReportName.setColumns(10);
    
    Cancel_Btn = new JButton("Cancel");
    
    JLabel lblReportName = new JLabel("Report Name");
    
    Report_Owner = new JTextField();
    
    JLabel lblReportOwner = new JLabel("Report Owner");
    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    layout.setHorizontalGroup(
    	layout.createParallelGroup(Alignment.LEADING)
    		.addGroup(layout.createSequentialGroup()
    			.addGap(29)
    			.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
    			.addGap(8)
    			.addGroup(layout.createParallelGroup(Alignment.LEADING)
    				.addComponent(TextArea_For_Criter, GroupLayout.DEFAULT_SIZE, 417, Short.MAX_VALUE)
    				.addComponent(jScrollPane3, GroupLayout.PREFERRED_SIZE, 400, GroupLayout.PREFERRED_SIZE)
    				.addGroup(layout.createSequentialGroup()
    					.addGap(21)
    					.addGroup(layout.createParallelGroup(Alignment.LEADING)
    						.addComponent(lblReportName, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE)
    						.addComponent(lblReportOwner))
    					.addGap(37)
    					.addGroup(layout.createParallelGroup(Alignment.TRAILING, false)
    						.addComponent(Report_Owner)
    						.addComponent(ReportName, GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE))
    					.addPreferredGap(ComponentPlacement.RELATED, 81, Short.MAX_VALUE)
    					.addGroup(layout.createParallelGroup(Alignment.LEADING)
    						.addComponent(Save_Btn, Alignment.TRAILING)
    						.addComponent(Cancel_Btn, Alignment.TRAILING))))
    			.addGap(99))
    );
    layout.setVerticalGroup(
    	layout.createParallelGroup(Alignment.TRAILING)
    		.addGroup(layout.createSequentialGroup()
    			.addGap(12)
    			.addGroup(layout.createParallelGroup(Alignment.LEADING)
    				.addGroup(layout.createParallelGroup(Alignment.BASELINE)
    					.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
    					.addComponent(lblReportName))
    				.addGroup(layout.createSequentialGroup()
    					.addGroup(layout.createParallelGroup(Alignment.BASELINE)
    						.addComponent(Save_Btn)
    						.addComponent(ReportName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
    					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    					.addGroup(layout.createParallelGroup(Alignment.BASELINE)
    						.addComponent(Cancel_Btn)
    						.addComponent(Report_Owner, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
    						.addComponent(lblReportOwner))
    					.addPreferredGap(ComponentPlacement.RELATED)
    					.addComponent(TextArea_For_Criter, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)
    					.addPreferredGap(ComponentPlacement.RELATED)
    					.addComponent(jScrollPane3, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE))))
    );
    
    TextArea_For_Detail = new JTextArea();
    jScrollPane3.setViewportView(TextArea_For_Detail);
    getContentPane().setLayout(layout);

    pack();
}

private void jTree1MouseMoved(java.awt.event.MouseEvent evt) {
    JComponent comp = (JComponent)evt.getSource();
    TransferHandler handler = comp.getTransferHandler();
    comp.setTransferHandler(handler);
    handler.exportAsDrag(comp, evt, TransferHandler.COPY);
    
}

public void txtdrop()
{
	String textDrop=Create_Report_View.getReportDetail();
	System.out.println(Create_Report_View.getDropText().add(textDrop));
	//textDrop.setText(" ");
//	for(int i=0;i<Create_Report_View.getDropText().size();i++){
//	if(Create_Report_View.getDropText().size()==1){
//			textDrop.append((String)Create_Report_View.getDropText().get(i)+"   ");
//	} else
//		 textDrop.append((String)Create_Report_View.getDropText().get(i)+",  ");
//	}
	//JTextArea area1=new JTextArea();
	//area1.setText(getNewnode());
	}




public void editSaveReport(ActionListener edit){
	Save_Btn.addActionListener(edit);
}

public void editCancelReport(ActionListener edit){
	Cancel_Btn.addActionListener(edit);
}

public String getReportCriter(){
	String reportcriter = TextArea_For_Criter.getText();
	return reportcriter;
}
public static String getReportDetail(){
	String reportdetail = TextArea_For_Detail.getText();
	return reportdetail;
}
public String getReportName(){
	String reportcriter = ReportName.getText();
	return reportcriter;
}
public String getReportOwner(){
	String reportowner = Report_Owner.getText();
	return reportowner;
}
/**
 * @param args the command line arguments
 */
public static void main(String args[]) {

	
	Create_Report_View frame=new Create_Report_View();
	frame.setVisible(true);
System.out.println(frame.getReportDetail());
	
}

public static ArrayList<String> getDropText() {
	return dropText;
}

public static void setDropText(ArrayList<String> dropText) {
	Create_Report_View.dropText = dropText;
}

}

