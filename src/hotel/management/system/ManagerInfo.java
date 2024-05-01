
package hotel.management.system;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.*;


public class ManagerInfo extends JFrame implements ActionListener{

    JTable t1;
    JButton bcancel;
    
    ManagerInfo()  {
        
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        
     
        
        JLabel text = new JLabel("Manager Details");
        text.setFont(new Font("Raleway",Font.BOLD,30));
        text.setBounds(380,0,350,50);
        add(text);
        
        JLabel l1 = new JLabel("Name");
        l1.setBounds(0,70,100,20);
        add(l1);
        
        JLabel l2 = new JLabel("Age");
        l2.setBounds(130,70,100,20);
        add(l2);
        
        JLabel l3 = new JLabel("Gender");
        l3.setBounds(260,70,100,20);
        add(l3);
        
        JLabel l4 = new JLabel("Job");
        l4.setBounds(390,70,100,20);
        add(l4);
        
        JLabel l5 = new JLabel("Salary");
        l5.setBounds(520,70,100,20);
        add(l5);
        
        JLabel l6 = new JLabel("Phone No");
        l6.setBounds(650,70,100,20);
        add(l6);
        
        JLabel l7 = new JLabel("Email");
        l7.setBounds(780,70,100,20);
        add(l7);
        
        JLabel l8 = new JLabel("Aadhar No");
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
            ResultSet rs = conn.s.executeQuery("select* from employee where job='Manager'");
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
        new ManagerInfo();
    }
    
    
}
