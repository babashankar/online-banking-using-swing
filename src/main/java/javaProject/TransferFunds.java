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
		setBounds(100, 100, 741, 411);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel benUserLabel = new JLabel("Benefeciary Username");
		benUserLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		benUserLabel.setHorizontalAlignment(SwingConstants.CENTER);
		benUserLabel.setBounds(108, 127, 171, 58);
		contentPane.add(benUserLabel);
		
		benUsername = new JTextField();
		benUsername.setBounds(289, 143, 242, 31);
		contentPane.add(benUsername);
		benUsername.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Amount");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(165, 205, 128, 13);
		contentPane.add(lblNewLabel);
		
		amount = new JTextField();
		amount.setBounds(289, 198, 242, 31);
		contentPane.add(amount);
		amount.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Confirm Password");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_1.setBounds(132, 266, 134, 13);
		contentPane.add(lblNewLabel_1);
		
		cpass = new JTextField();
		cpass.setBounds(289, 258, 242, 33);
		contentPane.add(cpass);
		cpass.setColumns(10);
		
		JButton confirm = new JButton("Confirm");
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
		confirm.setBounds(221, 325, 85, 21);
		contentPane.add(confirm);
		
		JButton cancel = new JButton("Cancel");
		cancel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		cancel.setBounds(360, 325, 85, 21);
		contentPane.add(cancel);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 102, 204));
		panel.setBounds(0, 0, 727, 64);
		contentPane.add(panel);
		
		JLabel lblNewLabel_2 = new JLabel("TRANSFER FUNDS");
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setBackground(new Color(255, 255, 255));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 30));
		panel.add(lblNewLabel_2);
	}
}
