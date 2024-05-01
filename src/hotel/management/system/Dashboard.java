
package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class Dashboard extends JFrame implements ActionListener{

    Dashboard() {
        setBounds(0,0,1550,1000);
        
        setLayout(null);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/dashboard.jpg"));
        Image i2=i1.getImage().getScaledInstance(1550,1000,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,1550,1000);
        add(image);
        
        JLabel text = new JLabel("The Vasishta Group Welcomes You");
        text.setBounds(250,80,1000,90);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("Tahoma",Font.PLAIN,65));
        image.add(text);
        
        JMenuBar menu=new JMenuBar();
        menu.setBounds(0,0,1550,30);
        image.add(menu);
        
        JMenu hotel = new JMenu("HOTEL MANAGEMENT");
        hotel.setForeground(Color.BLUE);
        menu.add(hotel);
        
        JMenuItem reception = new JMenuItem("RECEPTION");
        reception.setBackground(Color.BLACK);
        reception.setForeground(Color.WHITE);
        reception.addActionListener(this);
        hotel.add(reception);
        
        
        JMenu admin = new JMenu("ADMIN");
        admin.setForeground(Color.RED);
        menu.add(admin);
        
        JMenuItem addemployee= new JMenuItem("ADD EMPLOYEE");
        addemployee.setBackground(Color.BLACK);
        addemployee.setForeground(Color.WHITE);
        addemployee.addActionListener(this);
        admin.add(addemployee);
        
        JMenuItem addrooms= new JMenuItem("ADD ROOMS");
        addrooms.setBackground(Color.BLACK);
        addrooms.setForeground(Color.WHITE);
        addrooms.addActionListener(this);
        admin.add(addrooms);
        
        JMenuItem adddrivers= new JMenuItem("ADD DRIVERS");
        adddrivers.setBackground(Color.BLACK);
        adddrivers.setForeground(Color.WHITE);
        adddrivers.addActionListener(this);
        admin.add(adddrivers);
        
        
        
        
        
        
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getActionCommand().equals("ADD EMPLOYEE")){
            new AddEmployee();
        }else if(ae.getActionCommand().equals("ADD ROOMS")){
            new AddRooms();
        }else if(ae.getActionCommand().equals("ADD DRIVERS")){
            new AddDriver();
        }else if(ae.getActionCommand().equals("RECEPTION")){
            new Reception();
        }
    }
    
    public static void main(String[] args) {
        new Dashboard();
    }
    
}
