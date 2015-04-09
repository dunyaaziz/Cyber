package view;

////mouse event
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
import java.awt.geom.Area;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;

public class denneenn extends JFrame {
	static ArrayList<String> dropText= new ArrayList<String>();
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

TreeDragSource ds;

TreeDropTarget dt;
//JTree tree;
static ReportSchemas reportSchema = new ReportSchemas();
// TextArea area=new TextArea();


public denneenn() {
super("Rearrangeable Tree");
setSize(400, 400);
setDefaultCloseOperation(EXIT_ON_CLOSE);

// If you want autoscrolling, use this line:
//tree = new AutoScrollingJTree();
// Otherwise, use this line:
//tree = new JTree();
reportSchema.setEnabled(true);
//getContentPane().add(new JScrollPane(reportSchema.getTree_1()), BorderLayout.WEST);
//getContentPane().add(reportSchema,BorderLayout.SOUTH);
// If we only support move operations...
ds = new TreeDragSource(reportSchema.getTree_1(), DnDConstants.ACTION_MOVE);
ds = new TreeDragSource(reportSchema.getTree_1(), DnDConstants.ACTION_COPY);
dt = new TreeDropTarget(reportSchema.getTextField_1());
reportSchema.setVisible(true);
}

public class AutoScrollingJTree extends JTree implements Autoscroll {
private int margin = 12;

public AutoScrollingJTree() {
  super();
}

public void autoscroll(Point p) {
  int realrow = getRowForLocation(p.x, p.y);
  Rectangle outer = getBounds();
  realrow = (p.y + outer.y <= margin ? realrow < 1 ? 0 : realrow - 1
      : realrow < getRowCount() - 1 ? realrow + 1 : realrow);
  scrollRowToVisible(realrow);
}

public Insets getAutoscrollInsets() {
  Rectangle outer = getBounds();
  Rectangle inner = getParent().getBounds();
  return new Insets(inner.y - outer.y + margin, inner.x - outer.x
      + margin, outer.height - inner.height - inner.y + outer.y
      + margin, outer.width - inner.width - inner.x + outer.x
      + margin);
}

// Use this method if you want to see the boundaries of the
// autoscroll active region

public void paintComponent(Graphics g) {
  super.paintComponent(g);
  Rectangle outer = getBounds();
  Rectangle inner = getParent().getBounds();
  g.setColor(Color.red);
  g.drawRect(-outer.x + 12, -outer.y + 12, inner.width - 24,
      inner.height - 24);
}

}

//public static void main(String args[]) {
//new denneenn();
//}
}

//TreeDragSource.java
//A drag source wrapper for a JTree. This class can be used to make
//a rearrangeable DnD tree with the TransferableTreeNode class as the
//transfer data type.

class TreeDragSource implements DragSourceListener, DragGestureListener {

DragSource source;

DragGestureRecognizer recognizer;

TransferableTreeNode transferable;

DefaultMutableTreeNode oldNode;

JTree sourceTree;

public TreeDragSource(JTree tree, int actions) {
sourceTree = tree;
source = new DragSource();
recognizer = source.createDefaultDragGestureRecognizer(sourceTree,
    actions, this);
}

String newnode;

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
transferable = new TransferableTreeNode(path);
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
JTextField textDrop=denneenn.reportSchema.getTextField_1();
denneenn.getDropText().add(getNewnode());
textDrop.setText(" ");
for(int i=0;i<denneenn.getDropText().size();i++){
if(denneenn.getDropText().size()==1){
	try {
		((Appendable) textDrop).append((String)denneenn.getDropText().get(i)+"   ");
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
} else
	try {
		((Appendable) textDrop).append((String)denneenn.getDropText().get(i)+",  ");
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
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

JTextField targetTree;

public TreeDropTarget(JTextField jTextField) {
targetTree = jTextField;
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

public static DataFlavor TREE_PATH_FLAVOR = new DataFlavor(TreePath.class,
  "Tree Path");

DataFlavor flavors[] = { TREE_PATH_FLAVOR };

TreePath path;

public TransferableTreeNode(TreePath tp) {
path = tp;
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

