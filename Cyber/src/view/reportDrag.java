package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.TextArea;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.dnd.Autoscroll;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DragGestureEvent;
import java.awt.dnd.DragGestureListener;
import java.awt.dnd.DragGestureRecognizer;
import java.awt.dnd.DragSource;
import java.awt.dnd.DragSourceDragEvent;
import java.awt.dnd.DragSourceDropEvent;
import java.awt.dnd.DragSourceEvent;
import java.awt.dnd.DragSourceListener;
import java.awt.dnd.DropTarget;
import java.awt.dnd.DropTargetContext;
import java.awt.dnd.DropTargetDragEvent;
import java.awt.dnd.DropTargetDropEvent;
import java.awt.dnd.DropTargetEvent;
import java.awt.dnd.DropTargetListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTree;
import javax.swing.TransferHandler;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;

import DAO.GetFieldName;
import DAO.GetTableName;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class reportDrag extends JFrame {

static ArrayList<String> dropText= new ArrayList<String>();
static ArrayList<String> dropTextcriteria= new ArrayList<String>();
private JPanel contentPane;
/**
* 
*/
private static final long serialVersionUID = 1L;

public static ArrayList<String> getDropText() {
return dropText;
}

public  void setDropText(ArrayList<String> dropText) {
this.dropText = dropText;
}

JTree tree;
static TextArea area=new TextArea();
static TextArea area2 = new TextArea();
private JTextField textField;

public static TextArea getArea() {
return area;
}

public static void setArea(TextArea area) {
reportDrag.area = area;
}

public reportDrag() {

	super("Report Screen");

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
		
	
		setSize(566, 524);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		tree_1.setBounds(10, 47, 135, 412);
		getContentPane().add(tree_1);
		
		area.setBounds(155, 48, 385, 116);
		getContentPane().add(area);
		
		area2.setBounds(155, 176, 385, 283);
		getContentPane().add(area2);

area.setEnabled(true);
area2.setEnabled(true);
//getContentPane().add(new JScrollPane(tree_1));

JLabel lblReportName = new JLabel("Report Name: ");
lblReportName.setBounds(25, 11, 100, 14);
getContentPane().add(lblReportName);
textField = new JTextField();
textField.setBounds(135, 8, 112, 20);
getContentPane().add(textField);
textField.setColumns(10);
JButton btnSave = new JButton("Save");
btnSave.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent arg0) {
	}
});
btnSave.setBounds(296, 7, 89, 23);
getContentPane().add(btnSave);
JButton btnCancel = new JButton("Cancel");
btnCancel.setBounds(409, 7, 89, 23);
getContentPane().add(btnCancel);

JTextArea textArea = new JTextArea();
//getContentPane().add(textArea, BorderLayout.CENTER);
setVisible(true);
}
catch (Exception e) {
	e.printStackTrace();
}
}


public static void main(String args[]) {
new reportDrag();
}

public static TextArea getArea2() {
	return area2;
}

public static void setArea2(TextArea area2) {
	reportDrag.area2 = area2;
}

public static ArrayList<String> getDropTextcriteria() {
	return dropTextcriteria;
}

public static void setDropTextcriteria(ArrayList<String> dropTextcriteria) {
	reportDrag.dropTextcriteria = dropTextcriteria;
}

private class DragMouseAdapter extends MouseAdapter {
public void mousePressed(MouseEvent e) {
JComponent c = (JComponent) e.getSource();
TransferHandler handler = c.getTransferHandler();
handler.exportAsDrag(c, e, TransferHandler.LINK);
}
}


}

