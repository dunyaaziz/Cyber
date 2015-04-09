//package view;
//
//import java.awt.Container;
//import java.awt.Dimension;
//import java.awt.Toolkit;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.ResultSet;
//import java.sql.Statement;
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.io.IOException;
//
//
//
//
//
//
//
//import model.*;
//
//import javax.swing.JFrame;
//import javax.swing.JPanel;
//import javax.swing.border.EmptyBorder;
//import javax.swing.DefaultComboBoxModel;
//import javax.swing.JLabel;
//import javax.swing.JComboBox;
//import javax.swing.JPasswordField;
//import javax.swing.JTextField;
//import javax.swing.JButton;
//
//
//
//
//
//
//import DAO.ConnectionDB;
//import DAO.TableHelper;
//
//import java.awt.event.ActionListener;
//import java.awt.event.ActionEvent;
//import java.io.PrintWriter;
//
//public class addTable extends JFrame implements ActionListener{
//
//	 Container c = getContentPane();
//	private JTextField textField_1;
//	 private JButton btnsave,  btncancel,btnccolumnMap,btnRel;
//	 private JTextField txtTableLabel;
//	 public JComboBox cbxTable;
//		TableHelper tableHelper = new TableHelper("ali");
//	public addTable() {
//		
//		
//		 super("Table ");
//	        this.setSize(450, 400);
//	        setLayout(null);
//	        
//	        JLabel lbltable = new JLabel("Table");
//	        lbltable.setBounds(29, 30, 46, 14);
//	        add(lbltable);
//	        
//	        JLabel lbltableLabel = new JLabel("Table Label");
//	        lbltableLabel.setBounds(29, 68, 86, 14);
//	        add(lbltableLabel);
//	        
//	        final JComboBox cbxTable = new JComboBox(tableHelper.getTables("").toArray());
//	      
//	        cbxTable.setBounds(138, 27, 150, 20);
//	       //add(cbxTable);
//	        
//	        txtTableLabel = new JTextField();
//	        txtTableLabel.setBounds(138, 65, 101, 20);
//	        add(txtTableLabel);
//	        txtTableLabel.setColumns(10);
//	        
//	        JButton btnsave = new JButton("Save");
//	        btnsave.setBounds(302, 26, 132, 23);
//	        add(btnsave);
//	        
//	        JButton btnccolumnMap = new JButton("Column Mapping");
//	   
//	        btnccolumnMap.setBounds(302, 64, 132, 23);
//	        add(btnccolumnMap);
//	        
//	        JButton btnRel = new JButton("Related Entities");
//	     
//	        btnRel.setBounds(302, 114, 132, 23);
//	        add(btnRel);
//	        
//	        JButton btnCancel = new JButton("Cancel");
//	        btnCancel.setBounds(302, 150, 132, 23);
//	        add(btnCancel);
//	        this.setResizable(false);
//	        Dimension d=Toolkit.getDefaultToolkit().getScreenSize();
//	        this.setLocation((d.width / 2) - 175, (d.height / 2) - 150);
//	        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
//	        add(lbltableLabel);
//	        add(cbxTable);
//	        add(lbltable);
//	        add(txtTableLabel);
//	        add(btnsave);
//	        add(btnccolumnMap);
//	        add(btnCancel);
//	        add(btnRel);
//	
//	}
//
//	public static void main(String[] args) {
//		new addTable().setVisible(true);
//	}
//
//	public void actionPerformed(ActionEvent arg0) {
//		// TODO Auto-generated method stub
//		
//	}
//	
//
//		
//		
//		
//	
//}
//
//
