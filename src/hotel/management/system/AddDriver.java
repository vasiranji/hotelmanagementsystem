
package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class AddDriver extends JFrame implements ActionListener{

    JButton badddriver,bcancel;
    JTextField tfname,tfage,tfcompany,tfmodel,tflocation;
    JComboBox cbdriveravail;
    JRadioButton rmale,rfemale;
    
    AddDriver() {
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel laddroom = new JLabel("Add Driver");
        laddroom.setFont(new Font("Raleway",Font.BOLD,30));
        laddroom.setBounds(150,20,200,35);
        add(laddroom);
        
        
        
        
        JLabel lname = new JLabel("Name");
        lname.setFont(new Font("Tahoma",Font.PLAIN,16));
        lname.setBounds(60,80,120,30);
        add(lname);
        
        tfname = new JTextField();
        tfname.setBounds(200,80,150,30);
        add(tfname);
        
        
        JLabel lage = new JLabel("Age");
        lage.setFont(new Font("Tahoma",Font.PLAIN,16));
        lage.setBounds(60,130,120,30);
        add(lage);
        
        tfage = new JTextField();
        tfage.setBounds(200,130,150,30);
        add(tfage);
        
        
        JLabel lgender = new JLabel("Gender");
        lgender.setFont(new Font("Tahoma",Font.PLAIN,16));
        lgender.setBounds(60,180,120,30);
        add(lgender);
        
        rmale = new JRadioButton("Male");
        rmale.setFont(new Font("Tahoma",Font.PLAIN,14));
        rmale.setBackground(Color.WHITE);
        rmale.setBounds(200,180,70,30);
        add(rmale);
        
        rfemale = new JRadioButton("Female");
        rfemale.setFont(new Font("Tahoma",Font.PLAIN,14));
        rfemale.setBackground(Color.WHITE);
        rfemale.setBounds(280,180,70,30);
        add(rfemale);
        
        ButtonGroup bg = new ButtonGroup();
        bg.add(rmale);
        bg.add(rfemale);
        
        
        JLabel lcompany = new JLabel("Car Company");
        lcompany.setFont(new Font("Tahoma",Font.PLAIN,16));
        lcompany.setBounds(60,230,120,30);
        add(lcompany);
        
        tfcompany= new JTextField();
        tfcompany.setBounds(200,230,150,30);
        add(tfcompany);
        
        
        JLabel lmodel = new JLabel("Car Model");
        lmodel.setFont(new Font("Tahoma",Font.PLAIN,16));
        lmodel.setBounds(60,280,120,30);
        add(lmodel);
        
        
        tfmodel= new JTextField();
        tfmodel.setBounds(200,280,152,30);
        add(tfmodel);
        
        
        JLabel ldriveravail = new JLabel("Availablility");
        ldriveravail.setFont(new Font("Tahoma",Font.PLAIN,16));
        ldriveravail.setBounds(60,330,120,30);
        add(ldriveravail);
        
        String[] str ={"Available","Busy"};
        cbdriveravail = new JComboBox(str);
        cbdriveravail.setBounds(200,330,150,30);
        cbdriveravail.setBackground(Color.WHITE);
        add(cbdriveravail);
        
        
        JLabel llocation = new JLabel("Location");
        llocation.setFont(new Font("Tahoma",Font.PLAIN,16));
        llocation.setBounds(60,380,120,30);
        add(llocation);
        
        
        tflocation= new JTextField();
        tflocation.setBounds(200,380,152,30);
        add(tflocation);
        
        
        badddriver = new JButton("Add Driver");
        badddriver.setBounds(60,450,130,30);
        badddriver.setBackground(Color.BLACK);
        badddriver.setForeground(Color.WHITE);
        badddriver.addActionListener(this);
        add(badddriver);
        
        bcancel = new JButton("Cancel");
        bcancel.setBounds(220,450,130,30);
        bcancel.setBackground(Color.BLACK);
        bcancel.setForeground(Color.WHITE);
        add(bcancel);
        bcancel.addActionListener(this);
        
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/adddriver.jpg"));
        Image i2 = i1.getImage().getScaledInstance(400,300,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(400,100,400,300);
        add(image);
        
        
        setBounds(340,220,850,540);
        setVisible(true);
    }
    
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==badddriver){
            String name = tfname.getText();
            String age = tfage.getText();
            String gender=null;
            if(rmale.isSelected()){
                gender="Male";
            }else if(rfemale.isSelected()){
                gender="Female";
            }
            String company=tfcompany.getText();
            String model=tfmodel.getText();
            String availability=(String) cbdriveravail.getSelectedItem();
            String location=tflocation.getText();
        
        
            
            
            
            try {
                Conn conn = new Conn();
                String str ="insert into driver values('"+name+"','"+age+"','"+gender+"','"+company+"','"+model+"','"+availability+"','"+location+"')";
                
                
                conn.s.executeUpdate(str);
                
                JOptionPane.showMessageDialog(null,"Driver Added Successfully");
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
        new AddDriver();
    }
    
}
