package javaProject;

import static com.mongodb.client.model.Filters.eq;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import java.awt.Font;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JScrollPane;

public class Transactions extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
		

	/**
	 * Create the frame.
	 */
	public Transactions(Document d) {
		@SuppressWarnings("resource")
		MongoClient mongoClient = new MongoClient("localhost",27017);
		MongoDatabase db = mongoClient.getDatabase("BankUsersDB");
		MongoCollection<Document> collection=db.getCollection("userLogin");
		MongoCollection<Document> transCollection=db.getCollection("Transactions");
		Document req=collection.find(eq("username",d.get("username"))).first();
		String[][] trans= new String[11][6];
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 913, 284);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		int i=1;
		trans[0][0]="Transaction id";
		;
		trans[0][1]="Time";
		trans[0][2]="Transaction type";
		trans[0][3]="Amount";
		trans[0][4]="Log";
		trans[0][5]="balance";
		
		
		
		MongoCursor<Document> cursor = transCollection.find(eq("username",req.get("username"))).iterator();
        while (cursor.hasNext() && i<10) {
        	Document f=cursor.next();
            trans[i][0]=f.getObjectId("_id").toString();
           
            trans[i][1]=f.get("Timestamp").toString();
            trans[i][2]=f.get("Ttype").toString();
            trans[i][3]=f.get("Amount").toString();
            trans[i][4]=f.get("Log").toString();
            trans[i][5]=f.get("balance").toString();
            i+=1;
            
        }

		
		table = new JTable();
		table.setFont(new Font("Tahoma", Font.PLAIN, 10));
		table.setModel(new DefaultTableModel(
			trans,
			new String[] {
				"Transaction id", "Time", "Transaction type", "amount", "Log", "Balance"
			}
		));
		table.setBounds(25, 68, 844, 176);
		contentPane.add(table);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(276, 64, 2, 2);
		contentPane.add(scrollPane);
		
	
	}
}
