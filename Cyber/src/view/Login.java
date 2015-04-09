//package view;
//
////import view.NewRegistration;
//
//
//import java.awt.BorderLayout;
//import java.awt.Container;
//import java.awt.Dimension;
//import java.awt.EventQueue;
//import java.awt.Toolkit;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.sql.Connection;
//import java.sql.ResultSet;
//import java.sql.Statement;
//
//import javax.swing.JFrame;
//import javax.swing.JPanel;
//import javax.swing.border.EmptyBorder;
//import javax.swing.ImageIcon;
//import javax.swing.JLabel;
//import javax.swing.JOptionPane;
//import javax.swing.JTextField;
//import javax.swing.JPasswordField;
//import javax.swing.JButton;
//import DAO.*;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.SQLException;
//
//public class Login extends JFrame implements ActionListener {
//	
//    Container c = getContentPane();
//    private JButton btnLogin,  btnCancel,btnRegistration;
//    private JLabel lblName,  lblStatus,lblPassword;
//    private JTextField txtName,txtStatus;
//    private JPasswordField txtPassword;
//
//
//
//	/**
//	 * Launch the application.
//	 */
//
//	/**
//	 * Create the frame.
//	 */
//	public Login() {
//		
//		   super("Login ...");
//	        this.setSize(400, 300);
//	        this.setLayout(null);
//	        this.setResizable(false);
//	        Dimension d=Toolkit.getDefaultToolkit().getScreenSize();
//	        this.setLocation((d.width / 2) - 175, (d.height / 2) - 150);
//	        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
//	        
//	        
//	        lblName = new JLabel("User Name");
//	        lblPassword = new JLabel("Password");
//	        lblStatus = new JLabel("Status");
//	        txtName = new JTextField();
//	        txtStatus = new JTextField();
//	        txtPassword = new JPasswordField();
//	        btnLogin = new JButton("Login");
//	        btnCancel = new JButton("Cancel");
//	        btnRegistration=new JButton("Registration");
//	        lblName.setBounds(50, 40, 140, 25);
//	        txtName.setBounds(150, 40, 130, 25);
//	        
//	        lblStatus.setBounds(50, 65, 140, 25);
//	        txtStatus.setBounds(150, 65, 130, 25);
//	        
//	        lblPassword.setBounds(50,95, 140, 25);
//	        txtPassword.setBounds(150, 95, 130, 25);
//	        
//	        btnLogin.setBounds(25,200,95, 25);
//	        btnRegistration.setBounds(130, 200, 145, 25);
//	        btnCancel.setBounds(280, 200, 95, 25);
//	        
//	        btnLogin.addActionListener(this);
//	        btnCancel.addActionListener(this);
//	        btnRegistration.addActionListener(this);
//	        this.add(lblName);
//	        this.add(lblStatus);
//	        this.add(lblPassword);
//	        this.add(txtName);
//	        this.add(txtStatus);
//	        this.add(txtPassword);
//	        this.add(btnLogin);
//	        this.add(btnCancel);
//	        this.add(btnRegistration);
//	}
//	
//		
//		public void actionPerformed(ActionEvent e) {
//	        if (e.getSource() == btnLogin) {
//	            try {
//	            	ConnectionDB mgr = ConnectionDB.getInstance();
//	            	Connection con = (Connection) mgr.getConnection();
//	                try {
//	                    Statement st = con.createStatement();
//	                    ResultSet rs = st.executeQuery("SELECT * from Userdb WHERE username='" + txtName.getText() +
//	                            "' and loginstatus='" + txtStatus.getText() +"'and password='"+txtPassword.getText() +"'");
//	                    System.out.println(rs);
//	                    if (rs.next()) {
//	                     System.out.println(txtName.getText());
//	                     System.out.println("giriþ baþarlý bi þekilde gercekleþti");
//	                     //if (loginstatus=="mgr")
//	                         new tablelist().setVisible(true); /*new Game(txtUName.getText());*/
//	                          this.dispose();
//	                    }else{
//	                        JOptionPane.showMessageDialog(null,"Invalid username or password","Invalid",JOptionPane.ERROR_MESSAGE);
//	                        txtName.setText("");
//	                        txtPassword.setText("");
//	                    }
//	                    con.close();
//	                    
//	                } catch (Exception ex) {
//	                    JOptionPane.showMessageDialog(null, "Invalid username or password", "Invalid", JOptionPane.ERROR_MESSAGE);
//	                    txtName.setText("");
//	                    txtPassword.setText("");
//	                }//inner try catch closed
//	            } catch (Exception x) {
//	                JOptionPane.showMessageDialog(null, "Unable to connect to the database", "Connection error", JOptionPane.ERROR_MESSAGE);
//	            }//outer try catch closed
//	        }//if closed
//	if(e.getSource() == btnRegistration){
//		 new NewRegistration().setVisible(true);
//	 
//	}
//	        if (e.getSource() == btnCancel) {
//	            System.exit(0);
//	        }//if closed
//	    }//actionPerformed() closed
//		
//		 public static void main(String args[]) throws SQLException    {
//		        new Login().setVisible(true);
//		        GetTableName table=new GetTableName();
//		       table.GetTableNameFromDb();
//		    }
//	}
//
