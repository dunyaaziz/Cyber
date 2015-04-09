//package view;
//
//import java.awt.Color;
//import java.awt.Container;
//import java.awt.Dimension;
//import java.awt.Font;
//import java.awt.Toolkit;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.sql.ResultSet;
//import java.sql.Statement;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//
//import javax.swing.AbstractButton;
//import javax.swing.ButtonGroup;
//import javax.swing.ImageIcon;
//import javax.swing.JButton;
//import javax.swing.JFrame;
//import javax.swing.JInternalFrame;
//import javax.swing.JLabel;
//import javax.swing.JOptionPane;
//import javax.swing.JPasswordField;
//import javax.swing.JRadioButton;
//import javax.swing.JTextField;
//import javax.swing.JComboBox;
//import javax.swing.text.JTextComponent;
//
//import DAO.ConnectionDB;
// 
//public class register extends JFrame implements ActionListener 
//  { 
//    JLabel l1, l2, l4, l5, l6;
//    JTextField tf1, tf5;
//    JButton btn1, btn2;
//    JPasswordField p1, p2;
// 
//    register()
//     {
//        setVisible(true);
//        setSize(700, 700);
//        setLayout(null);
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        setTitle("Registration Form in Java");
// 
//        l1 = new JLabel("Registration Form in Windows Form:");
//        l1.setForeground(Color.blue);
//        l1.setFont(new Font("Serif", Font.BOLD, 20));
// 
//        l2 = new JLabel("Name:");
//        l4 = new JLabel("Passowrd:");
//        l5 = new JLabel("Confirm Password:");
//        l6 = new JLabel("Status:");
//
//        tf1 = new JTextField();
//        p1 = new JPasswordField();
//        p2 = new JPasswordField();
//        tf5 = new JTextField();
// 
// 
//        btn1 = new JButton("Submit");
//        btn2 = new JButton("Clear");
// 
//        btn1.addActionListener(this);
//        btn2.addActionListener(this);
// 
//        l1.setBounds(100, 30, 400, 30);
//        l2.setBounds(80, 70, 200, 30);
//        l4.setBounds(80, 152, 200, 30);
//        l5.setBounds(80, 193, 200, 30);
//        l6.setBounds(80, 111, 200, 30);
//        tf1.setBounds(300, 70, 200, 30);
//        p1.setBounds(300, 152, 200, 30);
//        p2.setBounds(300, 193, 200, 30);
//        tf5.setBounds(300, 111, 200, 30);
//
//        btn1.setBounds(143, 293, 100, 30);
//        btn2.setBounds(253, 293, 100, 30);
// 
//  add(l1);
//       add(l2);
//     add(tf1);
//
//       add(l4);
//      add(p1);
//     add(l5);
//       add(p2);
//       add(l6);
//   add(tf5);
//
//     add(btn1);
//   add(btn2);
//    }
// 
//    public void actionPerformed(ActionEvent e) 
//     {
//        if (e.getSource() == btn1)
//         {
//            int x = 0;
//            String s1 = tf1.getText();
//  
//            char[] s3 = p1.getPassword();
//            char[] s4 = p2.getPassword(); 
//            String s8 = new String(s3);
//            String s9 = new String(s4);
// 
//            String s5 = tf5.getText();
//       
//            if (s8.equals(s9))
//           {
//                try
//               {
//                	ConnectionDB mgr = ConnectionDB.getInstance();
//                	Connection con = (Connection) mgr.getConnection();
//                    Statement st = con.createStatement();   
//                    PreparedStatement ps = con.prepareStatement("insert into Userdb(username,loginstatus,password)values(?,?,?)");
//                    ps.setString(1, s1);
//                    ps.setString(2, s8);
//                    ps.setString(3, s5);
//                
//                    ResultSet rs = ps.executeQuery();
//                    x++;
//                    if (x > 0) 
//                    {
//                        JOptionPane.showMessageDialog(btn1, "Data Saved Successfully");
//                    }
//                }
//          catch (Exception ex) 
//                {
//                    System.out.println(ex);
//                }
//            }
//          else
//           {
//                JOptionPane.showMessageDialog(btn1, "Password Does Not Match");
//            } 
//        } 
//          else
//       {
//            tf1.setText("");
//            p1.setText("");
//            p2.setText("");
//            tf5.setText("");
//         
//        }
//    } 
//    public static void main(String args[])
//   {
//        new Login();
//    }
//}