
package hotel.management.system;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class UpdateRoom extends JFrame implements ActionListener{

    Choice ccustomer;
    JTextField tfroom,tfavailable,tfcstatus;
    JButton bcheck,bupdate,bback;
    
       UpdateRoom() {
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel text = new JLabel("Update  Room Status");
        text.setFont(new Font("Tahoma",Font.PLAIN,20));
        text.setBounds(30,20,250,30);
        add(text);
        
        JLabel lid = new JLabel("Customer Id");
        lid.setBounds(30,80,100,20);
        add(lid);
        
        ccustomer=new Choice();
        ccustomer.setBounds(200,80,170,25);
        add(ccustomer);
        
        try {
            Conn conn = new Conn();
            ResultSet rs = conn.s.executeQuery("select * from customer");
            while(rs.next()){
                ccustomer.add(rs.getString("id_no"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        JLabel lroom = new JLabel("Room Number");
        lroom.setBounds(30,130,100,20);
        add(lroom);
        
        tfroom = new JTextField();
        tfroom.setBounds(200,130,170,25);
        add(tfroom);
        
        JLabel lname = new JLabel("Availablility");
        lname.setBounds(30,180,100,20);
        add(lname);
        
        tfavailable = new JTextField();
        tfavailable.setBounds(200,180,170,25);
        add(tfavailable);
        
        JLabel lcintime = new JLabel("Cleaning Status");
        lcintime.setBounds(30,230,100,20);
        add(lcintime);
        
        tfcstatus = new JTextField();
        tfcstatus.setBounds(200,230,170,25);
        add(tfcstatus);
        
        
        
        
        bcheck = new JButton("Check");
        bcheck.setBackground(Color.BLACK);
        bcheck.setForeground(Color.WHITE);
        bcheck.setBounds(30,340,100,30);
        bcheck.addActionListener(this);
        add(bcheck);
        
        bupdate = new JButton("Update");
        bupdate.setBackground(Color.BLACK);
        bupdate.setForeground(Color.WHITE);
        bupdate.setBounds(150,340,100,30);
        bupdate.addActionListener(this);
        add(bupdate);
        
        bback = new JButton("Back");
        bback.setBackground(Color.BLACK);
        bback.setForeground(Color.WHITE);
        bback.setBounds(270,340,100,30);
        bback.addActionListener(this);
        add(bback);
        
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/updateroom.jpg"));
        Image i2 = i1.getImage().getScaledInstance(500,300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(400,50,500,300);
        add(image);
        
        
        setBounds(300,200,980,500);
        setVisible(true);
        
    }
    
         public void actionPerformed (ActionEvent ae){
        
        if(ae.getSource()==bcheck){
            
            String id = ccustomer.getSelectedItem();
            String query = "select * from customer where id_no='"+id+"'";
            
            try {
                Conn conn = new Conn();
                ResultSet rs =conn.s.executeQuery(query);
                while(rs.next()){
                    tfroom.setText(rs.getString("room_no"));     
                }
                
                ResultSet rs1 = conn.s.executeQuery("select * from room where roomnumber ='"+tfroom.getText()+"'");
                while(rs1.next()){
                    tfavailable.setText(rs1.getString("availability"));
                    tfcstatus.setText(rs1.getString("cleaning_status"));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            
        }else if(ae.getSource()==bupdate){
            String number = ccustomer.getSelectedItem();
            String room = tfroom.getText();
            String available = tfavailable.getText();
            String status = tfcstatus.getText();
            
            
            try {
                Conn conn = new Conn();
                conn.s.executeUpdate("update room set availability='"+available+"',cleaning_status='"+status+"' where roomnumber='"+room+"'");
                
                JOptionPane.showMessageDialog(null,"Data Updated Succesfully");
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
        
        new UpdateRoom();
    }
    
}
