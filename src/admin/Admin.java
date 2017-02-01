package admin;

//comment
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.ResultSet;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import dbconnection.DBCONNECTION;
import net.proteanit.sql.DbUtils;


public class Admin {
	JFrame frame;
	String name;
	JPanel headerPAnel,adminPanel,tablePanel;
	JLabel welcomeLabel,idLabel;
	JButton deleteButton,addButton,showAllUserButton;
	JTextField searchIdFeild;
	JTable table;
	DBCONNECTION db = new DBCONNECTION();
	
	public Admin(String name)
	{
		this.name =name;
		frame = new JFrame("Logged in As:"+" "+name.toUpperCase());
		headerPAnel=new JPanel();
		adminPanel=new JPanel();
		tablePanel=new JPanel();
		table=new JTable();
		deleteButton = new JButton("Delete User");
		addButton = new JButton("Add User");
		idLabel=new JLabel("Id");
		showAllUserButton = new JButton("Show All");
		welcomeLabel = new JLabel("Welcome Admin "+"  "+name);
		searchIdFeild = new JTextField();
		frame.setSize(800, 600);
		frame.setLocation(400, 50);
		frame.setResizable(false);
		frame.setVisible(true);
		frame.setLayout(null);
		frame.add(headerPAnel);
		frame.add(adminPanel);
		frame.add(tablePanel);
		//tablePanel.setLayout(null);
		headerPAnel.setLayout(null);
		adminPanel.setLayout(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds();
		setSize();
		addTOPanel();
		setBorder();
		setFont();
		setColor();
		event();
	}
			

	private void setColor() {
		headerPAnel.setBackground(new Color(239,240,241));
		
	}


	private void setFont() {
		welcomeLabel.setFont(new Font("Consolas", Font.BOLD, 17));
		
	}


	private void setBorder() {
		headerPAnel.setBorder(BorderFactory.createLineBorder(new Color(255, 255, 255), 2, true));
		adminPanel.setBorder(BorderFactory.createLineBorder(new Color(255, 255, 255), 2, true));
		tablePanel.setBorder(BorderFactory.createLineBorder(new Color(255, 255, 255), 2, true));
		
	}


	private void setSize() {
		headerPAnel.setSize(800,100);
		adminPanel.setSize(800, 100);
		tablePanel.setSize(800, 600);
		
	}


	public void addTOPanel()
	{
		headerPAnel.add(welcomeLabel);
		adminPanel.add(deleteButton);
		adminPanel.add(addButton);
		adminPanel.add(showAllUserButton);
		adminPanel.add(idLabel);
		adminPanel.add(searchIdFeild);
		tablePanel.add(table);
	}
	public void setBounds()
	{
		welcomeLabel.setBounds(100, 30, 200, 30);
		adminPanel.setBounds(0, 105, 800, 100);
		deleteButton.setBounds(220,30, 100, 30);
		idLabel.setBounds(20, 30, 80, 30);
		searchIdFeild.setBounds(60, 30, 150, 30);
		addButton.setBounds(340, 30, 100, 30);
		showAllUserButton.setBounds(460, 30, 150, 30);
		tablePanel.setBounds(0, 220, 800, 600);
	}
	public void event()
	{
		showAllUserButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				try
			    {
					
						Connection con = null;					   
						
						String sql = "Select userid,firstname,lastname,phonenumber,contact,area,usertype,category from infosystem";
						
						con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/informationsystem","root","");							
						PreparedStatement st1 =(PreparedStatement) con.prepareStatement(sql);
						ResultSet rs1 = st1.executeQuery();				   
						table.setModel(DbUtils.resultSetToTableModel(rs1));
						table.setFillsViewportHeight(true);							
						con.close();
					
			    	}
			    catch(Exception ex)
			    {
			    	
			    JOptionPane.showMessageDialog(null, ex.toString());
			    
			    }
				
			}
		});
		
		deleteButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				String idCheck = searchIdFeild.getText();
				try
			    {
						String sql ="delete from infosystem where userid ='"+idCheck+"'";
						
						db.theQuery(sql);
						
					
			    	}
			    catch(Exception ex)
			    {
			    	
			    JOptionPane.showMessageDialog(null, ex.toString());
			    
			    }
				
			}
		});
		addButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				new AdminAdd( name);
				frame.dispose();
				
			}
		});
	}

}
