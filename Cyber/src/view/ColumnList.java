package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ColumnList extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTable table_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ColumnList frame = new ColumnList();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ColumnList() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblColumnList = new JLabel("Column List");
		lblColumnList.setBounds(10, 13, 89, 14);
		contentPane.add(lblColumnList);
		
		JButton btnAddColumn = new JButton("Add Column");
		btnAddColumn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new AddColumn().setVisible(true);
			}
		});
		btnAddColumn.setBounds(109, 9, 89, 23);
		contentPane.add(btnAddColumn);
		
		table = new JTable();
		table.setBounds(156, 225, -154, -198);
		contentPane.add(table);
		
		table_3 = new JTable();
		table_3.setBounds(20, 43, 178, 207);
		contentPane.add(table_3);
		
	}
}
