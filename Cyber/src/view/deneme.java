//package view;
//import java.sql.SQLException;
//import java.util.ArrayList;
//
//import javax.swing.*;
//import javax.swing.tree.*;
//
//import DAO.GetFieldName;
//import DAO.GetTableName;
//import java.awt.BorderLayout;
//
//public class deneme extends JFrame{
//	/**
//	 * 
//	 */
//	private static final long serialVersionUID = 1L;
//	private JTextField txtReport;
//	private JTable table;
//
//	public deneme(){	
//		GetFieldName fieldnameclass=new GetFieldName();
//		GetTableName tablenameclass=new GetTableName();
//	try {
//		
//		ArrayList<String> tablearray=tablenameclass.GetTableNameFromDb();
//		DefaultMutableTreeNode Genel = new DefaultMutableTreeNode("TableName");
//		int i,j;
//		ArrayList<String> fieldarray=null;
//
//		for(i=0;i<tablearray.size();i++){
//			DefaultMutableTreeNode TableName = new DefaultMutableTreeNode(tablearray.get(i));	
//			Genel.add(TableName);
//			fieldarray=fieldnameclass.GetFieldName(tablearray.get(i));
//			for(j=0;j<fieldarray.size();j++){
//				DefaultMutableTreeNode field = new DefaultMutableTreeNode(fieldarray.get(j));
//				TableName.add(field);
//			}
//		}
//		DefaultTreeModel model = new DefaultTreeModel(Genel);
//		JLabel lblReportName = new JLabel("Report Name:");
//		lblReportName.setBounds(120, 11, 88, 14);
//		getContentPane().add(lblReportName);
//		
//		txtReport = new JTextField();
//		txtReport.setBounds(200, 8, 118, 20);
//		getContentPane().add(txtReport);
//		txtReport.setColumns(10);
//		
//		JButton btnSave = new JButton("Save");
//		btnSave.setBounds(300, 7, 89, 23);
//		getContentPane().add(btnSave);
//		
//		JButton btnCancel = new JButton("Cancel");
//		btnCancel.setBounds(33, 7, 8, 3);
//		getContentPane().add(btnCancel);
//		
//		JPanel panelRpt = new JPanel();
//		panelRpt.setBounds(10, 3, 30, 51);
//		getContentPane().add(panelRpt, BorderLayout.WEST);
//		JTree tree = new JTree(model);
//		panelRpt.add(tree);
//		tree.setBounds(0, 0, 434, 261);
//		
//		table = new JTable();
//		panelRpt.add(table);
//
//	} catch (SQLException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}
//}
//
//public static void main(String[] args)
//{
//	deneme test = new deneme();
//	test.setBounds(100,100,600,600);	
//	test.setVisible(true);
//}
//
//}