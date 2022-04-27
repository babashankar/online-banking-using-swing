package javaProject;

import static com.mongodb.client.model.Filters.eq;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import javax.swing.ImageIcon;

public class EditDetails extends JFrame {

	private JPanel contentPane;
	private JTextField cName;
	private JTextField cMobile;
	private JTextField cCity;
	private JTextField cpass;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	Document d;
	public EditDetails(Document d) {
		this.d=d;
		MongoClient mongoClient = new MongoClient("localhost",27017);
		MongoDatabase db = mongoClient.getDatabase("BankUsersDB");
		final MongoCollection<Document> collection=db.getCollection("userLogin");
		final Document req=collection.find(eq("username",d.get("username"))).first();
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 836, 475);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Name");
		lblNewLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(30, 129, 117, 13);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Mobile");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(30, 180, 124, 13);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("City");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(10, 240, 124, 13);
		contentPane.add(lblNewLabel_2);
		
		cName = new JTextField();
		cName.setBounds(164, 121, 229, 34);
		contentPane.add(cName);
		cName.setColumns(10);
		cName.setText((req.getString("Fullname")));
		
		cMobile = new JTextField();
		cMobile.setBounds(164, 172, 229, 34);
		contentPane.add(cMobile);
		cMobile.setColumns(10);
		cMobile.setText(req.getString("mobile"));
		
		
		cCity = new JTextField();
		cCity.setBounds(164, 232, 229, 34);
		contentPane.add(cCity);
		cCity.setColumns(10);
		cCity.setText(req.getString("city"));
		
		JLabel lblNewLabel_3 = new JLabel("confirm password");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(30, 300, 170, 13);
		contentPane.add(lblNewLabel_3);
		
		cpass = new JTextField();
		cpass.setColumns(10);
		cpass.setBounds(164, 292, 229, 34);
		contentPane.add(cpass);
		
		JButton editBtn = new JButton("Edit");
		editBtn.setFont(new Font("Tahoma", Font.PLAIN, 14));
		editBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name=cName.getText();
				String city=cCity.getText();
				String mobile=cMobile.getText();
				String p=cpass.getText();
				if (mobile.length()!=10) {
					JOptionPane.showMessageDialog(new JFrame(),"Invalid phone number","Error",JOptionPane.ERROR_MESSAGE);
					
				}
				else {
				if (p.equals(req.getString("password"))) {
					int res=JOptionPane.showConfirmDialog(new JFrame(), "Confirm Edit","",JOptionPane.YES_NO_OPTION);
					if (res==0) {
						collection.updateMany(
							    Filters.eq("username", req.getString("username")),
							    Updates.combine(
							        Updates.set("Fullname",name),
							        Updates.set("city", city),
							        Updates.set("mobile", mobile)
							    ));
						JOptionPane.showMessageDialog(new JFrame(), "Edit Successful","Success",JOptionPane.INFORMATION_MESSAGE);
						
					}
					
				}
				else {
					JOptionPane.showMessageDialog(new JFrame(),"Password Mismatch","Error",JOptionPane.ERROR_MESSAGE);
				}
			}}
		});
		editBtn.setBounds(93, 365, 85, 21);
		contentPane.add(editBtn);
		
		JButton cancel = new JButton("Cancel");
		cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();	
				
			}
		});
		cancel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cancel.setBounds(231, 367, 85, 21);
		contentPane.add(cancel);
		
		JLabel lblNewLabel_4 = new JLabel("EDIT");
		lblNewLabel_4.setBounds(343, 10, 94, 46);
		contentPane.add(lblNewLabel_4);
		lblNewLabel_4.setForeground(new Color(0, 0, 0));
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 30));
		
		JLabel lblNewLabel_5 = new JLabel("New label");
		lblNewLabel_5.setIcon(new ImageIcon("C:\\Users\\NANI\\Documents\\eclipse workspace\\javaProject\\icons\\edit.png"));
		lblNewLabel_5.setBounds(500, 94, 291, 292);
		contentPane.add(lblNewLabel_5);
		
	}
}
