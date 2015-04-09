package view;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.text.JTextComponent;

import DAO.*;

public class NewRegistration extends JFrame implements ActionListener {

    Container c = getContentPane();
    private JButton btnSave;
    private JLabel lblName,  lblStatus,lblPassword,lblPassword2;
    private JTextField txtName,txtStatus;
    private JPasswordField txtPassword,txtPassword2;
    private JTextField textField;
  String[] Status = { "Manager", "Developer", "Runner"};

public NewRegistration() {
    super("New Regsitration ...");
    this.setSize(500, 300);
    getContentPane().setLayout(null);
    this.setResizable(false);
    Dimension d=Toolkit.getDefaultToolkit().getScreenSize();
    this.setLocation((d.width / 2) - 175, (d.height / 2) - 150);
    this.setDefaultCloseOperation(EXIT_ON_CLOSE);
   
    lblName = new JLabel("User Name");
    lblPassword = new JLabel("Password");
    lblPassword2 = new JLabel("R-Password");
    lblStatus = new JLabel("Status");
    
    txtName = new JTextField();
    txtPassword = new JPasswordField();
    txtPassword2 = new JPasswordField();
    txtStatus = new JTextField();
    btnSave = new JButton("Save");

    lblName.setBounds(50, 40, 140, 25);
    txtName.setBounds(150, 40, 130, 25);
    
    lblPassword.setBounds(50, 80, 140, 25);
    txtPassword.setBounds(150, 80, 130, 25);
    
    lblPassword2.setBounds(50, 120, 140, 25);
    txtPassword2.setBounds(150, 120, 130, 25);
    
    lblStatus.setBounds(50, 160, 140, 25);
    txtStatus.setBounds(150, 160, 140, 25);
    btnSave.setBounds(80, 200, 100, 25);
 
    add(lblName);
    add(lblStatus);
    add(lblPassword);
    add(lblPassword2);
    add(txtName);
    add(txtStatus);
    add(txtPassword);
    add(txtPassword2);
    add(btnSave);
    btnSave.addActionListener(this);
  
  
}
public void actionPerformed(ActionEvent e) {

    try {
    	ConnectionDB mgr = ConnectionDB.getInstance();
    	Connection con = (Connection) mgr.getConnection();
        Statement st = con.createStatement();
        try {
            if (e.getSource() == btnSave) {
                String Username = txtName.getText();
                String Password = txtPassword.getText();
               String CPassword = txtPassword2.getText();
                String Status = txtStatus.getText();
                
                if(Username.equalsIgnoreCase("")){
                    JOptionPane.showMessageDialog(null, "kullanýcý adý boþ olamaz!!", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                if(Password.equalsIgnoreCase("")){
                	JOptionPane.showMessageDialog(null, "password boþ kalamaz!!", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
             if (!CPassword.equals(Password)) {
                    JOptionPane.showMessageDialog(null, "Þifreler ayný deðil!!!", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
         
                String str = "insert into Userdb(username,loginstatus,password) values(?,?,?)";
                PreparedStatement ps = con.prepareStatement(str);
              
                ps.setString(1,Username);
                ps.setString(2,Status);
                ps.setString(3,Password);
            
                ps.executeUpdate();
                JOptionPane.showMessageDialog(null, "Database successfully updated", "Success", JOptionPane.INFORMATION_MESSAGE);
                txtName.setText("");
                txtPassword.setText("");
                txtStatus.setText("");
                
                setVisible(false);
            
            }//if Closed
        
        } catch (Exception x) {
            JOptionPane.showMessageDialog(null, "kullanýcý daha önce kullanýlmýþ!!", "Error", JOptionPane.ERROR_MESSAGE);
        }//inner try catch closed
    } catch (Exception ex) {
        JOptionPane.showMessageDialog(null, "Database baðlantý hatasý!!", "Error", JOptionPane.ERROR_MESSAGE);
    }//outer try catch closed
}
public static void main(String[] args)
{
	 new NewRegistration().setVisible(true);}
}

