
package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Reception extends JFrame implements  ActionListener{

    JButton back,newcustomer,rooms,allemp,cinfo,minfo,checkout,updatestatus,updateroomstatus,pickup,searchroom,logout; 
    
    Reception(){
        
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        
        
        
        newcustomer = new JButton("New Customer Form");
        newcustomer.setBounds(10,30,200,30);
        newcustomer.setBackground(Color.BLACK);
        newcustomer.setForeground(Color.WHITE);
        newcustomer.addActionListener(this);
        add(newcustomer);
        
        rooms = new JButton("Rooms");
        rooms.setBounds(10,70,200,30);
        rooms.setBackground(Color.BLACK);
        rooms.setForeground(Color.WHITE);
        rooms.addActionListener(this);
        add(rooms);
        
        
        
        allemp = new JButton("All Employees");
        allemp.setBounds(10,110,200,30);
        allemp.setBackground(Color.BLACK);
        allemp.setForeground(Color.WHITE);
        allemp.addActionListener(this);
        add(allemp);
        
        cinfo = new JButton("Customer Info");
        cinfo.setBounds(10,150,200,30);
        cinfo.setBackground(Color.BLACK);
        cinfo.setForeground(Color.WHITE);
        cinfo.addActionListener(this);
        add(cinfo);
        
        minfo = new JButton("Manager Info");
        minfo.setBounds(10,190,200,30);
        minfo.setBackground(Color.BLACK);
        minfo.setForeground(Color.WHITE);
        minfo.addActionListener(this);
        add(minfo);
        
        checkout = new JButton("Checkout");
        checkout.setBounds(10,230,200,30);
        checkout.setBackground(Color.BLACK);
        checkout.setForeground(Color.WHITE);
        checkout.addActionListener(this);
        add(checkout);
        
        updatestatus = new JButton("Update Status");
        updatestatus.setBounds(10,270,200,30);
        updatestatus.setBackground(Color.BLACK);
        updatestatus.setForeground(Color.WHITE);
        updatestatus.addActionListener(this);
        add(updatestatus);
        
        updateroomstatus = new JButton("Update Room Status");
        updateroomstatus.setBounds(10,310,200,30);
        updateroomstatus.setBackground(Color.BLACK);
        updateroomstatus.setForeground(Color.WHITE);
        updateroomstatus.addActionListener(this);
        add(updateroomstatus);
        
        pickup = new JButton("Pickup Service");
        pickup.setBounds(10,350,200,30);
        pickup.setBackground(Color.BLACK);
        pickup.setForeground(Color.WHITE);
        pickup.addActionListener(this);
        add(pickup);
        
        searchroom = new JButton("Search Room");
        searchroom.setBounds(10,390,200,30);
        searchroom.setBackground(Color.BLACK);
        searchroom.setForeground(Color.WHITE);
        searchroom.addActionListener(this);
        add(searchroom);
        
        logout = new JButton("Logout");
        logout.setBounds(10,430,200,30);
        logout.setBackground(Color.BLACK);
        logout.setForeground(Color.WHITE);
        logout.addActionListener(this);
        add(logout);
        
       
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/reception.jpg"));
        Image i2 = i1.getImage().getScaledInstance(500, 470,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(250,30,500,470);
        add(image);
        
        setBounds(350,200,800,570);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        
        if(ae.getSource()==newcustomer){
            setVisible(false);
            new AddCustomer();
        }
        
        else if(ae.getSource()==rooms){
            setVisible(false);
            new Room();
        }
        
        else if(ae.getSource()==allemp){
            setVisible(false);
            new EmployeeInfo();
        }
        
        else if(ae.getSource()==minfo){
            setVisible(false);
            new ManagerInfo();
        }
        
        else if(ae.getSource()==cinfo){
            setVisible(false);
            new CustomerInfo();
        }
        
        else if(ae.getSource()==searchroom){
            setVisible(false);
            new SearchRoom();
        }
        
        else if (ae.getSource()==updatestatus){
            setVisible(false);
            new UpdateCheck();
        }
        
        else if (ae.getSource()==updateroomstatus){
            setVisible(false);
            new UpdateRoom();
        }
        
        else if(ae.getSource()==pickup){
            setVisible(false);
            new Pickup();
        }
        
        else if(ae.getSource()==checkout){
            setVisible(false);
            new Checkout();
        }
        
        else if(ae.getSource()==logout){
            setVisible(false);
        }
        
        
        
        
        
            
        
        
    }
    
    public static void main(String[] args) {
        new Reception();
        
    }
    
}
