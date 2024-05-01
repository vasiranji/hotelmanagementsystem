
package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;

public class Checkout extends JFrame implements ActionListener{
    
    Choice ccustomer;
    JLabel lroomno,lcheckintime,lcheckouttime;
    JButton bcheckout,bback;

     Checkout() {
         
         setLayout(null);
         getContentPane().setBackground(Color.WHITE);
         
         JLabel text = new JLabel("Checkout");
         text.setBounds(100,20,100,30);
         text.setFont(new Font("Tahoma",Font.PLAIN,20));
         add(text);
         
         
         JLabel lid = new JLabel("Customer Id");
         lid.setBounds(30,80,100,30);
         add(lid);
         
         ccustomer=new Choice();
        ccustomer.setBounds(150,85,180,25);
        add(ccustomer);
        
        
         
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/checkout.png"));
        Image i2 = i1.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(340,85,20,20);
        add(image);
        
        JLabel lroom = new JLabel("Room Number");
        lroom.setBounds(30,130,100,30);
        add(lroom);
        
        lroomno = new JLabel("");
        lroomno.setBounds(150,130,180,30);
        add(lroomno);
        
        JLabel lcheckin = new JLabel("Checkin Time ");
        lcheckin.setBounds(30,180,100,30);
        add(lcheckin);
        
        lcheckintime = new JLabel("");
        lcheckintime.setBounds(150,180,180,30);
        add(lcheckintime);
        
        JLabel lcheckout = new JLabel("Checkout Time ");
        lcheckout.setBounds(30,230,100,30);
        add(lcheckout);
        
        
        Date date = new Date();
        
        lcheckouttime = new JLabel(""+date);
        lcheckouttime.setBounds(150,230,180,30);
        add(lcheckouttime);
        
       
        
        bcheckout = new JButton("Checkout");
        bcheckout.setBounds(30,280,120,30);
        bcheckout.setBackground(Color.BLACK);
        bcheckout.setForeground(Color.WHITE);
        bcheckout.addActionListener(this);
        add(bcheckout);
        
        bback = new JButton("Back");
        bback.setBounds(170,280,120,30);
        bback.setBackground(Color.BLACK);
        bback.setForeground(Color.WHITE);
        add(bback);
        bback.addActionListener(this);
        
         try {
            Conn conn = new Conn();
            ResultSet rs = conn.s.executeQuery("select * from customer");
            while(rs.next()){
                ccustomer.add(rs.getString("id_no"));
                lroomno.setText(rs.getString("room_no"));
                lcheckintime.setText(rs.getString("checkin_time"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icons/checkout1.jpg"));
        Image i5 = i4.getImage().getScaledInstance(400,250,Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);
        JLabel image1 = new JLabel(i6);
        image1.setBounds(370,60,400,250);
        add(image1);
         
         setBounds(300,200,800,400);
         setVisible(true);
         
    }
     
     public void actionPerformed(ActionEvent ae){
         if(ae.getSource()==bcheckout){
             
             String query="delete from customer where id_no='"+ccustomer.getSelectedItem()+"'";
             String query1="update room set availability='Available' where roomnumber='"+lroomno.getText()+"'";
             
             try {
                 Conn conn = new Conn();
                 conn.s.executeUpdate(query);
                 conn.s.executeUpdate(query1);
                 
                 JOptionPane.showMessageDialog(null, "Checkout Done");
                 
                 setVisible(false);
                 new Reception();
                 
             } catch (Exception e) {
                 e.printStackTrace();
             }
         }else if(ae.getSource()==bback){
             setVisible(false);
             new Reception();
         }
     }
    
    public static void main(String[] args) {
        new Checkout();
    }
    
}
