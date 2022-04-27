package javaProject;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import org.bson.Document;
import javax.swing.ImageIcon;

public class TransferFunds extends JFrame {

	private JPanel contentPane;
	private JTextField benUsername;
	private JTextField amount;
	private JTextField cpass;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	Document d;
	
	public TransferFunds(final Document d) {
		this.d=d;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 827, 411);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel benUserLabel = new JLabel("Benefeciary Username");
		benUserLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		benUserLabel.setHorizontalAlignment(SwingConstants.CENTER);
		benUserLabel.setBounds(10, 89, 171, 58);
		contentPane.add(benUserLabel);
		
		benUsername = new JTextField();
		benUsername.setBounds(191, 105, 242, 31);
		contentPane.add(benUsername);
		benUsername.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Amount");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(67, 167, 128, 13);
		contentPane.add(lblNewLabel);
		
		amount = new JTextField();
		amount.setBounds(191, 160, 242, 31);
		contentPane.add(amount);
		amount.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Confirm Password");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_1.setBounds(34, 228, 134, 13);
		contentPane.add(lblNewLabel_1);
		
		cpass = new JTextField();
		cpass.setBounds(191, 220, 242, 33);
		contentPane.add(cpass);
		cpass.setColumns(10);
		
		JButton confirm = new JButton("Confirm");
		confirm.setForeground(new Color(255, 255, 255));
		confirm.setBackground(new Color(0,0,0));
		confirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String u=benUsername.getText();
				String p=cpass.getText();
				double a=  Double.parseDouble(amount.getText()); 
				System.out.println(a);
				TranferAmount t=new TranferAmount(d);
						t.initiateTransaction(u,p,a);
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
			}
		});
		confirm.setFont(new Font("Tahoma", Font.PLAIN, 14));
		confirm.setBounds(123, 287, 85, 21);
		contentPane.add(confirm);
		
		JButton cancel = new JButton("Cancel");
		cancel.setBackground(new Color(0,0,0));
		cancel.setForeground(new Color(255, 255, 255));
		cancel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		cancel.setBounds(262, 287, 85, 21);
		contentPane.add(cancel);
		
		JLabel lblNewLabel_2 = new JLabel("TRANSFER FUNDS");
		lblNewLabel_2.setBounds(242, 10, 277, 37);
		contentPane.add(lblNewLabel_2);
		lblNewLabel_2.setForeground(new Color(0, 0, 0));
		lblNewLabel_2.setBackground(new Color(255, 255, 255));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 30));
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\NANI\\Documents\\eclipse workspace\\javaProject\\icons\\tarnfer amount.png"));
		lblNewLabel_3.setBounds(492, 47, 291, 256);
		contentPane.add(lblNewLabel_3);
	}
}
