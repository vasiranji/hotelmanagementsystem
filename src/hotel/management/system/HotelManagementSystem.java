
package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class HotelManagementSystem extends JFrame implements ActionListener{
    
    HotelManagementSystem(){
        setBounds(0,0,1550,1000);
        setLayout(null);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/home.jpg"));
        JLabel image=new JLabel(i1);
        image.setBounds(0,0,1550,1000);
        add(image);
        
        JLabel text = new JLabel("VASISHTA HOTELS");
        text.setBounds(20,630,1000,90);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("serif",Font.PLAIN,70));
        image.add(text);
        
        JButton login = new JButton("Login");
        login.setBounds(1150,660,150,50);
        login.setBackground(Color.WHITE);
        login.addActionListener(this);
        login.setFont(new Font("serif",Font.PLAIN,20));
        image.add(login);
        
        setVisible(true);
        
        while (true){
            text.setVisible(false);
            try {
                Thread.sleep(500);
            } catch (Exception e) {
                e.printStackTrace();
            }
            text.setVisible(true);
             try {
                Thread.sleep(500);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }            
            
        
    }
    
    public void actionPerformed(ActionEvent ae){
        setVisible(false);
        new Login();
    }

    public static void main(String[] args) {
        new HotelManagementSystem();
    }
    
}
