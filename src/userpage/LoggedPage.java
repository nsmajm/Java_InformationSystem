package userpage;

import java.awt.Color;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.DriverManager;
import java.sql.ResultSet;


import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;


import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;


import net.proteanit.sql.DbUtils;


public class LoggedPage{
		JFrame frame;
		JTextField serachField,areaField,categoryField;
		JPanel headerpanel,searchPanel,bodyPanel,footerPanel,tablePanel;
	    JButton searchButton,userName,nameButton;
		JLabel headerTxtLabel,firstName,lastName,contactInfo,phoneNumber;
		JScrollBar scrollBar;
		JTable table;
		String searchValue;
		String name;
		
		public LoggedPage(String guestName)
		{
			this.name =guestName;
			frame = new JFrame("Information System");
			searchPanel = new JPanel();
			tablePanel = new JPanel();
			table = new JTable();		
			headerpanel = new JPanel();
			headerpanel.setLayout(null);
			tablePanel.setLayout(null);
			bodyPanel = new JPanel();
			//searchPanel.setSize(900,70);
			bodyPanel.setLayout(null);
			//bodyPanel.setSize(900,400);
			searchPanel.setLayout(null);
			serachField = new JTextField("Search For");
			areaField = new JTextField("Area");
			categoryField = new JTextField("Category");
			searchButton = new JButton("search");
			
			headerTxtLabel = new JLabel("Welcome To Information System");
			nameButton = new JButton("Hello  "+guestName);
			firstName = new JLabel(" First Name");
			lastName = new JLabel("  Last Name");
			contactInfo = new JLabel(" Contact");
			phoneNumber = new JLabel(" Phone Number");
			frame.setVisible(true);
			frame.setSize(800, 800);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setLayout(null);
			frame.setLocation(200, 5);
			frame.setLayout(null);
			frame.add(searchPanel);
			frame.add(bodyPanel);
			frame.add(tablePanel);
			setColor();
			addToPanel();
			setBounds();
			setBorder();
			frame.setResizable(false);
			event();
			setFonts();
			
			
		}
		

        
		public void addToPanel()
		{
			headerpanel.add(headerTxtLabel);
			headerpanel.add(nameButton);
			searchPanel.add(serachField);
			searchPanel.add(categoryField);
			searchPanel.add(searchButton);		
			searchPanel.add(categoryField);		
			frame.add(headerpanel);
			//bodyPanel.add(scrollBar);
			bodyPanel.add(table);
			searchPanel.add(areaField);
			tablePanel.add(firstName);
			tablePanel.add(lastName);
			tablePanel.add(contactInfo);
			tablePanel.add(phoneNumber);
			
			
		}
		
		public void setBounds()
		{
			headerpanel.setBounds(0, 20, 800, 100);
			searchPanel.setBounds(0, 120, 800, 100);
			tablePanel.setBounds(0, 220, 800, 30);
			bodyPanel.setBounds(0, 250, 800, 400);
			table.setBounds(0, 0, 800, 400);
			serachField.setBounds(80,20,150,30);
			areaField.setBounds(240, 20, 150, 30);
			categoryField.setBounds(400, 20, 150, 30);
			searchButton.setBounds(560, 20, 100, 30);
			headerTxtLabel.setBounds(20, 40, 425, 30);
			nameButton.setBounds(550, 40, 150, 30);	
			firstName.setBounds(0, 0, 200, 30);
			lastName.setBounds(200,0 , 200, 30);
			contactInfo.setBounds(400, 0, 200, 30);
			phoneNumber.setBounds(600, 0, 200, 30);
		}
		public void setBorder()
		{
			headerpanel.setBorder(BorderFactory.createLineBorder(new Color(0,187,244), 1, true));
			searchPanel.setBorder(BorderFactory.createLineBorder(new Color(00, 0, 0), 1, true));
			//headerTxtLabel.setBorder(BorderFactory.createLineBorder(new Color(239, 240, 241), , false));			
			bodyPanel.setBorder(BorderFactory.createLineBorder(new Color(00, 0, 0), 1, true));
			serachField.setBorder(BorderFactory.createLineBorder(new Color(239, 240, 241), 3, true));
			areaField.setBorder(BorderFactory.createLineBorder(new Color(239, 240, 241), 3, true));
			categoryField.setBorder(BorderFactory.createLineBorder(new Color(239, 240, 241), 3, true));
			firstName.setBorder(BorderFactory.createLineBorder(new Color(0,0,0), 1, true));
			lastName.setBorder(BorderFactory.createLineBorder(new Color(0,0,0), 1, true));
			contactInfo.setBorder(BorderFactory.createLineBorder(new Color(0,0,0), 1, true));
			phoneNumber.setBorder(BorderFactory.createLineBorder(new Color(0,0,0), 1, true));
			table.setRowHeight(50);
			
			
		}
		public void setColor()
		{
			headerpanel.setBackground(new Color(255,255,255));
			table.setBackground(new Color(255, 255, 255));
			table.setForeground(new Color(0, 114, 187));
			searchPanel.setBackground(new Color(0, 144, 187));
			tablePanel.setBackground(new Color(255,255,255));
			searchButton.setForeground(new Color(255, 255, 255));
			searchButton.setBackground(new Color(125,181,59));
			headerpanel.setBackground(new Color(0,144,187));
			headerTxtLabel.setBackground(new Color(255, 255, 255));
			headerTxtLabel.setForeground(new Color(255, 255, 255));
			
			
		}
		public void setFonts()
		{
			headerTxtLabel.setFont(new Font("Consolas", Font.BOLD, 20));
			firstName.setFont(new Font("Consolas", Font.BOLD, 20));
			lastName.setFont(new Font("Consolas", Font.BOLD, 20));
			contactInfo.setFont(new Font("Consolas", Font.BOLD, 20));
			phoneNumber.setFont(new Font("Consolas", Font.BOLD, 20));
			table.setFont(new Font("Consolas", Font.PLAIN, 20));
			nameButton.setFont(new Font("Consolas", Font.BOLD, 15));
			
		}
		public void event()
		{
			searchButton.addActionListener(new ActionListener() {			
				public void actionPerformed(ActionEvent e) {
					try
				    {
						
							Connection con = null;					   
							String searchtext = serachField.getText().toLowerCase();
							String area = areaField.getText().toLowerCase();
							String category =categoryField.getText().toLowerCase();
							String sql = "Select firstname,lastname,contact,phonenumber from infosystem where usertype='"+searchtext+"' and area='"+area+"' and category='"+category+"' ";
							
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
			serachField.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e)
				{
					serachField.setText(null);
				}
			});
			areaField.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e){
					areaField.setText(null);
				}
			});
			categoryField.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e)
				{
					categoryField.setText(null);
				}
			});
			nameButton.addActionListener(new ActionListener() {
				
				
				public void actionPerformed(ActionEvent arg0) {
					new UserDetails(name);
					frame.dispose();
					
				}
			});
			
		}
		
}
