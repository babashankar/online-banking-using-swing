package javaProject;

import static com.mongodb.client.model.Filters.eq;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class Register extends JFrame {

	private JPanel contentPane;
	private JTextField userName;
	private JTextField password;
	private JTextField mobile;
	private JTextField fullName;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Register frame = new Register();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Register() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 605, 640);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(204, 51, 204));
		contentPane.setForeground(new Color(204, 51, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel userNameLabel = new JLabel("Username");
		userNameLabel.setForeground(Color.WHITE);
		userNameLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		userNameLabel.setBounds(122, 182, 92, 13);
		contentPane.add(userNameLabel);
		
		userName = new JTextField();
		userName.setBounds(207, 175, 230, 31);
		contentPane.add(userName);
		userName.setColumns(10);
		
		JLabel lblFullname = new JLabel("Fullname");
		lblFullname.setForeground(Color.WHITE);
		lblFullname.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblFullname.setBounds(122, 232, 92, 13);
		contentPane.add(lblFullname);
		
		fullName = new JTextField();
		fullName.setColumns(10);
		fullName.setBounds(207, 225, 230, 31);
		contentPane.add(fullName);
		
		JLabel passwordLabel = new JLabel("Password");
		passwordLabel.setForeground(Color.WHITE);
		passwordLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		passwordLabel.setBounds(122, 297, 73, 13);
		contentPane.add(passwordLabel);
		
		password = new JTextField();
		password.setBounds(207, 284, 230, 31);
		contentPane.add(password);
		password.setColumns(10);
		
		JLabel mobileLabel = new JLabel("Mobile");
		mobileLabel.setForeground(Color.WHITE);
		mobileLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		mobileLabel.setBounds(122, 346, 45, 13);
		contentPane.add(mobileLabel);
		
		mobile = new JTextField();
		mobile.setBounds(207, 339, 230, 31);
		contentPane.add(mobile);
		mobile.setColumns(10);
		
		JLabel cityLabel = new JLabel("City");
		cityLabel.setForeground(Color.WHITE);
		cityLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cityLabel.setBounds(122, 403, 45, 13);
		contentPane.add(cityLabel);
		
		JList list = new JList();
		list.setBounds(207, 415, 1, 1);
		contentPane.add(list);
		
		final JComboBox citySelect = new JComboBox();
		citySelect.setFont(new Font("Tahoma", Font.PLAIN, 14));
		citySelect.setModel(new DefaultComboBoxModel(new String[] {"Bangalore", "Chennai", "Hyderabad"}));
		citySelect.setBounds(208, 389, 229, 31);
		contentPane.add(citySelect);
		
		JButton regBtn = new JButton("Register");
		regBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MongoClient mongoClient = new MongoClient("localhost",27017);
				MongoDatabase db = mongoClient.getDatabase("BankUsersDB");
				MongoCollection<Document> collection=db.getCollection("userLogin");
				String u=userName.getText();
				String p=password.getText();
				String m=mobile.getText();
				String f=fullName.getText();
				String c=citySelect.getSelectedItem().toString();
				;
				Document d=collection.find(eq("username",u)).first();
				if (d!=null) {
					JOptionPane.showMessageDialog(new JFrame(), "User exists","Select different username",JOptionPane.ERROR_MESSAGE);
				}
				else {
					Document doc =new Document("username",u);
					doc.append("Fullname",f);
					doc.append("password",p);  
					doc.append("mobile",m);  
					doc.append("city",c);
					doc.append("balance",500.0);
					collection.insertOne(doc);
					JOptionPane.showMessageDialog(new JFrame(), "Success","Registration Successful",JOptionPane.OK_OPTION);
					Document req=collection.find(eq("username",u)).first();
					Welcome frame = new Welcome(req);
					frame.setVisible(true);
					dispose();
					mongoClient.close();
					
				}
				
			}
		});
		regBtn.setFont(new Font("Tahoma", Font.PLAIN, 14));
		regBtn.setBounds(135, 465, 253, 21);
		contentPane.add(regBtn);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\NANI\\Downloads\\ibanking (611 \u00D7 73 px) (1).png"));
		lblNewLabel.setBounds(0, 0, 591, 73);
		contentPane.add(lblNewLabel);
		
		
	}
}
