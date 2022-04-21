package javaProject;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import org.bson.Document;
import java.awt.Component;
import javax.swing.Box;

public class Welcome extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	Document d;
	public Welcome(final Document d) {
		
		this.d=d;
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\NANI\\Documents\\eclipse workspace\\javaProject\\icons\\favicon-32x32.png"));
		setFont(new Font("Calibri", Font.PLAIN, 14));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 871, 617);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(233, 213, 218));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel topmenu = new JLabel("");
		topmenu.setIcon(new ImageIcon("C:\\Users\\NANI\\Downloads\\ibanking.png"));
		topmenu.setBounds(0, 0, 857, 84);
		contentPane.add(topmenu);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(3, 83, 151));
		panel.setBounds(0, 77, 243, 503);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton userInfo = new JButton("UserInfo");
		userInfo.setForeground(new Color(245, 245, 245));
		userInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				UserInfo inf=new UserInfo(d);
				
				
			}
		});
		userInfo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		userInfo.setBounds(0, 53, 243, 29);
		userInfo.setBackground(new Color(3, 83, 151));
		panel.add(userInfo);
		
		JButton fundsTransfer = new JButton("Transfer Funds");
		fundsTransfer.setForeground(new Color(255, 250, 250));
		fundsTransfer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TransferFunds tr=new TransferFunds(d);
				tr.setVisible(true);
			}
		});
		fundsTransfer.setFont(new Font("Tahoma", Font.PLAIN, 14));
		fundsTransfer.setBackground(new Color(3, 83, 151));
		fundsTransfer.setBounds(0, 96, 243, 29);
		panel.add(fundsTransfer);
		
		JButton editDetails = new JButton("Edit Details");
		editDetails.setForeground(new Color(255, 250, 250));
		editDetails.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EditDetails E=new EditDetails(d);
				E.setVisible(true);
				
				
			}
		});
		editDetails.setFont(new Font("Tahoma", Font.PLAIN, 14));
		editDetails.setBackground(new Color(3, 83, 151));
		editDetails.setBounds(0, 141, 243, 29);
		panel.add(editDetails);
		
		JButton recTransactions = new JButton("Recent Transactions");
		recTransactions.setForeground(new Color(255, 250, 250));
		recTransactions.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Transactions T=new Transactions(d);
				T.setVisible(true);
			}
		});
		recTransactions.setFont(new Font("Tahoma", Font.PLAIN, 14));
		recTransactions.setBackground(new Color(3, 83, 151));
		recTransactions.setBounds(0, 180, 243, 29);
		panel.add(recTransactions);
		
		JButton printSmt = new JButton("Print Statement");
		printSmt.setForeground(new Color(255, 250, 250));
		printSmt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PrintTranscations pt=new PrintTranscations(d);
				
			}
		});
		printSmt.setFont(new Font("Tahoma", Font.PLAIN, 14));
		printSmt.setBackground(new Color(3, 83, 151));
		printSmt.setBounds(0, 219, 243, 29);
		panel.add(printSmt);
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login l=new Login();
				l.setVisible(true);
				dispose();
					
			}
		});
		btnLogout.setForeground(new Color(255, 250, 250));
		btnLogout.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnLogout.setBackground(new Color(3, 83, 151));
		btnLogout.setBounds(0, 474, 243, 29);
		panel.add(btnLogout);
		
		JLabel profilName = new JLabel("username");
		String u=d.get("username").toString();
		profilName.setText(u);
		profilName.setHorizontalAlignment(SwingConstants.CENTER);
		profilName.setFont(new Font("Tahoma", Font.PLAIN, 20));
		profilName.setBounds(453, 343, 217, 37);
		contentPane.add(profilName);
		
		JLabel userMobile = new JLabel("mobilenumber");
		String m=d.get("mobile").toString();
		userMobile.setText(m);
		userMobile.setHorizontalAlignment(SwingConstants.CENTER);
		userMobile.setFont(new Font("Tahoma", Font.PLAIN, 20));
		userMobile.setBounds(453, 375, 217, 37);
		contentPane.add(userMobile);
	}
}
