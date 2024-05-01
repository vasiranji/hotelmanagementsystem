
package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class AddEmployee extends JFrame implements ActionListener{

    JTextField tfname,tfage,tfsalary,tfphone,tfemail,tfaadhar;
    JRadioButton rmale,rfemale;
    JButton submit,bcancel;
    JComboBox cbjob;
    
    public AddEmployee() {
    
        setLayout(null);
        
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/addemployee.jpg"));
        Image i2 =i1.getImage().getScaledInstance(450, 450,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        
        
        image.setBounds(380,60,450,450);
        add(image);
        
        JLabel lname =new JLabel("Name");
        lname.setBounds(60,30,120,30);
        lname.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(lname);
        
        tfname = new JTextField();
        tfname.setBounds(200,30,150,30);
        add(tfname);
        
        
        JLabel lage =new JLabel("Age");
        lage.setBounds(60,80,120,30);
        lage.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(lage);
        
        tfage = new JTextField();
        tfage.setBounds(200,80,150,30);
        add(tfage);
        
        
        JLabel lgender =new JLabel("Gender");
        lgender.setBounds(60,130,120,30);
        lgender.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(lgender);
        
         rmale = new JRadioButton("Male");
        rmale.setFont(new Font("Tahoma",Font.PLAIN,14));
        rmale.setBackground(Color.WHITE);
        rmale.setBounds(200,130,70,30);
        add(rmale);
        
         rfemale = new JRadioButton("Female");
        rfemale.setFont(new Font("Tahoma",Font.PLAIN,14));
        rfemale.setBackground(Color.WHITE);
        rfemale.setBounds(280,130,70,30);
        add(rfemale);
        
        ButtonGroup bg = new ButtonGroup();
        bg.add(rmale);
        bg.add(rfemale);
        
        
        JLabel ljob =new JLabel("Job");
        ljob.setBounds(60,180,120,30);
        ljob.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(ljob);
        
        String[] str = {"Front Desk Clerks","Porters","Housekeeping","Kitchen Staff","Room Service","Chefs","Waiter/Waitress","Manager","Accountant"};
         cbjob = new JComboBox(str);
        cbjob.setBounds(200,180,150,30);
        cbjob.setBackground(Color.WHITE);
        add(cbjob);
        
        
        
        JLabel lsalary =new JLabel("Salary");
        lsalary.setBounds(60,230,120,30);
        lsalary.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(lsalary);
        
         tfsalary = new JTextField();
        tfsalary.setBounds(200,230,150,30);
        add(tfsalary);
        
        
        JLabel lPhone =new JLabel("Phone");
        lPhone.setBounds(60,280,120,30);
        lPhone.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(lPhone);
        
        tfphone = new JTextField();
        tfphone.setBounds(200,280,150,30);
        add(tfphone);
        
        
        
        JLabel lemail =new JLabel("Email");
        lemail.setBounds(60,330,120,30);
        lemail.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(lemail);
        
        tfemail = new JTextField();
        tfemail.setBounds(200,330,150,30);
        add(tfemail);
        
        
        JLabel laadhar =new JLabel("Aadhar");
        laadhar.setBounds(60,380,120,30);
        laadhar.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(laadhar);
        
        tfaadhar = new JTextField();
        tfaadhar.setBounds(200,380,150,30);
        add(tfaadhar);
        
         submit = new JButton("SUBMIT");
        submit.setBounds(60,450,130,30);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setFont(new Font("Tahoma",Font.PLAIN,17));
        submit.addActionListener(this);
        add(submit);
        
        
        bcancel = new JButton("CANCEL");
        bcancel.setBounds(220,450,130,30);
        bcancel.setBackground(Color.BLACK);
        bcancel.setForeground(Color.WHITE);
        bcancel.setFont(new Font("Tahoma",Font.PLAIN,17));
        bcancel.addActionListener(this);
        add(bcancel);
        
        
                
                
        getContentPane().setBackground(Color.WHITE);
        setBounds(340,220,850,540);
        setVisible(true);
    }
    
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==submit){
            
            String name =tfname.getText();
        String age =tfage.getText();
        String salary=tfsalary.getText();
        String phone =tfphone.getText();
        String email=tfemail.getText();
        String aadhar=tfaadhar.getText();
        
        String gender=null;
        if(rmale.isSelected()){
            gender="Male";
        }else if(rfemale.isSelected()){
            gender="Female";
        }
        
        String job =(String)cbjob.getSelectedItem();
        
        
        
        try {
            
            Conn conn = new Conn();
            
            String query ="insert into employee values('"+name+"','"+age+"','"+gender+"','"+job+"','"+salary+"','"+phone+"','"+email+"','"+aadhar+"')";
            
            conn.s.executeUpdate(query);
            
            JOptionPane.showMessageDialog(null,"Employee added succesfully");
           
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
        new AddEmployee();
    }
    
}
