/*class for admin to fill in meter details of customer*/
package electricity.billing.system;

import javax.swing.*;
import java.sql.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;

public class MeterDetails extends JFrame implements ActionListener{
    JLabel JL1,JL2,JL3,JL4,JL5,JL6,JL7,JL8,JL9, JL10, JL11;//declare label from JL1 to JL11
    Choice C1, C2, C3,C4, C5; //declare choice from C1 to C5
    JButton JB1,JB2;//declare button JB1 and JB2

    MeterDetails(String meter){
        //specify the position and size
        setLocation(600,200);
        setSize(800,500);
        
        //declare and initialize panel
        JPanel JP1 = new JPanel();
        JP1.setLayout(null);
        JP1.setBackground(new Color(173,216,230));
        
        //declare and initialize meter details
        JLabel title = new JLabel("Meter Details");
        title.setBounds(180, 10, 200, 26);
        title.setFont(new Font("Helvetica", Font.BOLD, 30));
        title.setForeground(new Color(0,0,139));
        JP1.add(title);

        //declare and initialize meter number
        JL1 = new JLabel("Meter Number");
        JL1.setBounds(100, 80, 100, 20);
        JL1.setFont(new Font("Times New Roman",Font.PLAIN,15));
        
        //declare and initialize  meter
        JL11 = new JLabel(meter);
        JL11.setBounds(240, 80, 200, 20);
        JP1.add(JL1);
        JP1.add(JL11);
        
        //declare and initialize location of meter
        JL2 = new JLabel("Location of Meter");
        JL2.setBounds(100, 120, 110, 20);
        JL2.setFont(new Font("Times New Roman",Font.PLAIN,15));
        C1 = new Choice();//declare and initialize choice, either outside or inside
        C1.add("Outside");
        C1.add("Inside");
        C1.setBounds(240, 120, 200, 20);
        JP1.add(JL2);
        JP1.add(C1);
        
        //declare and initialize type of meter
        JL3 = new JLabel("Type of Meter");
        JL3.setBounds(100, 160, 100, 20);
        JL3.setFont(new Font("Times New Roman",Font.PLAIN,15));
        //declare and initialize choice, either electric meter ir digital meter
        C2 = new Choice();
        C2.add("Electric Meter");
        C2.add("Digital Meter");
        C2.setBounds(240, 160, 200, 20);
        JP1.add(JL3);
        JP1.add(C2);
        
        //declare and initialize type of bill
        JL4 = new JLabel("Type of bill");
        JL4.setBounds(100, 200, 100, 20);
        JL4.setFont(new Font("Times New Roman",Font.PLAIN,15));
        //declare and initialize choice, either residential or industrial
        C4 = new Choice();
        C4.add("Residental");
        C4.add("Industrial");
        C4.setBounds(240, 200, 200, 20);
        JP1.add(JL4);
        JP1.add(C4);
        
        //declare and initialize days
        JL6 = new JLabel("Days");
        JL6.setBounds(100, 240, 100, 20);
        JL6.setFont(new Font("Times New Roman",Font.PLAIN,15));
        //30days will be shown
        JL9 = new JLabel("30 Days");
        JL9.setBounds(240, 240, 200, 20);
        JL9.setFont(new Font("Times New Roman",Font.PLAIN,15));
        JP1.add(JL6);
        JP1.add(JL9);
        
        //show reminder to the user
        JL7 = new JLabel("Reminder : ");
        JL7.setBounds(100, 300, 100, 20);
        JL7.setFont(new Font("Times New Roman",Font.PLAIN,15));
        JL10 = new JLabel("The electric bill only calculated for 30days! ");
        JL10.setBounds(200, 300, 300, 20);
        JL10.setFont(new Font("Times New Roman",Font.PLAIN,15));
        JP1.add(JL7);
        JP1.add(JL10);
        
        //declare and initialize submit button
        JB1 = new JButton("Submit");
        JB1.setBounds(120, 390, 100, 25);
        //declare and initialize cancel button
        JB2 = new JButton("Cancel");
        JB2.setBounds(250, 390, 100, 25);
        
        //set the background color and font color of submit button
        JB1.setBackground(new Color(0,0,139));
        JB1.setForeground(Color.WHITE);
        JB1.setFont(new Font("Times New Roman",Font.PLAIN,15));
        
        //set the background color and font color of cancel button
        JB2.setBackground(Color.WHITE);
        JB2.setForeground(Color.BLACK);
        JB2.setFont(new Font("Times New Roman",Font.PLAIN,15));
        
        JP1.add(JB1);
        JP1.add(JB2);
        setLayout(new BorderLayout());
        
        add(JP1,"Center");
        
        //insert picture to ease the understanding of user
        ImageIcon ic1 = new ImageIcon(ClassLoader.getSystemResource("icon/hicon1.png"));
        Image i3 = ic1.getImage().getScaledInstance(300, 300,Image.SCALE_DEFAULT);
        ImageIcon ic2 = new ImageIcon(i3);
        JL8 = new JLabel(ic2);
        
        
        add(JL8,"West");
        //for changing the color of the whole Frame
        getContentPane().setBackground(new Color(255,240,223));
        
        JB1.addActionListener(this);
        JB2.addActionListener(this);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == JB1){
            String meter_number = JL11.getText();
            String meter_place = C1.getSelectedItem();
            String type_of_meter = C2.getSelectedItem();
            String type_of_bill = C4.getSelectedItem();
            String billing_day = "30";
            //meter number, meter_place, type of meter, type of bill and billing day will be inserted into table meter_details
            String q1 = "insert into meter_details values('"+meter_number+"','"+meter_place+"','"+type_of_meter+"','"+type_of_bill+"','"+billing_day+"')";
            try{
                DBConnection con1 = new DBConnection();
                con1.s.executeUpdate(q1);
                JOptionPane.showMessageDialog(null,"Meter Details Sucessfully added!");
                this.setVisible(false);

            }catch(Exception ex){
                 ex.printStackTrace();
            }
        }else if(ae.getSource() == JB2){
            this.setVisible(false);
        }
    }
    
    
    public static void main(String[] args){
        new MeterDetails("").setVisible(true);
    }
}

