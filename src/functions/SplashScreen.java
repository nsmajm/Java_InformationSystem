package functions;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Toolkit;


import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



import frames.startPage;

import javax.swing.JProgressBar;



public class SplashScreen extends JFrame implements ActionListener {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4764902052852114919L;
	private JProgressBar progressBar;
	private JLabel  lblTitle;
	private JPanel cpPanel;
	private Container cp;
	private Timer t;
	private int progress = 0;
	
	
	public SplashScreen() {
		
		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation((screenSize.width - getWidth()) / 4, (screenSize.height - getHeight()) / 4);
		cp = getContentPane();
		cpPanel= new JPanel();
		cpPanel.setBorder(BorderFactory.createLineBorder(new Color(209,95,238), 1, true));
		cpPanel.setBackground(new Color(209,95,238));
		
		
		cpPanel.setLayout(null);
		
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setPreferredSize(new Dimension(450,250));

		lblTitle = new JLabel("Information System");

		lblTitle.setBackground(new Color(92,115,139));
		lblTitle.setForeground(new Color(255,255,255));
		lblTitle.setFont(new Font("CONSOLAS", Font.BOLD, 30));
		lblTitle.setBounds(65, 54, 330, 77);
		lblTitle.setBorder(BorderFactory.createLineBorder(new Color(239, 240, 241), 3, true));
		cpPanel.add(lblTitle);
		progressBar = new JProgressBar();
		progressBar.setMinimum(0);
		progressBar.setMaximum(100);
		progressBar.setBackground(new Color(255, 255, 255));
		progressBar.setOpaque(true);
		progressBar.setBorder(BorderFactory.createLineBorder(new Color(239, 240, 241), 1, true));
		progressBar.setBounds(73, 142, 317, 38);
		progressBar.setStringPainted(true);
		progressBar.setForeground(new Color(0,181,66));
		cpPanel.add(progressBar);

		

		cp.add(cpPanel);
		pack();

		t = new Timer(30,this);
		
		t.start();
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent arg0) {
		progressBar.setValue(progress);
		progress += Math.random()*2;
		progressBar.setValue(Math.min(progress, 100));
		if (progress>=100){
			t.stop();
			new startPage();
			dispose();
		}
	}
}

