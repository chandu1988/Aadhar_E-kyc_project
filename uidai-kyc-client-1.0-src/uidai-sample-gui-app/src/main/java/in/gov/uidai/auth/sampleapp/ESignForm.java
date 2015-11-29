package in.gov.uidai.auth.sampleapp;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
 
public class ESignForm extends JFrame implements ActionListener
{
    JLabel l1, l2, l3;
    JTextField tf1;
    JButton btn1;
    JButton btn2;
    JPasswordField p1;
 
    ESignForm()
    {
        setTitle("Request for ESign");
        setVisible(true);
        setSize(1200, 1200);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(new JLabel(new ImageIcon("C:\\Users\\Ujjwal\\Downloads\\heroes_vs_hackers_logo.jpg")));
 
        l1 = new JLabel("Proof of Identity/PAN Number:");
        l1.setForeground(Color.blue);
        l1.setFont(new Font("Serif", Font.BOLD, 20));
 
        tf1 = new JTextField();
        
        btn1 = new JButton("Request for ESign");
 
        l1.setBounds(500, 230, 400, 30);
        tf1.setBounds(600, 270, 200, 30);
        
        btn1.setBounds(600, 400, 100, 30);
 
        add(l1);
        add(tf1);
        add(btn1);
        btn1.addActionListener(this);
    }
 
    public void actionPerformed(ActionEvent e)
    {
        populateCustomerData();
    }
 
    public void populateCustomerData()
    {
        dispose();
    	Customer.UserBuilder u = new Customer.UserBuilder("Shivkumar Choudhary");
    	Customer c = u.dob("13-05-1968").gender("Male").phone("2810806979").email("sschoudhary@dummyemail.com").street("12 Maulana Azad Marg").district("New Delhi").state("New Delhi").pincode("110002").panNumber("AWGJ29031F").aadharId("99999999").build();
        GenerateBankForm bankForm = new GenerateBankForm();
         
        bankForm.generateForm(c);
    }
 
    public static void main(String arr[])
    {
        new ESignForm();
    }
}