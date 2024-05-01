
package hotel.management.system;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.sql.*;
import java.util.Date;


public class AddCustomer extends JFrame implements ActionListener{
    
    JComboBox cbid;
    JTextField tfidno,tfname,tfcountry,tfdeposit;
    JRadioButton rmale,rfemale;
    Choice croomno;
    JLabel checkintime;
    JButton baddcustomer,bcancel;

    public AddCustomer(){
        
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        
        
        JLabel text = new JLabel("New Customer Form");
        text.setFont(new Font("Raleway",Font.BOLD,30));
        text.setBounds(100,20,300,30);
        add(text);
        
        
        JLabel lid = new JLabel("ID");
        lid.setFont(new Font("Tahoma",Font.PLAIN,16));
        lid.setBounds(35,80,100,20);
        add(lid);
        
        String[] str={"Aadhar Card","Passport","Voter Id","Driving License"};
        cbid=new JComboBox(str);
        cbid.setBounds(200,80,150,30);
        cbid.setBackground(Color.WHITE);
        add(cbid);
        
        
        JLabel lidno = new JLabel("ID Number");
        lidno.setFont(new Font("Tahoma",Font.PLAIN,16));
        lidno.setBounds(35,130,120,30);
        add(lidno);
        
        tfidno = new JTextField();
        tfidno.setBounds(200,130,150,30);
        add(tfidno);
        
        
        JLabel lname = new JLabel("Name");
        lname.setFont(new Font("Tahoma",Font.PLAIN,16));
        lname.setBounds(35,180,120,30);
        add(lname);
        
        tfname = new JTextField();
        tfname.setBounds(200,180,150,30);
        add(tfname);
        
        
        JLabel lgender = new JLabel("Gender");
        lgender.setFont(new Font("Tahoma",Font.PLAIN,16));
        lgender.setBounds(35,230,120,30);
        add(lgender);
        
        rmale = new JRadioButton("Male");
        rmale.setFont(new Font("Tahoma",Font.PLAIN,14));
        rmale.setBackground(Color.WHITE);
        rmale.setBounds(200,230,70,30);
        add(rmale);
        
        rfemale = new JRadioButton("Female");
        rfemale.setFont(new Font("Tahoma",Font.PLAIN,14));
        rfemale.setBackground(Color.WHITE);
        rfemale.setBounds(280,230,70,30);
        add(rfemale);
        
        ButtonGroup bg = new ButtonGroup();
        bg.add(rmale);
        bg.add(rfemale);
        
        
        JLabel lcountry = new JLabel("Country");
        lcountry.setFont(new Font("Tahoma",Font.PLAIN,16));
        lcountry.setBounds(35,280,120,30);
        add(lcountry);
        
        tfcountry = new JTextField();
        tfcountry.setBounds(200,280,150,30);
        add(tfcountry);
        
        
        JLabel lroomno = new JLabel("Allocated Room");
        lroomno.setFont(new Font("Tahoma",Font.PLAIN,16));
        lroomno.setBounds(35,330,120,30);
        add(lroomno);
        
        croomno = new Choice();
        
        try {
            
            Conn conn = new Conn();
            String query = "Select roomnumber from room where availability='available'";
            ResultSet rs=conn.s.executeQuery(query);
            while(rs.next()){
                croomno.add(rs.getString("roomnumber"));
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        
        croomno.setBounds(200,330,150,30);
        croomno.setBackground(Color.WHITE);
        add(croomno);
        
        
        JLabel lcintime = new JLabel("Checkin Time");
        lcintime.setFont(new Font("Tahoma",Font.PLAIN,16));
        lcintime.setBounds(35,380,120,30);
        add(lcintime);
        
        Date date= new Date();
        
        checkintime = new JLabel(""+date);
        checkintime.setFont(new Font("Tahoma",Font.PLAIN,12));
        checkintime.setBounds(200,380,150,30);
        add(checkintime);
        
        
        JLabel ldeposit = new JLabel("Deposit");
        ldeposit.setFont(new Font("Tahoma",Font.PLAIN,16));
        ldeposit.setBounds(35,430,120,30);
        add(ldeposit);
        
        tfdeposit = new JTextField();
        tfdeposit.setBounds(200,430,150,30);
        add(tfdeposit);
        
        
        baddcustomer = new JButton("Add Customer");
        baddcustomer.setBounds(35,480,130,30);
        baddcustomer.setBackground(Color.BLACK);
        baddcustomer.setForeground(Color.WHITE);
        baddcustomer.addActionListener(this);
        add(baddcustomer);
        
        bcancel = new JButton("Cancel");
        bcancel.setBounds(200,480,130,30);
        bcancel.setBackground(Color.BLACK);
        bcancel.setForeground(Color.WHITE);
        add(bcancel);
        bcancel.addActionListener(this);
        
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/addcustomer.png"));
        Image i2 = i1.getImage().getScaledInstance(400, 400,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(400,50,400,400);
        add(image);
        
        setBounds(320,200,870,560);
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae){
        
        if(ae.getSource()==baddcustomer){
           
            String id =(String) cbid.getSelectedItem();
            String idnumber = tfidno.getText();
            String name = tfname.getText();
            String gender=null;
            if(rmale.isSelected()){
                gender="Male";
            }else if(rfemale.isSelected()){
                gender="Female";
            }
            String country = tfcountry.getText();
            String roomno=croomno.getSelectedItem();
            String time =checkintime.getText();
            String deposit=tfdeposit.getText();
            
            
            try {
                
                Conn conn = new Conn();
                
                String query1 = "insert into customer values('"+id+"','"+idnumber+"','"+name+"','"+gender+"','"+country+"','"+roomno+"','"+time+"','"+deposit+"')";
                String query2 = "update room set availability = 'occupied' where roomnumber = '"+roomno+"'";
                
                conn.s.executeUpdate(query1);
                conn.s.executeUpdate(query2);
                
                JOptionPane.showMessageDialog(null,"New Customer Added Succesfully");
                setVisible(false);
                new Reception();
                
                
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
       new AddCustomer();
    }
}
