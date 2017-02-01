package frames;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;



import dbconnection.DBCONNECTION;

public class RegistrationPage {
	JFrame frame;
	//about related all things Are Now Area
	public JTextField firstName,lastName,userName,phoneNUmber,email,about,userType,categoryField;
	public String checkFirstName;
	public String checkLastName;
	public String checkUserName;
	public String checkPassword;
	public String checkPhoneNumber;
	public String checkEmail;
	public String checkAbout;
	public String checkType;
	public String checkCategory;
	JPasswordField userPasswordField;
	JLabel firstNameLabel,lastNameLabel,userNameLabel,passwordLabel,phoneNumberLabel,emailLabel,aboutLabel,topTextLabel,userTypeLabel,categoryLabel;
	public JButton registrationButton,reset,backButton;
	JPanel panel =new JPanel(null);
	DBCONNECTION db =new DBCONNECTION();
	public RegistrationPage() {
		
		frame = new JFrame("User Registraion");	
		panel.setSize(530,700);		firstNameLabel = new JLabel("First Name");
		
		lastNameLabel = new JLabel("Last Name");		
		userNameLabel = new JLabel("User Name");		
		passwordLabel = new JLabel("Password");		
		phoneNumberLabel =new JLabel("Phone Number");		
		emailLabel = new JLabel("Contact Info");		
		aboutLabel = new JLabel("Area");
		topTextLabel = new JLabel("please input all Info");
		registrationButton = new JButton("Register");
		firstName = new JTextField("First Name");
		lastName = new JTextField("Last Name");
		userName = new JTextField("User Name");
		userPasswordField = new JPasswordField("Password");
		phoneNUmber = new JTextField("Phone Number");
		userType = new JTextField("Ex:doctor");
		userTypeLabel = new JLabel("UserType");
		categoryLabel =new JLabel("Category");
		categoryField = new JTextField("Ex:ent,physics");
		email = new JTextField("Contact Info");
		about = new JTextField("Area");
		reset = new JButton("Reset");
		backButton = new JButton("Back");
	
		
	
		frame.setVisible(true);
		frame.setSize(530, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocation(350, 20);
		frame.add(panel);
		frame.setLayout(null);
		frame.setResizable(false);
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("icon.png")));
		addToPanel();
		setBounds();
		setcolor();
		setBorder();
		setFonts();
		event();
	
	}
	
	public void addToPanel()
	{
		panel.add(userNameLabel);
		panel.add(passwordLabel);
		panel.add(phoneNumberLabel);
		panel.add(emailLabel);
		panel.add(aboutLabel);
		panel.add(firstNameLabel);
		panel.add(lastNameLabel);
		panel.add(firstName);
		panel.add(lastName);
		panel.add(userName);
		panel.add(userPasswordField);
		panel.add(phoneNUmber);
		panel.add(email);		
		panel.add(about);
		panel.add(topTextLabel);
		panel.add(registrationButton);
		panel.add(reset);
		panel.add(userTypeLabel);
		panel.add(userType);
		panel.add(backButton);
		panel.add(categoryLabel);
		panel.add(categoryField);
	
	
	}	
	public void setBounds()
	{
		topTextLabel.setBounds(100, 70, 320, 30);
		firstNameLabel.setBounds(100, 120, 120, 30);
		lastNameLabel.setBounds(100, 170, 120, 30);
		userNameLabel.setBounds(100, 220, 120, 30);
		passwordLabel.setBounds(100, 270, 120, 30);
		phoneNumberLabel.setBounds(100, 320, 120, 30);
		emailLabel.setBounds(100, 370, 120, 30);
		aboutLabel.setBounds(100, 420, 120, 30);
		firstName.setBounds(220, 120, 200, 30);
		lastName.setBounds(220, 170, 200, 30);
		userName.setBounds(220, 220, 200, 30);
		userPasswordField.setBounds(220, 270, 200, 30);
		phoneNUmber.setBounds(220, 320, 200, 30);
		email.setBounds(220, 370, 200, 30);
		about.setBounds(220, 420, 200, 30);
		userTypeLabel.setBounds(100, 470, 120, 30);
		userType.setBounds(220, 470, 200, 30);
		categoryLabel.setBounds(100, 520, 120, 30);
		categoryField.setBounds(220, 520, 200, 30);
		registrationButton.setBounds(200, 620, 120, 30);
		reset.setBounds(320, 620, 100, 30);
		backButton.setBounds(100, 620, 100, 30);
	
	}
	public void setcolor()
	{
		registrationButton.setBackground(new Color(245, 108, 45));
		registrationButton.setForeground(Color.white);
		reset.setBackground(new Color(245, 108, 45));
		reset.setForeground(Color.white);
		backButton.setBackground(new Color(245, 108, 45));
		backButton.setForeground(Color.white);
		
		
		panel.setBackground(new Color(255, 255, 255));
	}
	public void setBorder()
	{
		panel.setBorder(BorderFactory.createLineBorder(new Color(239, 240, 241), 35, true));
		firstNameLabel.setBorder(BorderFactory.createLineBorder(new Color(239, 240, 241), 3, true));
		firstName.setBorder(BorderFactory.createLineBorder(new Color(239, 240, 241), 3, true));
		lastNameLabel.setBorder(BorderFactory.createLineBorder(new Color(239, 240, 241), 3, true));
		lastName.setBorder(BorderFactory.createLineBorder(new Color(239, 240, 241), 3, true));
		userNameLabel.setBorder(BorderFactory.createLineBorder(new Color(239, 240, 241), 3, true));
		userName.setBorder(BorderFactory.createLineBorder(new Color(239, 240, 241), 3, true));
		passwordLabel.setBorder(BorderFactory.createLineBorder(new Color(239, 240, 241), 3, true));
		userPasswordField.setBorder(BorderFactory.createLineBorder(new Color(239, 240, 241), 3, true));
		phoneNumberLabel.setBorder(BorderFactory.createLineBorder(new Color(239, 240, 241), 3, true));
		phoneNUmber.setBorder(BorderFactory.createLineBorder(new Color(239, 240, 241), 3, true));
		emailLabel.setBorder(BorderFactory.createLineBorder(new Color(239, 240, 241), 3, true));
		email.setBorder(BorderFactory.createLineBorder(new Color(239, 240, 241), 3, true));
		aboutLabel.setBorder(BorderFactory.createLineBorder(new Color(239, 240, 241), 3, true));
		about.setBorder(BorderFactory.createLineBorder(new Color(239, 240, 241), 3, true));
		userType.setBorder(BorderFactory.createLineBorder(new Color(239, 240, 241), 3, true));
		userTypeLabel.setBorder(BorderFactory.createLineBorder(new Color(239, 240, 241), 3, true));
		categoryLabel.setBorder(BorderFactory.createLineBorder(new Color(239, 240, 241), 3, true));
		categoryField.setBorder(BorderFactory.createLineBorder(new Color(239, 240, 241), 3, true));
		topTextLabel.setBorder(BorderFactory.createLineBorder(new Color(239, 240, 241), 3, true));

	}
	public void setFonts()
	{
		topTextLabel.setFont(new Font("Consolas", Font.BOLD, 17));
		firstNameLabel.setFont(new Font("Consolas", Font.BOLD, 17));
		firstName.setFont(new Font("Consolas", Font.PLAIN, 17));
		lastNameLabel.setFont(new Font("Consolas", Font.BOLD, 17));
		lastName.setFont(new Font("Consolas", Font.PLAIN, 17));
		userNameLabel.setFont(new Font("Consolas", Font.BOLD, 17));
		userName.setFont(new Font("Consolas", Font.PLAIN, 17));
		passwordLabel.setFont(new Font("Consolas", Font.BOLD, 17));
		userPasswordField.setFont(new Font("Consolas", Font.PLAIN, 17));
		phoneNumberLabel.setFont(new Font("Consolas", Font.BOLD, 17));
		phoneNUmber.setFont(new Font("Consolas", Font.PLAIN, 17));
		emailLabel.setFont(new Font("Consolas", Font.BOLD, 17));
		email.setFont(new Font("Consolas", Font.PLAIN, 17));
		aboutLabel.setFont(new Font("Consolas", Font.BOLD, 17));
		about.setFont(new Font("Consolas", Font.PLAIN, 17));
		registrationButton.setFont(new Font("Consolas", Font.PLAIN, 17));
		reset.setFont(new Font("Consolas", Font.PLAIN, 17));
		userTypeLabel.setFont(new Font("Consolas", Font.BOLD, 17));
		categoryLabel.setFont(new Font("Consolas", Font.BOLD, 17));
		userType.setFont(new Font("Consolas", Font.PLAIN, 17));
		categoryField.setFont(new Font("Consolas", Font.PLAIN, 17));
		
	}
	
	
	public void event()
	{
		 firstName.addMouseListener(new MouseAdapter() {
		     	public void mouseClicked(MouseEvent e)
		     	{
		     		firstName.setText("");
		     	}
	    	});
		 
		 lastName.addMouseListener(new MouseAdapter() {
		     	public void mouseClicked(MouseEvent e)
		     	{
		     		lastName.setText("");
		     	}
	    	});
		 userName.addMouseListener(new MouseAdapter() {
		     	public void mouseClicked(MouseEvent e)
		     	{
		     		userName.setText("");
		     	}
	    	});
		 userPasswordField.addMouseListener(new MouseAdapter() {
		     	public void mouseClicked(MouseEvent e)
		     	{
		     		userPasswordField.setText("");
		     	}
	    	});
		 phoneNUmber.addMouseListener(new MouseAdapter() {
		     	public void mouseClicked(MouseEvent e)
		     	{
		     		phoneNUmber.setText("");
		     	}
	    	});
		 email.addMouseListener(new MouseAdapter() {
		     	public void mouseClicked(MouseEvent e)
		     	{
		     		email.setText("");
		     	}
	    	});
		 about.addMouseListener(new MouseAdapter() {
		     	public void mouseClicked(MouseEvent e)
		     	{
		     		about.setText("");
		     	}
	    	});
		 userType.addMouseListener(new MouseAdapter() {
		     	public void mouseClicked(MouseEvent e)
		     	{
		     		userType.setText("");
		     	}
	    	});
		categoryField.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e)
			{
				categoryField.setText("");
			}
		});
		 registrationButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				checkFirstName=firstName.getText();
				checkLastName =	 lastName.getText();
				checkUserName = userName.getText();
				checkPassword = new String(userPasswordField.getPassword());
				checkPhoneNumber =phoneNUmber.getText();
				checkEmail = email.getText();
				checkAbout =about.getText().toLowerCase();
				checkType = userType.getText().toLowerCase();
				checkCategory=categoryField.getText().toLowerCase();
				if(checkFirstName.length()==0||checkLastName.length()==0||checkUserName.length()==0||checkPassword.length()==0||checkPassword.length()==0||checkEmail.length()==0||checkAbout.length()==0||checkCategory.length()==0)
				{
					{
						JOptionPane.showMessageDialog(null, "Input All Information");
					}
				}
				
				else{
				try{
					 
			
		             db.theQuery("insert into infosystem (firstname,lastname,username,password,phonenumber,contact,area,usertype,category) values('"+checkFirstName+"','"+checkLastName+"','"+checkUserName+"','"+checkPassword+"','"+checkPhoneNumber+"','"+checkEmail+"','"+checkAbout+"','"+checkType+"','"+checkCategory+"')");
		             JOptionPane.showMessageDialog(null, "Successfully Registered");
		             frame.dispose();
		             new startPage();
		         }
		         catch(Exception ex){
		         }
				}		
			}
		});
		 
		 reset.addMouseListener(new MouseAdapter() {
			 public void mouseClicked(MouseEvent e)
		     	{
		     		firstName.setText(null);
		     		lastName.setText(null);
		     		userName.setText(null);
		     		userPasswordField.setText(null);
		     		phoneNUmber.setText(null);
		     		email.setText(null);
		     		about.setText(null);
		     		userType.setText(null);
		     		categoryField.setText(null);
				
		     		
		     	}
		});
		 
		 backButton.addActionListener(new ActionListener() {
			
			
			public void actionPerformed(ActionEvent arg0) {
				new startPage();
				frame.dispose();
				
			}
		});
		 
	}

	

}
