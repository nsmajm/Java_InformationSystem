package userpage;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import dbconnection.DBCONNECTION;
import functions.SplashScreen;


public class UserDetails {
	JFrame frame;
	String username,id;
	JLabel passwordLabel,phoneNumberLabel,contactNumberLabel,areaLabel,welcomeLabel,userIdLabel;
	JTextField passwordField,phoneNumberField,contactNumberField,areaFirld,userIdField;
	JButton updateButton,backButton;
	
	public UserDetails(String details)
	{
		this.username = details;
		frame = new JFrame();
		passwordLabel = new JLabel("Password");
		phoneNumberLabel = new JLabel("Phone Number");
		contactNumberLabel = new JLabel("Contact Info");
		areaLabel = new JLabel("Area");
		userIdLabel = new JLabel("User name");
		userIdField = new JTextField();
		updateButton = new JButton("Update");
		welcomeLabel = new JLabel(" "+"Welcome "+" "+ details +"   ");
		backButton = new JButton("Back");
		passwordField= new JTextField();
		phoneNumberField= new JTextField();
		contactNumberField= new JTextField();
		areaFirld= new JTextField();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500, 600);
		frame.setVisible(true);
		frame.setLayout(null);
		
		addToFrame();
		setBounds();
		event();
		setColor();
		setBorder();
		setFont();
	}
	
	public void addToFrame()
	{
		frame.add(passwordLabel);
		frame.add(phoneNumberLabel);
		frame.add(contactNumberLabel);
		frame.add(areaLabel);
		frame.add(passwordField);
		frame.add(phoneNumberField);
		frame.add(contactNumberField);
		frame.add(areaFirld);
		frame.add(updateButton);
		frame.add(welcomeLabel);
		frame.add(backButton);
		frame.add(userIdLabel);
		frame.add(userIdField);
	}
	
	public void setBounds()
	{
		userIdLabel.setBounds(60, 100, 150, 30);
		userIdField.setBounds(220, 100, 200, 30);
		passwordLabel.setBounds(60, 160, 150, 30);
		phoneNumberLabel.setBounds(60, 220, 150, 30);
		contactNumberLabel.setBounds(60, 280, 150, 30);
		areaLabel.setBounds(60, 340, 150, 30);
		passwordField.setBounds(220, 160, 200, 30);
		phoneNumberField.setBounds(220, 220, 200, 30);
		contactNumberField.setBounds(220, 280, 200, 30);
		areaFirld.setBounds(220, 340, 200, 30);
		updateButton.setBounds(220, 400, 200, 30);
		welcomeLabel.setBounds(120, 20, 200, 30);
		backButton.setBounds(60, 400, 150, 30);
	}
	public void setColor()
	{
		welcomeLabel.setForeground(new Color(215, 37, 35));
	
	}
	public void setFont()
	{
		welcomeLabel.setFont(new Font("Consolas", Font.BOLD, 15));
	}
	public void setBorder()
	{
		welcomeLabel.setBorder(BorderFactory.createLineBorder(new Color(255, 255, 255), 2, true));
		userIdLabel.setBorder(BorderFactory.createLineBorder(new Color(255, 255, 255), 2, true));
		userIdField.setBorder(BorderFactory.createLineBorder(new Color(239, 240, 241), 2, true));
		passwordField.setBorder(BorderFactory.createLineBorder(new Color(239, 240, 241), 2, true));
		passwordLabel.setBorder(BorderFactory.createLineBorder(new Color(239, 240, 241), 2, true));
		contactNumberField.setBorder(BorderFactory.createLineBorder(new Color(239, 240, 241), 2, true));
		contactNumberLabel.setBorder(BorderFactory.createLineBorder(new Color(239, 240, 241), 2, true));
		areaFirld.setBorder(BorderFactory.createLineBorder(new Color(239, 240, 241), 2, true));
		areaLabel.setBorder(BorderFactory.createLineBorder(new Color(239, 240, 241), 2, true));
		phoneNumberField.setBorder(BorderFactory.createLineBorder(new Color(239, 240, 241), 2, true));
		phoneNumberLabel.setBorder(BorderFactory.createLineBorder(new Color(239, 240, 241), 2, true));
		
	}
	public void event()
	{
		updateButton.addActionListener(new ActionListener() {		
			public void actionPerformed(ActionEvent arg0) {
				String checkPassword,checkPhoneNumber,checkContactNumber,checkArea,checkId;
				checkPassword = passwordField.getText();
				checkPhoneNumber=phoneNumberField.getText();
				checkContactNumber=contactNumberField.getText();
				checkArea=areaFirld.getText();
				checkId=userIdField.getText();
				if(checkPassword.length()==0||checkPhoneNumber.length()==0||checkContactNumber.length()==0||checkArea.length()==0)
				{
					JOptionPane.showMessageDialog(null, "Please Update All Fields...");
				}
				else{
				try{
					 
					DBCONNECTION db = new DBCONNECTION();
					db.theQuery("update infosystem set password='"+checkPassword+"', contact='"+checkContactNumber+"' , phonenumber='"+checkPhoneNumber+"' , area ='"+checkArea+"' where username='"+checkId+"'");
					JOptionPane.showMessageDialog(null, "Updated");
		           
		             
		         }
		         catch(Exception ex){
		         }
						
				}
				
			}
		});	
		backButton.addActionListener(new ActionListener() {
			
			
			public void actionPerformed(ActionEvent e) {
				new LoggedPage(username);
				frame.dispose();
				
			}
		});
	}
	
}
