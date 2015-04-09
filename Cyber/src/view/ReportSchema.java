package view;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Panel;
import java.awt.Point;
import java.awt.TextArea;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;
import javax.swing.tree.TreeSelectionModel;
import javax.swing.DropMode;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.JTree;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ListSelectionModel;
import javax.swing.TransferHandler;

import DAO.GetFieldName;
import DAO.GetTableName;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JSeparator;

import java.awt.Component;
import java.io.ObjectOutputStream.PutField;

import javax.swing.Box;
import javax.swing.event.TreeSelectionListener;
import javax.swing.event.TreeSelectionEvent;

import java.awt.event.MouseMotionAdapter;

public class ReportSchema extends JFrame {

	private static final int BOOK_TABLE_ROW_HEIGHT = 0;
	private JPanel contentPane;
	private final JSplitPane splitPane = new JSplitPane();
	private JTable table;
	private JTextField textField;
	private JTable table_1;
	private JTable dragFrom;
	private JTextField textField_1;
	private JTree tree_1;
	public JTextField getTextField_1() {
		return textField_1;
	}


	public void setTextField_1(JTextField textField_1) {
		this.textField_1 = textField_1;
	}


	public JTextField getTextField_2() {
		return textField_2;
	}


	public void setTextField_2(JTextField textField_2) {
		this.textField_2 = textField_2;
	}


	private JTextField textField_2;

	public ReportSchema() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 470, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
//		splitPane.setBounds(20, 36, 411, 414);
//		contentPane.add(splitPane);
		try{
			GetFieldName fieldnameclass=new GetFieldName();
			GetTableName tablenameclass=new GetTableName();

				ArrayList<String> tablearray=tablenameclass.GetTableNameFromDb();
				DefaultMutableTreeNode Genel = new DefaultMutableTreeNode("Table Name");
				int i,j;
				int count=0;
				ArrayList<String> fieldarray=null;

				for(i=0;i<tablearray.size();i++){
					count++;
			
					DefaultMutableTreeNode TableName = new DefaultMutableTreeNode(tablearray.get(i));	
					Genel.add(TableName);
					fieldarray=fieldnameclass.GetFieldNamedb(tablearray.get(i));
				//	if(count==tablearray.size()){
					for(j=0;j<fieldarray.size();j++){
						DefaultMutableTreeNode field = new DefaultMutableTreeNode(fieldarray.get(j));
						TableName.add(field);
		        		}
		        	}
				DefaultTreeModel model = new DefaultTreeModel(Genel);
				

				JTree tree_1 = new JTree(model);
				

				tree_1.setBounds(10, 36, 142, 414);
				contentPane.add(tree_1);
					
		JLabel lblReportName = new JLabel("Report Name: ");
		lblReportName.setBounds(10, 11, 86, 14);
		contentPane.add(lblReportName);
		
		textField = new JTextField();
		textField.setBounds(106, 7, 86, 23);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnsave = new JButton("Save");
		
		btnsave.setBounds(195, 7, 89, 23);
		contentPane.add(btnsave);
		
		JButton btncancel = new JButton("Cancel");
		btncancel.setBounds(294, 7, 89, 23);
		contentPane.add(btncancel);
		
		textField_1 = new JTextField();
		textField_1.setBounds(241, 41, 203, 139);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(241, 191, 203, 259);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		

		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public JTree getTree_1() {
		return tree_1;
	}


	public void setTree_1(JTree tree_1) {
		this.tree_1 = tree_1;
	}


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
			
				ReportSchema frame = new ReportSchema();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
