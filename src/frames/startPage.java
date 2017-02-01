package frames;
import javax.swing.*;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import admin.Admin;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.DriverManager;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import frames.RegistrationPage;
import userpage.LoggedPage;

public class startPage {

	 JFrame frame;
    JTextField userNameField,userPasswordField;
    
    JButton loginButton, registerButton, guestButton;
    JLabel userPasswordLabel,userNameLabel,topTextLabel;
    public String checkName,checkPass;
    JPanel panel = new JPanel(null);
    
    public startPage() {
    	
        frame = new JFrame();
        
        userNameField = new JTextField("username",20);
       
        userPasswordField = new JPasswordField("password",20);
        loginButton = new JButton("Login");
        registerButton = new JButton("Registration");
        guestButton = new JButton("Guest");
        userNameLabel = new JLabel("UserName");
        userPasswordLabel = new JLabel("Password");
        registerButton =new JButton("Registration");
        guestButton = new JButton("Guest");
        topTextLabel = new JLabel("Welcome to Information System");
        frame.setTitle("Information System");
        frame.setVisible(true);
        frame.setSize(530, 400);    
        frame.setLocation(350, 100);
        frame.add(panel);   
        frame.setResizable(false);    
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
       checkName = userNameField.getText();
       checkPass = userPasswordField.getText();
        
        setBounds();
        sethoverText();
        eventField();  
        setColor();
        addToPanel();
        addBorder();
        setFont();
        frame.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("icon.png")));
       
    }
    
 

	public void setFont() {
		topTextLabel.setFont(new Font("Consolas", Font.BOLD, 17));
		userNameField.setFont(new Font("Consolas", Font.BOLD, 17));
		userNameLabel.setFont(new Font("Consolas", Font.BOLD, 17));
		userPasswordField.setFont(new Font("Consolas", Font.BOLD, 17));
		userPasswordLabel.setFont(new Font("Consolas", Font.BOLD, 17));
		loginButton.setFont(new Font("Arial", Font.BOLD, 17));
		registerButton.setFont(new Font("Arial", Font.BOLD, 15));
		guestButton.setFont(new Font("Arial", Font.BOLD, 17));
		
		
		
	}



	public void addBorder() {
		panel.setBorder(BorderFactory.createLineBorder(new Color(239, 240, 241), 35, true)); 
		topTextLabel.setBorder(BorderFactory.createLineBorder(new Color(239, 240, 241), 3, true));
		userPasswordField.setBorder(BorderFactory.createLineBorder(new Color(239, 240, 241), 3, true));
		userNameField.setBorder(BorderFactory.createLineBorder(new Color(239, 240, 241), 3, true));
		userNameLabel.setBorder(BorderFactory.createLineBorder(new Color(239, 240, 241), 1, true));
		userPasswordLabel.setBorder(BorderFactory.createLineBorder(new Color(239, 240, 241), 1, true));
		
		
	}



	public void addToPanel()
    {
    	panel.add(userNameField);
        panel.add(userPasswordField);
        panel.add(loginButton);
        panel.add(registerButton);
        panel.add(guestButton);
        panel.add(userNameLabel);
        panel.add(userPasswordLabel);
        panel.add(registerButton);
        panel.add(guestButton);
        panel.add(topTextLabel);
    }

public void sethoverText()
{
	userNameField.setToolTipText("Input UserName Here");
	userPasswordField.setToolTipText("Input Password Here");
	loginButton.setToolTipText("Click Here For Login");
}
public void setColor()
{
	  
      panel.setBackground(new Color(255,255,255));
      loginButton.setBackground(new Color(245, 108, 45));
      registerButton.setBackground(new Color(245, 108, 45));
      guestButton.setBackground(new Color(245, 108, 45));  
      registerButton.setBorder(null);
      loginButton.setForeground(Color.white);
      guestButton.setForeground(Color.white);
      registerButton.setForeground(Color.white);
      topTextLabel.setBackground(new Color(239, 240, 241));
      topTextLabel.setForeground(new Color(123, 23, 69));
      

}
public void setBounds()
{
	userNameLabel.setBounds(100,150,200,30);
    userNameField.setBounds(200,150,200,30);
    userPasswordLabel.setBounds(100,200,200,30);
    userPasswordField.setBounds(200,200,200,30);
    loginButton.setBounds(100,250,100,30);
    registerButton.setBounds(200, 250, 100, 30);
    guestButton.setBounds(300,250, 100, 30);
    topTextLabel.setBounds(100,70,300,30);
    
    
}
public void eventField()
{
	 userNameField.addMouseListener(new MouseAdapter() {
     	public void mouseClicked(MouseEvent e)
     	{
     		userNameField.setText("");
     	}
		});
     userPasswordField.addMouseListener(new MouseAdapter() {
     	public void mouseClicked(MouseEvent e)
     	{
     		userPasswordField.setText("");
     	}
		});
     loginButton.addActionListener(new ActionListener() {
		
		public void actionPerformed(ActionEvent e) {
			 checkName = userNameField.getText();
			 checkPass =userPasswordField.getText();
			 int per =0;
			if(checkName.length()==0 || checkPass.length()==0){
				
				JOptionPane.showMessageDialog(null, "Invalid");
				userNameField.setBorder(BorderFactory.createLineBorder(new Color(255, 0, 0), 3, true));
				userPasswordField.setBorder(BorderFactory.createLineBorder(new Color(255, 0, 0), 3, true));
			}
			
			else if(checkName.equals("nsmajm")){
				try {
					Connection conn;
					String dbuser = "root";
					String dbpassw = "";
					
					String databaseName = "informationsystem";
					String url = "jdbc:mysql://localhost/"+databaseName;
					Class.forName("com.mysql.jdbc.Driver");
					conn = (Connection) DriverManager.getConnection(url, dbuser, dbpassw);
					Statement st = (Statement) conn.createStatement();
					ResultSet res = st.executeQuery("SELECT * FROM infosystem WHERE username='"+checkName+"' AND password='"+checkPass+"'");
					if(res.next()) {
						
						JOptionPane.showMessageDialog(null, "You have Logged in!");	
						new Admin(checkName);					
						frame.dispose();
					}
					
					else {
						JOptionPane.showMessageDialog(null, "Wrong userName/password!");
					}
					} catch(Exception r) {
						r.printStackTrace();
					}
			}
			else{
				try {
					Connection conn;
					String dbuser = "root";
					String dbpassw = "";
					
					String databaseName = "informationsystem";
					String url = "jdbc:mysql://localhost/"+databaseName;
					Class.forName("com.mysql.jdbc.Driver");
					conn = (Connection) DriverManager.getConnection(url, dbuser, dbpassw);
					Statement st = (Statement) conn.createStatement();
					ResultSet res = st.executeQuery("SELECT * FROM infosystem WHERE username='"+checkName+"' AND password='"+checkPass+"'");
					if(res.next()) {
						
						JOptionPane.showMessageDialog(null, "You have Logged in!");	
						new LoggedPage(checkName);					
						frame.dispose();
					}
					
					else {
						JOptionPane.showMessageDialog(null, "Wrong userName/password!");
					}
					} catch(Exception r) {
						r.printStackTrace();
					}
			}
		}
	});
     
   
     
     registerButton.addActionListener(new ActionListener() {
		
	
		public void actionPerformed(ActionEvent e) {
			
			new RegistrationPage();
			
			frame.dispose();
			
		}

		
	});
     
    
     
     
guestButton.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent e) {
		new mainPage("Guest");
		frame.dispose();
		
	}
});
}

public void setVisible(boolean b) {
	frame.setVisible(true);
	
}


}