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
		setBounds(100, 100, 728, 541);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Name");
		lblNewLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(125, 181, 117, 13);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Mobile");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(125, 232, 124, 13);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("City");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(105, 292, 124, 13);
		contentPane.add(lblNewLabel_2);
		
		cName = new JTextField();
		cName.setBounds(259, 173, 229, 34);
		contentPane.add(cName);
		cName.setColumns(10);
		cName.setText((req.getString("Fullname")));
		
		cMobile = new JTextField();
		cMobile.setBounds(259, 224, 229, 34);
		contentPane.add(cMobile);
		cMobile.setColumns(10);
		cMobile.setText(req.getString("mobile"));
		
		
		cCity = new JTextField();
		cCity.setBounds(259, 284, 229, 34);
		contentPane.add(cCity);
		cCity.setColumns(10);
		cCity.setText(req.getString("city"));
		
		JLabel lblNewLabel_3 = new JLabel("confirm password");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(125, 352, 170, 13);
		contentPane.add(lblNewLabel_3);
		
		cpass = new JTextField();
		cpass.setColumns(10);
		cpass.setBounds(259, 344, 229, 34);
		contentPane.add(cpass);
		
		JButton editBtn = new JButton("Edit");
		editBtn.setFont(new Font("Tahoma", Font.PLAIN, 14));
		editBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name=cName.getText();
				String city=cCity.getText();
				String mobile=cMobile.getText();
				String p=cpass.getText();
				if (p.equals(req.getString("password"))) {
					JOptionPane.showMessageDialog(new JFrame(), "Confirm Edit?","",JOptionPane.OK_CANCEL_OPTION);
					collection.updateMany(
						    Filters.eq("username", req.getString("username")),
						    Updates.combine(
						        Updates.set("Fullname",name),
						        Updates.set("city", city),
						        Updates.set("mobile", mobile)
						    ));
					JOptionPane.showMessageDialog(new JFrame(), "Edit Successful","Success",JOptionPane.INFORMATION_MESSAGE);
				}
				else {
					JOptionPane.showMessageDialog(new JFrame(),"Password Mismatch","Error",JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		editBtn.setBounds(188, 417, 85, 21);
		contentPane.add(editBtn);
		
		JButton cancel = new JButton("Cancel");
		cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();	
				
			}
		});
		cancel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cancel.setBounds(326, 419, 85, 21);
		contentPane.add(cancel);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 102, 204));
		panel.setBounds(0, 0, 714, 69);
		contentPane.add(panel);
		
		JLabel lblNewLabel_4 = new JLabel("EDIT");
		lblNewLabel_4.setForeground(new Color(255, 255, 255));
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 38));
		panel.add(lblNewLabel_4);
		
	}
}
