package admin;
import javax.swing.*;

import dbconnection.DBCONNECTION;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminAdd {
    //Register class extends User class
    JFrame frame;
    JPanel panel;
    JButton addUserButton,backButton;
    JTextField firstNameTextField,lastNameTextField,areaField,categoryField,userTypeField,contactNoTextField;
    JLabel firstNameLabel,lastNameLabel,AreaLabel,categoryLabel,userTypeLabel,contactNoLabel;
    String name;
    DBCONNECTION db = new DBCONNECTION();
    public AdminAdd(String Name) {
    	this.name=Name;
         frame= new JFrame();
         panel = new JPanel(null);
//this is simple add
        firstNameLabel = new JLabel("First Name");
        lastNameLabel = new JLabel("Last Name");
        AreaLabel = new JLabel(" Area");
        categoryLabel = new JLabel("Category");
        userTypeLabel = new JLabel("User Type");
        contactNoLabel = new JLabel("Phone Number");
        addUserButton = new JButton("Add User");
        backButton =new JButton("Back");
        firstNameTextField = new JTextField();
        lastNameTextField = new JTextField();
        areaField = new JTextField();
        categoryField = new JTextField();
        userTypeField = new JTextField();
        contactNoTextField = new JTextField();
        frame.add(panel);
        setBound();
        addToPanel();
        event();
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setSize(600,600);
        panel.setSize(600,600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setLocation(400,50);


    }
    public void setBound()
    {
        firstNameLabel.setBounds(100,35,200,30);
        firstNameTextField.setBounds(300,35,200,30);
        lastNameLabel.setBounds(100,90,200,30);
        lastNameTextField.setBounds(300,100,200,30);
        AreaLabel.setBounds(100,160,200,30);
        areaField.setBounds(300,160,200,30);
        categoryLabel.setBounds(100,220,200,30);
        categoryField.setBounds(300,220,200,30);
        userTypeLabel.setBounds(100,280,200,30);
        userTypeField.setBounds(300,280,200,30);
        contactNoLabel.setBounds(100,340,200,30);
        contactNoTextField.setBounds(300,340,200,30);
        addUserButton.setBounds(300,400,100,30);
        backButton.setBounds(400, 400, 100, 30);
    }
    public void addToPanel()
    {
        panel.add(firstNameLabel);
        panel.add(lastNameLabel);
        panel.add(AreaLabel);
        panel.add(categoryLabel);
        panel.add(userTypeLabel);
        panel.add(contactNoLabel);
        panel.add(firstNameTextField);
        panel.add(lastNameTextField);
        panel.add(areaField);
        panel.add(categoryField);
        panel.add(userTypeField);
        panel.add(contactNoTextField);
        panel.add(addUserButton);
        panel.add(backButton);
    }
    public void event()
    {
    	addUserButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	String checkFirstName,checkLastNAme,checkArea,checkCategory,checkUserType,checkContactNumber,defaultuserValue,defaultPass,defaultcontact;
            	defaultcontact = "null";
            	defaultPass ="null";
            	defaultuserValue="null";
            	
            	checkFirstName=firstNameTextField.getText();
            	
            	checkLastNAme=lastNameTextField.getText();
                checkArea=areaField.getText();
                checkCategory=categoryField.getText();
                checkUserType=userTypeField.getText();
                checkContactNumber=contactNoTextField.getText();
                if(checkFirstName.length()==0||checkLastNAme.length()==0||checkArea.length()==0||checkCategory.length()==0|checkUserType.length()==0||checkContactNumber.length()==0)
                {
                	JOptionPane.showMessageDialog(null, "Fill All Text Field For Adding Member");
                }
                else
                {
                	//String sql ="INSERT INTO `infosystem`( `username`,`firstname`, `lastname`, `phonenumber`, `area`, `usertype`, `category`) VALUES('"+defaultValue+"','"+checkFirstName+"','"+checkLastNAme+"','"+checkContactNumber+"','"+checkArea+"','"+checkUserType+"','"+checkCategory+"')";
                	String sql="insert into infosystem (firstname,lastname,username,password,phonenumber,contact,area,usertype,category)values('"+checkFirstName+"','"+checkLastNAme+"','"+defaultuserValue+"','"+defaultPass+"','"+checkContactNumber+"','"+defaultcontact+"','"+checkArea+"','"+checkUserType+"','"+checkCategory+"')";
                	db.theQuery(sql);


                	JOptionPane.showMessageDialog(null, "User Added");
                }
               
            }
        });
    	backButton.addActionListener(new ActionListener() {
			
			
			public void actionPerformed(ActionEvent e) {
				new Admin(name);
				frame.dispose();
				
			}
		});
    }
   
}

