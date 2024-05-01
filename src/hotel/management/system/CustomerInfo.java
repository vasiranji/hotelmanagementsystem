
package hotel.management.system;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.*;


public class CustomerInfo extends JFrame implements ActionListener{

    JTable t1;
    JButton bcancel;
    
    CustomerInfo()  {
        
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        
     
        
        JLabel text = new JLabel("Customer Details");
        text.setFont(new Font("Raleway",Font.BOLD,30));
        text.setBounds(380,0,350,50);
        add(text);
        
        JLabel l1 = new JLabel("Id Type");
        l1.setBounds(0,70,100,20);
        add(l1);
        
        JLabel l2 = new JLabel("Id Number");
        l2.setBounds(137,70,100,20);
        add(l2);
        
        JLabel l3 = new JLabel("Name");
        l3.setBounds(267,70,100,20);
        add(l3);
        
        JLabel l4 = new JLabel("Gender");
        l4.setBounds(397,70,100,20);
        add(l4);
        
        JLabel l5 = new JLabel("Country");
        l5.setBounds(527,70,100,20);
        add(l5);
        
        JLabel l6 = new JLabel("Room No");
        l6.setBounds(657,70,100,20);
        add(l6);
        
        JLabel l7 = new JLabel("Checkin Time");
        l7.setBounds(787,70,100,20);
        add(l7);
        
        JLabel l8 = new JLabel("Deposit");
        l8.setBounds(920,70,100,20);
        add(l8);
        
        t1 = new JTable();
        t1.setBounds(0,100,1040,400);
        add(t1);
        
        
        bcancel = new JButton("Back");
        bcancel.setBounds(450,500,120,30);
        bcancel.setBackground(Color.BLACK);
        bcancel.setForeground(Color.WHITE);
        add(bcancel);
        bcancel.addActionListener(this);
        
        
        
        try {
            
            Conn conn = new Conn();
            ResultSet rs = conn.s.executeQuery("select* from customer");
            t1.setModel(DbUtils.resultSetToTableModel(rs));
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        
        setBounds(300,200,1050,600);
        setVisible(true);
        
        
    }
    
    
    public void actionPerformed(ActionEvent ae){
        
        setVisible(false);
        new Reception();
    }

    public static void main(String[] args) {
        new CustomerInfo();
    }
    
    
}
