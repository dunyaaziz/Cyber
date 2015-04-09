package createreportview;

import javax.swing.JFrame;

import java.awt.TextArea;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DragGestureEvent;
import java.awt.dnd.DragGestureListener;
import java.awt.dnd.DragGestureRecognizer;
import java.awt.dnd.DragSource;
import java.awt.dnd.DragSourceContext;
import java.awt.dnd.DragSourceDragEvent;
import java.awt.dnd.DragSourceDropEvent;
import java.awt.dnd.DragSourceEvent;
import java.awt.dnd.DragSourceListener;
import java.awt.dnd.DropTarget;
import java.awt.dnd.DropTargetDragEvent;
import java.awt.dnd.DropTargetDropEvent;
import java.awt.dnd.DropTargetEvent;
import java.awt.dnd.DropTargetListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;

import DAO.GetFieldName;
import DAO.GetTableName;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;

public class CreateReportView extends JFrame {

	static ArrayList<String> dropText= new ArrayList<String>();
	private static final long serialVersionUID = 1L;
	static TextArea area=new TextArea();
	static TextArea area2 = new TextArea();
	private JTextField ReportName;
	JButton btnSave;
	
	public CreateReportView() {
	super("Report Screen");
	
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
			fieldarray=fieldnameclass.GetFieldNameMethod(tablearray.get(i));
			for(j=0;j<fieldarray.size();j++){
				DefaultMutableTreeNode field = new DefaultMutableTreeNode(fieldarray.get(j));
				TableName.add(field);
        		}
        	}
		DefaultTreeModel model = new DefaultTreeModel(Genel);
		
		JTree tree = new JTree(model);
		setSize(566, 524);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		tree.setBounds(10, 47, 135, 412);
		getContentPane().add(tree);
		
		area.setBounds(155, 48, 385, 147);
		getContentPane().add(area);
		
		area2.setBounds(155, 201, 385, 258);
		getContentPane().add(area2);
		area.setEnabled(true);
		
		JLabel lblReportName = new JLabel("Report Name: ");
		lblReportName.setBounds(25, 11, 100, 14);
		getContentPane().add(lblReportName);
		
		ReportName = new JTextField();
		ReportName.setBounds(135, 8, 112, 20);
		getContentPane().add(ReportName);
		ReportName.setColumns(10);
		
		btnSave = new JButton("Save");
		btnSave.setBounds(296, 7, 89, 23);
		getContentPane().add(btnSave);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBounds(409, 7, 89, 23);
		getContentPane().add(btnCancel);
		setVisible(true);
		
		new TreeDragSource(tree, DnDConstants.ACTION_COPY);
		new AreaDropTarget(area);
		new AreaDropTarget(area2);
		//new DropTarget(area,DnDConstants.ACTION_COPY_OR_MOVE,this);
	}
	catch (Exception e) {
		e.printStackTrace();
	}
}

	public String getReportName() {
		return ReportName.getText();
	}

	public void setReportName(JTextField reportName) {
		ReportName = reportName;
	}

	public static TextArea getArea() {
		return area;
	}

	public static void setArea(TextArea area) {
		CreateReportView.area = area;
	}

	public static ArrayList<String> getDropText() {
		return dropText;
	}

	public  void setDropText(ArrayList<String> dropText) {
		this.dropText = dropText;
	}
	
	public void btnSave(ActionListener edit){
		btnSave.addActionListener(edit);
	}

	public static void main(String args[]) {
		new CreateReportView();
	}

	public static TextArea getArea2() {
		return area2;
	}

	public static void setArea2(TextArea area2) {
		CreateReportView.area2 = area2;
	}

	
	
class TreeDragSource implements DragSourceListener, DragGestureListener 
{
	DragSource source;
	DragGestureRecognizer recognizer;
	TransferableTreeNode transferable;
	DefaultMutableTreeNode oldNode;
	JTree sourceTree;
	
	public TreeDragSource(JTree tree, int actions) {
		sourceTree = tree;
		source = new DragSource();
		recognizer = source.createDefaultDragGestureRecognizer(sourceTree,actions, this);
    }

	public void dragGestureRecognized(DragGestureEvent dge) {
		TreePath path = sourceTree.getSelectionPath();
		if ((path == null) || (path.getPathCount() <= 1)) {
			return;
	    }
		oldNode = (DefaultMutableTreeNode) path.getLastPathComponent();
		oldNode.toString();
		String node = path.getPath().toString();
		transferable = new TransferableTreeNode(node);
		
		source.startDrag(dge, DragSource.DefaultMoveNoDrop, transferable, this);
	}

	public void dragEnter(DragSourceDragEvent e) {
		DragSourceContext ctx = e.getDragSourceContext();

	    int action = e.getDropAction();
	    if ((action & DnDConstants.ACTION_COPY) != 0)
	      ctx.setCursor(DragSource.DefaultCopyDrop);
	    else
	      ctx.setCursor(DragSource.DefaultCopyNoDrop);
	}

	public void dragExit(DragSourceEvent dse) {
	}

	public void dragOver(DragSourceDragEvent dsde) {
	}

	public void dropActionChanged(DragSourceDragEvent dsde) {
	}

	public void dragDropEnd(DragSourceDropEvent dsde) {
		dsde.getDropSuccess();
	}
}

class AreaDropTarget implements DropTargetListener {

	DropTarget target;
	TextArea targetArea;

	 public AreaDropTarget(TextArea area) {
		targetArea = area;
		target = new DropTarget(targetArea, this);
	}

	public void dragEnter(DropTargetDragEvent dtde) {
		
	}
	public void dragOver(DropTargetDragEvent dtde) {
	}
	public void dragExit(DropTargetEvent dte) {
	}

	public void dropActionChanged(DropTargetDragEvent dtde) {
	}
	public void drop(DropTargetDropEvent dtde) {
	      if (dtde.isDataFlavorSupported(DataFlavor.stringFlavor)) 
	        dtde.acceptDrop(dtde.getDropAction());
		TextArea textDrop=CreateReportView.getArea();
		CreateReportView.getDropText().add(getName());
		textDrop.setText(" ");
		for(int i=0;i<CreateReportView.getDropText().size();i++)
		{
			if(CreateReportView.getDropText().size()==1){
				textDrop.append((String)CreateReportView.getDropText().get(i)+"   ");
			} else
				textDrop.append((String)CreateReportView.getDropText().get(i)+",  ");
		}
		     
	}
}


	class TransferableTreeNode implements Transferable {

		public final DataFlavor TREE_PATH_FLAVOR = new DataFlavor(TreePath.class,"Tree Path");
		DataFlavor flavors[] = { TREE_PATH_FLAVOR };
		String path;

		public TransferableTreeNode(String node) {
			path = node;
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

	}
}


