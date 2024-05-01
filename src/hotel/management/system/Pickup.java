
package hotel.management.system;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.*;


public class Pickup extends JFrame implements ActionListener{

    
    JTable t1;
    JButton bcancel,bsumbit;
    Choice typeofcar;
    JCheckBox available;
    
    
    public Pickup() {
        
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
       
        
        JLabel text = new JLabel("Pickup Service");
        text.setFont(new Font("Raleway",Font.BOLD,30));
        text.setBounds(380,0,350,50);
        add(text);
        
        JLabel lbedtype=new JLabel("Car Model");
        lbedtype.setBounds(50,100,100,20);
        add(lbedtype);
        
        typeofcar = new Choice();
        typeofcar.setBounds(150,100,200,25);
        add(typeofcar);
        
        try {
            Conn conn = new Conn();
            ResultSet rs =conn.s.executeQuery("select * from driver");
            while(rs.next()){
                typeofcar.add(rs.getString("company"));
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        
        
        
        JLabel l1 = new JLabel("Name");
        l1.setBounds(37,150,100,20);
        add(l1);
        
        JLabel l2 = new JLabel("Age");
        l2.setBounds(207,150,100,20);
        add(l2);
        
        JLabel l3 = new JLabel("Gender");
        l3.setBounds(330,150,100,20);
        add(l3);
        
        JLabel l4 = new JLabel("Car Company");
        l4.setBounds(460,150,100,20);
        add(l4);
        
        JLabel l5 = new JLabel("Car Model");
        l5.setBounds(630,150,100,20);
        add(l5);
        
        JLabel l6 = new JLabel("Availability");
        l6.setBounds(740,150,100,20);
        add(l6);
        
        JLabel l7 = new JLabel("Location");
        l7.setBounds(890,150,100,20);
        add(l7);
        
        t1 = new JTable();
        t1.setBounds(0,180,1000,300);
        add(t1);
        
        try {
            Conn conn = new Conn();
            ResultSet rs = conn.s.executeQuery("Select * from driver");
            t1.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        
        
        bcancel = new JButton("Back");
        bcancel.setBounds(600,500,120,30);
        bcancel.setBackground(Color.BLACK);
        bcancel.setForeground(Color.WHITE);
        add(bcancel);
        bcancel.addActionListener(this);
        
        
        bsumbit = new JButton("Submit");
        bsumbit.setBounds(280,500,120,30);
        bsumbit.setBackground(Color.BLACK);
        bsumbit.setForeground(Color.WHITE);
        add(bsumbit);
        bsumbit.addActionListener(this);
        
        setBounds(300,200,1000,600);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        
        
        if(ae.getSource()== bsumbit){
            
            try {
                
                Conn conn = new Conn();
                ResultSet rs;
                
                String query="select * from driver where company='"+typeofcar.getSelectedItem()+"'";
                
                
                    rs = conn.s.executeQuery(query);
                t1.setModel(DbUtils.resultSetToTableModel(rs));
               
            } catch (Exception e) {
                e.printStackTrace();
            }
        
    }
        
        else if(ae.getSource()==bcancel){
            setVisible(false);
        new Reception();
        }
    }

    
    public static void main(String[] args) {
        new Pickup();
    }
    
}
