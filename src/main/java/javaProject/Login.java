package javaProject;

import static com.mongodb.client.model.Filters.eq;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import java.awt.Toolkit;
import javax.swing.SwingConstants;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField userName;
	private JPasswordField password;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\NANI\\Documents\\eclipse workspace\\javaProject\\icons\\favicon-32x32.png"));
		setFont(new Font("Calibri", Font.PLAIN, 14));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1048, 570);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(255, 255, 255));
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Username");
		lblNewLabel.setBounds(62, 218, 90, 25);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setForeground(new Color(0, 0, 0));
		contentPane.add(lblNewLabel);
		
		userName = new JTextField();
		userName.setBounds(175, 219, 185, 25);
		userName.setForeground(new Color(204, 51, 204));
		contentPane.add(userName);
		userName.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setBounds(62, 282, 76, 13);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setForeground(new Color(0, 0, 0));
		contentPane.add(lblNewLabel_1);
		
		password = new JPasswordField();
		password.setBounds(175, 277, 185, 25);
		contentPane.add(password);
		
		JButton loginButton = new JButton("Login");
		loginButton.setForeground(new Color(255, 255, 255));
		loginButton.setBackground(new Color(0,0,0));
		loginButton.setBounds(108, 341, 85, 21);
		loginButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String u=userName.getText();
				String p=String.valueOf(password.getPassword());
				MongoClient mongoClient = new MongoClient("localhost",27017);
				MongoDatabase db = mongoClient.getDatabase("BankUsersDB");
				MongoCollection<Document> collection=db.getCollection("userLogin");
				Document d=collection.find(eq("username",u)).first();
				if(d==null) {
					JOptionPane.showMessageDialog(new JFrame(), "user not exits","user not exists",JOptionPane.ERROR_MESSAGE);
				}
				else if (d.get("password").equals(p)) {
					Welcome frame = new Welcome(d);
					frame.setVisible(true);
					dispose();
				}
				else {
					JOptionPane.showMessageDialog(new JFrame(), "Wrong Password","Password did not match",JOptionPane.ERROR_MESSAGE);
				}
				
				
				mongoClient.close();
				
				
			}
		});
		contentPane.add(loginButton);
		
		JButton resetButton = new JButton("Reset");
		resetButton.setForeground(new Color(255, 255, 255));
		resetButton.setBackground(new Color(0,0,0));
		resetButton.setBounds(222, 341, 85, 21);
		resetButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		resetButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				userName.setText("");
				password.setText("");
			}
		});
		contentPane.add(resetButton);
		
		JButton registerBtn = new JButton("New user? Register.");
		registerBtn.setForeground(new Color(255, 255, 255));
		registerBtn.setBackground(new Color(0,0,0));
		registerBtn.setFont(new Font("Tahoma", Font.PLAIN, 14));
		registerBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Register frame = new Register();
				frame.setVisible(true);
				dispose();
			}
			
		});
		registerBtn.setBounds(123, 405, 171, 21);
		contentPane.add(registerBtn);
		
		JLabel lblNewLabel_2 = new JLabel("Login");
		lblNewLabel_2.setBackground(new Color(0, 0, 0));
		lblNewLabel_2.setBounds(424, 10, 97, 43);
		contentPane.add(lblNewLabel_2);
		lblNewLabel_2.setForeground(new Color(0, 0, 0));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 35));
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\NANI\\Documents\\eclipse workspace\\javaProject\\icons\\login.png"));
		lblNewLabel_3.setBounds(582, 98, 414, 435);
		contentPane.add(lblNewLabel_3);
	}
}
