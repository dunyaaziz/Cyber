package view;

import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.ScrollPaneConstants;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;

import DAO.GetFieldName;
import DAO.GetTableName;

public class treeDnD {

  public static void main(String[] a) {
    JFrame f = new JFrame();
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    f.add(new JTreeEvents());
    f.setSize(500, 500);
    f.setVisible(true);
  }
}

class JTreeEvents extends JPanel {
  JTree tree;

  JTextField jtf;

  public JTreeEvents() {
    setLayout(new BorderLayout());

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
			//DefaultTreeModel model = new DefaultTreeModel(Genel);
			

			JTree tree= new JTree(Genel);


    int v = ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED;
    int h = ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED;
    JScrollPane jsp = new JScrollPane(tree, v, h);

    add(jsp, BorderLayout.CENTER);

    jtf = new JTextField("", 50);
    add(jtf, BorderLayout.SOUTH);

    tree.addMouseListener(new MouseAdapter() {
      public void mouseClicked(MouseEvent me) {
        doMouseClicked(me);
      }
    });
  }catch (Exception e) {
		e.printStackTrace();
	}
  }

  void doMouseClicked(MouseEvent me) {
    TreePath tp = tree.getPathForLocation(me.getX(), me.getY());
    if (tp != null)
      jtf.setText(tp.toString());
    else
      jtf.setText("");
  }
}