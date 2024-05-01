
package hotel.management.system;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.*;


public class SearchRoom extends JFrame implements ActionListener{

    
    JTable t1;
    JButton bcancel,bsumbit;
    JComboBox cbbedtype;
    JCheckBox available;
    
    
    public SearchRoom() {
        
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
       
        
        JLabel text = new JLabel("Search for Room");
        text.setFont(new Font("Raleway",Font.BOLD,30));
        text.setBounds(380,0,350,50);
        add(text);
        
        JLabel lbedtype=new JLabel("Bed Type");
        lbedtype.setBounds(50,100,100,20);
        add(lbedtype);
        
        String[] str={"Single Bed","Double Bed"};
        cbbedtype = new JComboBox(str);
        cbbedtype.setBackground(Color.WHITE);
        cbbedtype.setBounds(150,100,150,25);
        add(cbbedtype);
        
        available = new JCheckBox("Display Only Available Rooms");
        available.setBounds(650,100,200,25);
        available.setBackground(Color.WHITE);
        add(available);
        
        
        JLabel l1 = new JLabel("Room Number");
        l1.setBounds(5,150,100,20);
        add(l1);
        
        JLabel l2 = new JLabel("Availability");
        l2.setBounds(207,150,100,20);
        add(l2);
        
        JLabel l3 = new JLabel("Status");
        l3.setBounds(407,150,100,20);
        add(l3);
        
        JLabel l4 = new JLabel("Price");
        l4.setBounds(607,150,100,20);
        add(l4);
        
        JLabel l5 = new JLabel("Bed Type");
        l5.setBounds(807,150,100,20);
        add(l5);
        
        t1 = new JTable();
        t1.setBounds(0,180,1000,300);
        add(t1);
        
        try {
            Conn conn = new Conn();
            ResultSet rs = conn.s.executeQuery("Select * from room");
            t1.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
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
                
                String query1="select * from room where bed_type='"+cbbedtype.getSelectedItem()+"'";
                String query2="select * from room where availability='Available' AND bed_type ='"+cbbedtype.getSelectedItem()+"'";
                
                if(available.isSelected()){
                    rs = conn.s.executeQuery(query2);
                }else{
                    rs = conn.s.executeQuery(query1);
                    
                }
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
        new SearchRoom();
    }
    
}
