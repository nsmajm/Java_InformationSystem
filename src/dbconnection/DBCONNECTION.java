package dbconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class DBCONNECTION{
	public Connection con = null;
    public Statement st ;
    public ResultSet rs ;
   
	 public void theQuery(String query){
		 
	      try{
	          con = DriverManager.getConnection("jdbc:mysql://localhost/informationsystem","root","");
	          st = con.createStatement();
	          st.executeUpdate(query);
	         
	          
	        
	      }catch(Exception ex){
	          JOptionPane.showMessageDialog(null,ex.getMessage());
	      }
	  }
	
}
	