package javaProject;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import org.bson.Document;

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
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel topmenu = new JLabel("");
		topmenu.setIcon(new ImageIcon("C:\\Users\\NANI\\Downloads\\ibanking.png"));
		topmenu.setBounds(0, 0, 857, 84);
		contentPane.add(topmenu);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 102, 204));
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
		userInfo.setBackground(new Color(0, 102, 204));
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
		fundsTransfer.setBackground(new Color(0, 102, 204));
		fundsTransfer.setBounds(0, 91, 243, 29);
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
		editDetails.setBackground(new Color(0, 102, 204));
		editDetails.setBounds(0, 130, 243, 29);
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
		recTransactions.setBackground(new Color(0, 102, 204));
		recTransactions.setBounds(0, 169, 243, 29);
		panel.add(recTransactions);
		
		JButton printSmt = new JButton("Print Statement");
		printSmt.setForeground(new Color(255, 250, 250));
		printSmt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PrintTranscations pt=new PrintTranscations(d);
				
			}
		});
		printSmt.setFont(new Font("Tahoma", Font.PLAIN, 14));
		printSmt.setBackground(new Color(0, 102, 204));
		printSmt.setBounds(0, 208, 243, 29);
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
		btnLogout.setBackground(new Color(0, 102, 204));
		btnLogout.setBounds(0, 474, 243, 29);
		panel.add(btnLogout);
		String u=d.get("username").toString();
		String m=d.get("mobile").toString();
		recTransactions.setBorder(BorderFactory.createLineBorder(Color.WHITE,1));
		userInfo.setBorder(BorderFactory.createLineBorder(Color.WHITE,1));
		fundsTransfer.setBorder(BorderFactory.createLineBorder(Color.WHITE,1));
		recTransactions.setBorder(BorderFactory.createLineBorder(Color.WHITE,1));
		printSmt.setBorder(BorderFactory.createLineBorder(Color.WHITE,1));
		btnLogout.setBorder(BorderFactory.createLineBorder(Color.WHITE,1));
		editDetails.setBorder(BorderFactory.createLineBorder(Color.WHITE,1));
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\NANI\\Downloads\\Untitled design (1).png"));
		lblNewLabel.setBounds(439, 112, 253, 197);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("BANKING MADE SIMPLE.");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblNewLabel_1.setBounds(418, 286, 302, 89);
		contentPane.add(lblNewLabel_1);
		
		
		
		
	}
	
}
