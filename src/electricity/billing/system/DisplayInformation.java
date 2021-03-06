/*class for displaying customer own information for customer homepage*/
package electricity.billing.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;

public class DisplayInformation extends JFrame implements ActionListener{
    JButton JB1;//declare button JB1
    DisplayInformation(String meter){
        //specify the bounds(int x , int y, int width, int height)
        setBounds(600,250, 850, 650);
        //set the background of the panel as pink salmon color
        getContentPane().setBackground(new Color(250,128,114));
        setLayout(null);
        
        //declare and innitialize the title CUSTOMER INFORMATION
        JLabel label = new JLabel("CUSTOMER INFORMATION");
        label.setBounds(200, 0, 550, 40);
        label.setFont(new Font("Helvetica", Font.BOLD, 25));
        label.setForeground(new Color(0,0,139));
        add(label);
        
        //declare and initialize name 
        JLabel JL1 = new JLabel("Name:");
        JL1.setBounds(70, 140, 100, 20);
        JL1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        add(JL1);
        //name of customer will be shown
        JLabel JL11 = new JLabel();
        JL11.setBounds(200, 140, 100, 20);
        add(JL11);

        //declare and initialize meter number
        JLabel JL2 = new JLabel("Meter Number:");
        JL2.setBounds(70, 80, 100, 20);
        JL2.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        add(JL2);
        //meter number of that customer will be shown
        JLabel JL12 = new JLabel();
        JL12.setBounds(200, 80, 100, 20);
        add(JL12);
        
        //declare and initialize residential address
        JLabel JL3 = new JLabel("Residental Address:");
        JL3.setBounds(500, 80, 150, 20);
        JL3.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        add(JL3);
        //address of that customer will be shown
        JLabel JL13 = new JLabel();
        JL13.setBounds(650, 80, 100, 20);
        add(JL13);
        
        //declare and initialize residential address
        JLabel JL4 = new JLabel("Residental City:");
        JL4.setBounds(500, 140, 100, 20);
        JL4.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        add(JL4);
        //city of that customer will be shown
        JLabel JL14 = new JLabel();
        JL14.setBounds(650, 140, 100, 20);
        add(JL14);
        
        //declare and initialize residential state
        JLabel JL5 = new JLabel("Residental State:");
        JL5.setBounds(500, 200, 100, 20);
        JL5.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        add(JL5);
        //state of that customer will be shown
        JLabel JL15 = new JLabel();
        JL15.setBounds(650, 200, 100, 20);
        add(JL15);
        
        //declare and initialize email of customer
        JLabel JL6 = new JLabel("Email:");
        JL6.setBounds(70, 200, 100, 20);
        JL6.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        add(JL6);
        //email of that customer will be shown
        JLabel JL16 = new JLabel();
        JL16.setBounds(200, 200, 200, 20);
        add(JL16);
        
        //declare and initialize phone number of customer
        JLabel JL7 = new JLabel("Phone:");
        JL7.setBounds(70, 260, 100, 20);
        JL7.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        add(JL7);
        //phone number of that customer will be shown
        JLabel JL17 = new JLabel();
        JL17.setBounds(200, 260, 100, 20);
        add(JL17);
        
        try{
            DBConnection con1 = new DBConnection();
            //the data will be retrieved from the table Customer in database and will be shown
            ResultSet rs = con1.s.executeQuery("select * from customer where customer_meter = '"+meter+"'");
            while(rs.next()){
                JL11.setText(rs.getString(1));
                JL12.setText(rs.getString(2));
                JL13.setText(rs.getString(3));
                JL14.setText(rs.getString(4));
                JL15.setText(rs.getString(5));
                JL16.setText(rs.getString(6));
                JL17.setText(rs.getString(7));
                
            }
        }catch(Exception e){}
        
        //initialize return button
        JB1 = new JButton("Return");
        JB1.setBackground(Color.DARK_GRAY);
        JB1.setForeground(Color.WHITE);
        JB1.setBounds(350, 340, 100, 25);
        JB1.addActionListener(this);
        JB1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        add(JB1);
        
        //insert picture of customer info so the user will know this is diaplay information
        ImageIcon IC1 = new ImageIcon(ClassLoader.getSystemResource("icon/viewcustomer.png"));
        Image img2 = IC1.getImage().getScaledInstance(600, 300, Image.SCALE_DEFAULT);
        ImageIcon IC3 = new ImageIcon(img2);
        JLabel JL8  = new JLabel(IC3);
        JL8.setBounds(20, 350, 600, 300);
        add(JL8);
    }
    
    public void actionPerformed(ActionEvent ae){
        this.setVisible(false);
    }
    
    public static void main(String[] args){
        new DisplayInformation("").setVisible(true);
    }
}
