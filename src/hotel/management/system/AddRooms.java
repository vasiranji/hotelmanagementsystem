
package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class AddRooms extends JFrame implements ActionListener{

    JButton baddroom,bcancel;
    JTextField tfroomno,tfroomprice;
    JComboBox cbroomavail,cbcleanstat,cbbedtype;
    
    AddRooms() {
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel laddroom = new JLabel("Add Rooms");
        laddroom.setFont(new Font("Raleway",Font.BOLD,30));
        laddroom.setBounds(150,20,200,40);
        add(laddroom);
        
        
        
        
        JLabel lroomno = new JLabel("Room Number");
        lroomno.setFont(new Font("Tahoma",Font.PLAIN,16));
        lroomno.setBounds(60,80,120,30);
        add(lroomno);
        
        tfroomno = new JTextField();
        tfroomno.setBounds(200,80,150,30);
        add(tfroomno);
        
        
        JLabel lroomavail = new JLabel("Room Available");
        lroomavail.setFont(new Font("Tahoma",Font.PLAIN,16));
        lroomavail.setBounds(60,130,120,30);
        add(lroomavail);
        
        String[] str ={"Available","Occupied"};
        cbroomavail = new JComboBox(str);
        cbroomavail.setBounds(200,130,150,30);
        cbroomavail.setBackground(Color.WHITE);
        add(cbroomavail);
        
        
        JLabel lcleaningstat = new JLabel("Cleaning Status");
        lcleaningstat.setFont(new Font("Tahoma",Font.PLAIN,16));
        lcleaningstat.setBounds(60,180,120,30);
        add(lcleaningstat);
        
        String[] str1={"Clean","Dirty"};
        cbcleanstat = new JComboBox(str1);
        cbcleanstat.setBounds(200,180,150,30);
        cbcleanstat.setBackground(Color.WHITE);
        add(cbcleanstat);
        
        
        JLabel lroomprice = new JLabel("Room Price");
        lroomprice.setFont(new Font("Tahoma",Font.PLAIN,16));
        lroomprice.setBounds(60,230,120,30);
        add(lroomprice);
        
        tfroomprice= new JTextField();
        tfroomprice.setBounds(200,230,150,30);
        add(tfroomprice);
        
        
        JLabel lbedtype = new JLabel("Bed Type");
        lbedtype.setFont(new Font("Tahoma",Font.PLAIN,16));
        lbedtype.setBounds(60,280,120,30);
        add(lbedtype);
        
        String[] str2={"Single Bed","Double Bed"};
        cbbedtype = new JComboBox(str2);
        cbbedtype.setBounds(200,280,150,30);
        cbbedtype.setBackground(Color.WHITE);
        add(cbbedtype);
        
        
        baddroom = new JButton("Add Room");
        baddroom.setBounds(60,380,130,30);
        baddroom.setBackground(Color.BLACK);
        baddroom.setForeground(Color.WHITE);
        baddroom.addActionListener(this);
        add(baddroom);
        
        bcancel = new JButton("Cancel");
        bcancel.setBounds(220,380,130,30);
        bcancel.setBackground(Color.BLACK);
        bcancel.setForeground(Color.WHITE);
        add(bcancel);
        bcancel.addActionListener(this);
        
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/addrooms.jpg"));
        Image i2 = i1.getImage().getScaledInstance(400, 300,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(400,80,400,300);
        add(image);
        
        
        setBounds(340,220,850,540);
        setVisible(true);
    }
    
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==baddroom){
            String roomnumber=tfroomno.getText();
            String availability=(String)cbroomavail.getSelectedItem();
            String status =(String)cbcleanstat.getSelectedItem();
            String price = tfroomprice.getText();
            String type =(String)cbbedtype.getSelectedItem();
            
            
            try {
                Conn conn = new Conn();
                String str ="insert into room values('"+roomnumber+"','"+availability+"','"+status+"','"+price+"','"+type+"')";
                
                
                conn.s.executeUpdate(str);
                
                JOptionPane.showMessageDialog(null,"Room Added Successfully");
                setVisible(false);
                
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else if(ae.getSource()==bcancel){
            setVisible(false);
        }
    }
    
    public static void main(String[] args) {
        new AddRooms();
    }
    
}
