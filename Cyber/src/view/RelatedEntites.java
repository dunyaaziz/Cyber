package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;

public class RelatedEntites extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RelatedEntites frame = new RelatedEntites();
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
	public RelatedEntites() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblSource = new JLabel("Source");
		lblSource.setBounds(40, 37, 46, 14);
		contentPane.add(lblSource);
		
		JLabel lblTarget = new JLabel("Target");
		lblTarget.setBounds(303, 37, 46, 14);
		contentPane.add(lblTarget);
		
		JLabel lblNewLabel = new JLabel("Table");
		lblNewLabel.setBounds(10, 73, 46, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Column");
		lblNewLabel_1.setBounds(10, 98, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(66, 70, 87, 20);
		contentPane.add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(66, 95, 87, 20);
		contentPane.add(comboBox_1);
		
		JLabel lblTable = new JLabel("Table");
		lblTable.setBounds(248, 73, 46, 14);
		contentPane.add(lblTable);
		
		JLabel lblNewLabel_2 = new JLabel("Column");
		lblNewLabel_2.setBounds(248, 98, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setBounds(303, 70, 77, 20);
		contentPane.add(comboBox_2);
		
		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setBounds(304, 95, 76, 20);
		contentPane.add(comboBox_3);
		
		JLabel lblRelationship = new JLabel("Relationship");
		lblRelationship.setBounds(126, 165, 70, 14);
		contentPane.add(lblRelationship);
		
		JComboBox comboBox_4 = new JComboBox();
		comboBox_4.setBounds(226, 162, 116, 20);
		contentPane.add(comboBox_4);
		
		JButton btnSave = new JButton("Save");
		btnSave.setBounds(156, 211, 89, 23);
		contentPane.add(btnSave);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setBounds(255, 211, 89, 23);
		contentPane.add(btnDelete);
	}

}
