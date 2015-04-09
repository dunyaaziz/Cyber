package createreportview;

import java.awt.BorderLayout;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Panel;
import java.awt.Point;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.Label;
import java.awt.Scrollbar;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
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
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JTree;

import DAO.GetFieldName;
import DAO.GetTableName;

import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.GridLayout;

import javax.swing.JLabel;



public class a extends JFrame {
	static ArrayList<String> dropText= new ArrayList<String>();
	public static ArrayList<String> getDropText() {
		return dropText;
	}

	public static void setDropText(ArrayList<String> dropText) {
		a.dropText = dropText;
	}

	private static final long serialVersionUID = 8098675306509766426L;
	private JPanel contentPane;
	TextField reportName;
	JButton SaveButton;
	JComboBox<String> reportUser;
	static TextArea area = new TextArea();
	static TextArea area2 = new TextArea();
	
	public static TextArea getArea() {
		return area;
		}

		public static void setArea(TextArea area) {
		a.area = area;
		}
	public a() {
		try{
		GetFieldName fieldnameclass=new GetFieldName();
		GetTableName tablenameclass=new GetTableName();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(10, 10, 700, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		Panel panel = new Panel();
		contentPane.add(panel, BorderLayout.NORTH);
		panel.setLayout(new GridLayout(2,4));
		
		Label label = new Label("Report Name:");
		panel.add(label);
		
		reportName = new TextField();
		reportName.setColumns(10);
		reportName.setCaretPosition(10);
		panel.add(reportName);
		
		SaveButton = new JButton("Save");
		panel.add(SaveButton);
		
		JButton btnCancel = new JButton("Cancel");
		panel.add(btnCancel); 
		
		JLabel lblSelectUser = new JLabel("Select Report User");
		panel.add(lblSelectUser);
		
		reportUser = new JComboBox<String>();
		panel.add(reportUser);
		
		JLabel lblSelectUser1 = new JLabel(" ");
		panel.add(lblSelectUser1);
		Scrollbar scrollbar = new Scrollbar();
		contentPane.add(scrollbar, BorderLayout.EAST);
		ArrayList<String> tablearray = tablenameclass.GetTableNameFromDb();
			
		DefaultMutableTreeNode Genel = new DefaultMutableTreeNode("TableName");
		int i=0;
		int a;
		for(i=0;i<tablearray.size();i++){
			ArrayList<String> fieldarray=null;
			DefaultMutableTreeNode TableName = new DefaultMutableTreeNode(tablearray.get(i));	
			Genel.add(TableName);
			fieldarray=fieldnameclass.GetFieldNameMethod(tablearray.get(i));
			for(a=0;a<fieldarray.size();a++){
				DefaultMutableTreeNode field = new DefaultMutableTreeNode(fieldarray.get(a));
				TableName.add(field);
			}
		}
		DefaultTreeModel model = new DefaultTreeModel(Genel);
		JTree tree = new JTree(model);
		contentPane.add(tree, BorderLayout.WEST);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		TextArea area=new TextArea();
		 JScrollPane scrollPane = new JScrollPane(area);
	        scrollPane.setPreferredSize(new Dimension(400,100));
	        JPanel panel_2 = new JPanel(new BorderLayout());
	        panel_2.add(scrollPane, BorderLayout.SOUTH);
	        panel_2.setBorder(BorderFactory.createTitledBorder("Text Area"));
		panel_1.add(panel_2,BorderLayout.SOUTH);
		
		contentPane.add(panel_1, BorderLayout.CENTER);
		area2=new TextArea();
		 JScrollPane scrollPane2 = new JScrollPane(area2);
	        scrollPane2.setPreferredSize(new Dimension(400,100));
	        JPanel panel_3 = new JPanel(new BorderLayout());
	        panel_3.add(scrollPane2, BorderLayout.NORTH);
	        panel_3.setBorder(BorderFactory.createTitledBorder("Text Area"));
		panel_1.add(panel_3,BorderLayout.NORTH);
		TreeDropTarget dt = new TreeDropTarget(area);
		dt = new TreeDropTarget(area);
		
	}catch (Exception e) {
		// TODO: handle exception
		}
	}
	
	public String GetReportOwner(){
		String reportOwner=reportUser.getSelectedItem().toString();;
		return reportOwner;
	}
	
	public String GetReportName(){
		String reportname=reportName.getText();
		return reportname;
	}

	public void SaveReport(ActionListener edit){
		SaveButton.addActionListener(edit);
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					a frame = new a();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

		public static TextArea getArea2() {
			return area2;
		}

		public static void setArea2(TextArea area2) {
			a.area2 = area2;
		}


		class TreeDragSource implements DragSourceListener, DragGestureListener {

		DragSource source;

		DragGestureRecognizer recognizer;

		TransferableTreeNode transferable;

		DefaultMutableTreeNode oldNode;

		JTree sourceTree;

		private String newnode;

		public TreeDragSource(JTree tree, int actions) {
		sourceTree = tree;
		source = new DragSource();
		recognizer = source.createDefaultDragGestureRecognizer(sourceTree,
		    actions, this);
		}

		public String getNewnode() {
		return newnode;
		}

		public void setNewnode(String newnode) {
		 this.newnode = newnode;
		}


		public void dragGestureRecognized(DragGestureEvent dge) {
		TreePath path = sourceTree.getSelectionPath();
		if ((path == null) || (path.getPathCount() <= 1)) {
		  // We can't move the root node or an empty selection
		  return;
		}
		oldNode = (DefaultMutableTreeNode) path.getLastPathComponent();
		System.out.println(path.toString());
		setNewnode(oldNode.toString());
		System.out.println(oldNode.toString());
		String node = path.getPath().toString();
		transferable = new TransferableTreeNode(node);
		source.startDrag(dge, DragSource.DefaultMoveNoDrop, transferable, this);


		}


		public void dragEnter(DragSourceDragEvent dsde) {
		}

		public void dragExit(DragSourceEvent dse) {
		}

		public void dragOver(DragSourceDragEvent dsde) {
		}

		public void dropActionChanged(DragSourceDragEvent dsde) {
		System.out.println("Action: " + dsde.getDropAction());
		System.out.println("Target Action: " + dsde.getTargetActions());
		System.out.println("User Action: " + dsde.getUserAction());
		}

		public void dragDropEnd(DragSourceDropEvent dsde) {
		// TODO Auto-generated method stub
		dsde.getDropSuccess();

		// TODO Auto-generated method stub
		dsde.getDropSuccess();
		TextArea textDrop=getArea();
		a.getDropText().add(getNewnode());
		textDrop.setText(" ");
		for(int i=0;i<a.getDropText().size();i++){
		if(a.getDropText().size()==1){
				textDrop.append((String)a.getDropText().get(i)+"   ");
		} else
			 textDrop.append((String)a.getDropText().get(i)+",  ");
		}
		//JTextArea area1=new JTextArea();
		//area1.setText(getNewnode());
		}
		}



		//TreeDropTarget.java
		//A quick DropTarget that's looking for drops from draggable JTrees.
		//

		class TreeDropTarget implements DropTargetListener {

		DropTarget target;

		TextArea targetTree;

		public TreeDropTarget(TextArea tree) {
		targetTree = tree;
		target = new DropTarget(targetTree, this);
		}

		/*
		* Drop Event Handlersarget
		*/
		private void getNodeForEvent(DropTargetDragEvent dtde) {
		Point p = dtde.getLocation();
		DropTargetContext dtc = dtde.getDropTargetContext();
		Component tree =  dtc.getComponent();
		System.out.println(tree.toString()+"22222222");
		//TreePath path = tree.getClosestPathForLocation(p.x, p.y);
		//return  path.getLastPathComponent();
		}

		public void dragEnter(DropTargetDragEvent dtde) {
		//  System.out.println(dtde.toString());
		//TreeNode node = getNodeForEvent(dtde);
		//if (node.isLeaf()) {
		//  dtde.rejectDrag();
		//} else {
		//  // start by supporting move operations
		//  //dtde.acceptDrag(DnDConstants.ACTION_MOVE);
		//  dtde.acceptDrag(dtde.getDropAction());
		//}
		}

		public void dragOver(DropTargetDragEvent dtde) {
		  System.out.println("ahanda geldim");
		/*TreeNode node = getNodeForEvent(dtde);
		if (node.isLeaf()) {
		  dtde.rejectDrag();
		} else {
		  // start by supporting move operations
		  //dtde.acceptDrag(DnDConstants.ACTION_MOVE);
		  dtde.acceptDrag(dtde.getDropAction());
		}*/
		}

		public void dragExit(DropTargetEvent dte) {
		}

		public void dropActionChanged(DropTargetDragEvent dtde) {
		}
		public void drop(DropTargetDropEvent dtde) {

		DropTargetContext dtc = dtde.getDropTargetContext();

		}
		}

		//TransferableTreeNode.java
		//A Transferable TreePath to be used with Drag & Drop applications.
		//

		class TransferableTreeNode implements Transferable {

		public final DataFlavor TREE_PATH_FLAVOR = new DataFlavor(TreePath.class,
		  "Tree Path");

		DataFlavor flavors[] = { TREE_PATH_FLAVOR };

		String path;

		public TransferableTreeNode(String path2) {
			path = path2;
			// TODO Auto-generated constructor stub
		}

		public synchronized DataFlavor[] getTransferDataFlavors() {
		return flavors;
		}

		public boolean isDataFlavorSupported(DataFlavor flavor) {
		return (flavor.getRepresentationClass() == TreePath.class);
		}

		public synchronized Object getTransferData(DataFlavor flavor)
		  throws UnsupportedFlavorException, IOException {
		if (isDataFlavorSupported(flavor)) {
		  return (Object) path;
		} else {
		  throw new UnsupportedFlavorException(flavor);
		}
		}

		}}



