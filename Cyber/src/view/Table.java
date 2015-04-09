package view;

     import java.awt.BorderLayout;
        import java.awt.Dimension;
        import java.awt.Point;
        import java.awt.datatransfer.DataFlavor;
        import java.awt.datatransfer.Transferable;
        import java.awt.datatransfer.UnsupportedFlavorException;
        import java.awt.dnd.DnDConstants;
        import java.awt.dnd.DropTarget;
        import java.awt.dnd.DropTargetDropEvent;
        import java.awt.event.ActionEvent;
        import java.awt.event.ActionListener;
        import java.io.File;
        import java.io.IOException;
        import java.util.List;

        import javax.swing.ImageIcon;
        import javax.swing.JButton;
        import javax.swing.JFileChooser;
        import javax.swing.JFrame;
        import javax.swing.JMenu;
        import javax.swing.JMenuBar;
        import javax.swing.JMenuItem;
        import javax.swing.JScrollPane;
        import javax.swing.JTable;
        import javax.swing.table.DefaultTableModel;

        public class Table extends JFrame implements ActionListener {
            private JTable table;
            private JScrollPane scroll;
            private JButton add;
            private JFileChooser choose;
            private JMenuBar menubar;
            private JMenu menu;
            private JMenuItem file;
            private DefaultTableModel tm = new DefaultTableModel(new String[] { "File",
                    "File Type", "Size", "Status" }, 2);

            public Table() {

                // String column [] = {"Filename ","File Type", "Size", "Status" };
                /*
                 * Object[][] data = { {"File1", ".jpg","32 MB", "Not Processed"},
                 * {"File2", ".txt"," 5 Kb", "Not Processed"}, {"File3", ".doc","3 Kb",
                 * "Not Processed"},
                 * 
                 * };
                 */

                table = new JTable();
                table.setModel(tm);
                table.setFillsViewportHeight(true);
                table.setPreferredSize(new Dimension(500, 300));

                scroll = new JScrollPane(table);

                table.setDropTarget(new DropTarget() {
                    @Override
                    public synchronized void drop(DropTargetDropEvent dtde) {

                        Point point = dtde.getLocation();
                        int column = table.columnAtPoint(point);
                        int row = table.rowAtPoint(point);

                        dtde.acceptDrop(DnDConstants.ACTION_COPY_OR_MOVE);
                        Transferable t = dtde.getTransferable();
                        List fileList = null;
                        try {
                            fileList = (List) t
                                    .getTransferData(DataFlavor.javaFileListFlavor);
                        } catch (UnsupportedFlavorException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        } catch (IOException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }
                        File f = (File) fileList.get(0);
                        table.setValueAt(f.getAbsolutePath(), row, column);
                        table.setValueAt(f.length(), row, column + 1);
                        super.drop(dtde);
                    }
                });
                scroll.setDropTarget(new DropTarget() {
                    @Override
                    public synchronized void drop(DropTargetDropEvent dtde) {
                        Point point = dtde.getLocation();
                        int column = table.columnAtPoint(point);
                        int row = table.rowAtPoint(point);

                        dtde.acceptDrop(DnDConstants.ACTION_COPY_OR_MOVE);
                        Transferable t = dtde.getTransferable();
                        List fileList = null;
                        try {
                            fileList = (List) t
                                    .getTransferData(DataFlavor.javaFileListFlavor);
                        } catch (UnsupportedFlavorException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        } catch (IOException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }
                        File f = (File) fileList.get(0);
                        table.setValueAt(f.getAbsolutePath(), row, column);
                        table.setValueAt(f.length(), row, column + 1);
                        // handle drop outside current table (e.g. add row)
                        super.drop(dtde);
                    }
                });

                add(scroll, BorderLayout.CENTER);

                menubar = new JMenuBar();
                menu = new JMenu("File");
                file = new JMenuItem("file");
                menu.add(file);
                // menubar.add(menu);
                add(menu, BorderLayout.NORTH);

                ImageIcon icon = new ImageIcon("lock_icon.png");

                add = new JButton("Add", icon);
                add.addActionListener(this);

                JFileChooser choose = new JFileChooser();
                choose.addActionListener(this);
            }

            public void actionPerformed(ActionEvent e) {
                JButton clicked = (JButton) e.getSource();

                int returnValue = 0;

                if (clicked == add) {
                    choose = new JFileChooser();
                    choose.showOpenDialog(null);

                    if (returnValue == JFileChooser.APPROVE_OPTION) {
                        File file = choose.getSelectedFile();
                        file.getAbsolutePath();

                    }

                }

            }

            public static void main(String[] args) {
                javax.swing.SwingUtilities.invokeLater(new Runnable() {
                    public void run() {

                        Table t = new Table();

                        t.setDefaultCloseOperation(EXIT_ON_CLOSE);
                        t.pack();
                        t.setSize(600, 200);
                        t.setVisible(true);
                        t.setTitle("ZipLock");
                        t.setIconImage(null);

                    }
                });

            }
            }