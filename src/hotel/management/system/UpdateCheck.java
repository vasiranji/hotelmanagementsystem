
package hotel.management.system;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class UpdateCheck extends JFrame implements ActionListener{

    Choice ccustomer;
    JTextField tfroom,tfname,tfcintime,tfdeposit,tfpending;
    JButton bcheck,bupdate,bback;
    
       UpdateCheck() {
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel text = new JLabel("Update Status");
        text.setFont(new Font("Tahoma",Font.PLAIN,20));
        text.setBounds(90,20,200,30);
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
        lroom.setBounds(30,120,100,20);
        add(lroom);
        
        tfroom = new JTextField();
        tfroom.setBounds(200,120,170,25);
        add(tfroom);
        
        JLabel lname = new JLabel("Name");
        lname.setBounds(30,160,100,20);
        add(lname);
        
        tfname = new JTextField();
        tfname.setBounds(200,160,170,25);
        add(tfname);
        
        JLabel lcintime = new JLabel("Check In Time");
        lcintime.setBounds(30,200,100,20);
        add(lcintime);
        
        tfcintime = new JTextField();
        tfcintime.setBounds(200,200,170,25);
        add(tfcintime);
        
        
        JLabel ldeposit = new JLabel("Deposit Amount");
        ldeposit.setBounds(30,240,100,20);
        add(ldeposit);
        
        tfdeposit = new JTextField();
        tfdeposit.setBounds(200,240,170,25);
        add(tfdeposit);
        
        
        JLabel lpending = new JLabel("Pending Amount");
        lpending.setBounds(30,280,100,20);
        add(lpending);
        
        tfpending = new JTextField();
        tfpending.setBounds(200,280,170,25);
        add(tfpending);
        
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
        
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/updatecheck.jpg"));
        JLabel image = new JLabel(i1);
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
                    tfname.setText(rs.getString("name"));
                    tfcintime.setText(rs.getString("checkin_time"));
                    tfdeposit.setText(rs.getString("deposit"));
                }
                
                ResultSet rs1 = conn.s.executeQuery("select * from room where roomnumber ='"+tfroom.getText()+"'");
                while(rs1.next()){
                    String price=rs1.getString("price");
                    int deposit = Integer.parseInt(price)-Integer.parseInt(tfdeposit.getText());
                    tfpending.setText(""+deposit);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            
        }else if(ae.getSource()==bupdate){
            String number = ccustomer.getSelectedItem();
            String room = tfroom.getText();
            String name = tfname.getText();
            String checkin = tfcintime.getText();
            String deposit = tfdeposit.getText();
            
            try {
                Conn conn = new Conn();
                conn.s.executeUpdate("update customer set room_no ='"+room+"',name='"+name+"',checkin_time='"+checkin+"',deposit='"+deposit+"' where id_no='"+number+"'");
                
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
        
        new UpdateCheck();
    }
    
}
