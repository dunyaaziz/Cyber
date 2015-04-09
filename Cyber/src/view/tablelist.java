//package view;
//
//import java.awt.BorderLayout;
//import java.awt.EventQueue;
//
//import javax.swing.JFrame;
//import javax.swing.JPanel;
//import javax.swing.border.EmptyBorder;
//import javax.swing.JLabel;
//import javax.swing.JButton;
//import javax.swing.JTable;
//import java.awt.event.ActionListener;
//import java.awt.event.ActionEvent;
//
//public class tablelist extends JFrame {
//
//	private JPanel contentPane;
//	private JTable table;
//
//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					tablelist frame = new tablelist();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}
//
//	/**
//	 * Create the frame.
//	 */
//	public tablelist() {
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		setBounds(100, 100, 287, 406);
//		contentPane = new JPanel();
//		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
//		setContentPane(contentPane);
//		contentPane.setLayout(null);
//		
//		JLabel lblTableList = new JLabel("Table List");
//		lblTableList.setBounds(58, 14, 104, 28);
//		contentPane.add(lblTableList);
//		
//		JButton btnAddTable = new JButton("Add Table");
//		btnAddTable.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				
//				new addTable().setVisible(true);
//			}
//		});
//		btnAddTable.setBounds(128, 17, 89, 23);
//		contentPane.add(btnAddTable);
//		
//		table = new JTable();
//		table.setBounds(10, 53, 251, 307);
//		contentPane.add(table);
//		
//	}
//}
