package create_report_view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.JButton;

import DAO.ReportList;

import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.SQLException;

public class report_runner_time extends JFrame {

	private JPanel contentPane;
	public report_runner_time() throws SQLException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 416, 634);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblReportList = new JLabel("Report List");
		lblReportList.setBounds(47, 30, 89, 14);
		contentPane.add(lblReportList);
		final JComboBox comboBox = new JComboBox(ReportList.GetReportName().toArray());

		comboBox.setBounds(146, 27, 140, 20);
		contentPane.add(comboBox);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(10, 76, 371, 127);
		contentPane.add(textArea);
		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setBounds(10, 243, 371, 264);
		contentPane.add(textArea_1);
		
		JButton btnaltr = new JButton("\u00C7al\u0131\u015Ft\u0131r");
		btnaltr.setBounds(292, 26, 89, 23);
		contentPane.add(btnaltr);
		
		JButton btnSorgula = new JButton("sorgula");
		btnSorgula.setBounds(292, 214, 89, 23);
		contentPane.add(btnSorgula);
		
		JButton btnKaydet = new JButton("Kaydet");
		btnKaydet.setBounds(292, 541, 89, 23);
		contentPane.add(btnKaydet);

	}
}
