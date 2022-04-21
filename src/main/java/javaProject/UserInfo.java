package javaProject;

import static com.mongodb.client.model.Filters.eq;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class UserInfo {
	public UserInfo(Document d) {
		@SuppressWarnings("resource")
		MongoClient mongoClient = new MongoClient("localhost",27017);
		MongoDatabase db = mongoClient.getDatabase("BankUsersDB");
		MongoCollection<Document> collection=db.getCollection("userLogin");
		Document req=collection.find(eq("username",d.get("username"))).first();
		JOptionPane.showMessageDialog(new JFrame(),"username:   "+req.get("username")+"\nFullname:  "+req.get("Fullname")+"\nMobile:     "+req.get("mobile")+"\nLocation:   "+req.get("city")+"\nBalance:    "+req.get("balance"),"User Details",JOptionPane.INFORMATION_MESSAGE);
		
	}

}
