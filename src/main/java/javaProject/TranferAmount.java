package javaProject;

import static com.mongodb.client.model.Filters.eq;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;

public class TranferAmount  {
	Document d;
	
	public TranferAmount(Document d) {
		
		this.d=d;
		
		
	}
	public void initiateTransaction(String username,String password,double amount) {
		@SuppressWarnings("resource")
		MongoClient mongoClient = new MongoClient("localhost",27017);
		MongoDatabase db = mongoClient.getDatabase("BankUsersDB");
		MongoCollection<Document> collection=db.getCollection("userLogin");
		MongoCollection<Document> transCollection=db.getCollection("Transactions");
		Document req=collection.find(eq("username",d.get("username"))).first();
		
		
		
		Document ben=collection.find(eq("username",username)).first();
		double b=req.getDouble("balance");
		double benamt=ben.getDouble("balance");
		if(ben!=null || username.equals(req.get("username"))) {
			if(password.equals(d.get("password"))) {
				
				if(b>=amount) {
					DateTimeFormatter dtf=DateTimeFormatter.ofPattern("yyy/MM/dd HH:mm:ss");
					LocalDateTime now=LocalDateTime.now();
					
					
					JOptionPane.showMessageDialog(new JFrame(), "Confirm Transaction","",JOptionPane.OK_CANCEL_OPTION);
					collection.updateOne(Filters.eq("username",d.get("username")), Updates.set("balance",b-amount));
					collection.updateOne(Filters.eq("username",ben.get("username")), Updates.set("balance",benamt+amount));
					Document doc =new Document("username",d.get("username"));
					doc.append("Timestamp",dtf.format(now));
					doc.append("Ttype","debit");
					doc.append("Amount",amount);
					doc.append("Log","Sent to "+username);
					doc.append("balance",b-amount);
					transCollection.insertOne(doc);
					Document doc2 =new Document("username",username);
					doc2.append("Timestamp",dtf.format(now));
					doc2.append("Ttype","credit");
					doc2.append("Amount",amount);
					doc2.append("Log","Received from "+username);
					doc2.append("balance",benamt+amount);
					transCollection.insertOne(doc2);
					JOptionPane.showMessageDialog(new JFrame(), "Transaction Successful","Success",JOptionPane.INFORMATION_MESSAGE);
						
				}
				else {
					JOptionPane.showMessageDialog(new JFrame(), "Insufficient Balance","",JOptionPane.ERROR_MESSAGE);
					
				}
		
				
			}
			else {
				JOptionPane.showMessageDialog(new JFrame(),"Password Mismatch","Error",JOptionPane.ERROR_MESSAGE);
				
				}
		}
		else {
			JOptionPane.showMessageDialog(new JFrame(), "User does not exists","Error",JOptionPane.ERROR_MESSAGE);
		}
		
		
	}
	

}
