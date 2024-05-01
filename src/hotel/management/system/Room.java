
package hotel.management.system;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.*;


public class Room extends JFrame implements ActionListener{

    JTable t1;
    JButton bcancel;
    
    Room()  {
        
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/room.jpg"));
        Image i2 = i1.getImage().getScaledInstance(600, 600,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(500,0,600,600);
        add(image);
        
        JLabel text = new JLabel("Room Details");
        text.setFont(new Font("Raleway",Font.BOLD,30));
        text.setBounds(130,0,350,50);
        add(text);
        
        JLabel l1 = new JLabel("Room Number");
        l1.setBounds(5,50,100,20);
        add(l1);
        
        JLabel l2 = new JLabel("Availability");
        l2.setBounds(107,50,100,20);
        add(l2);
        
        JLabel l3 = new JLabel("Status");
        l3.setBounds(207,50,100,20);
        add(l3);
        
        JLabel l4 = new JLabel("Price");
        l4.setBounds(307,50,100,20);
        add(l4);
        
        JLabel l5 = new JLabel("Bed Type");
        l5.setBounds(407,50,100,20);
        add(l5);
        
        t1 = new JTable();
        t1.setBounds(0,80,500,400);
        add(t1);
        
        
        bcancel = new JButton("Back");
        bcancel.setBounds(200,500,120,30);
        bcancel.setBackground(Color.BLACK);
        bcancel.setForeground(Color.WHITE);
        add(bcancel);
        bcancel.addActionListener(this);
        
        
        
        try {
            
            Conn conn = new Conn();
            ResultSet rs = conn.s.executeQuery("select* from room");
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
        new Room();
    }
    
    
}
