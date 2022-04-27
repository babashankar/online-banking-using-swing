package javaProject;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import static com.mongodb.client.model.Filters.eq;

import java.io.File;
import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

public class PrintTranscations {
	public PrintTranscations(Document d) {
		XSSFWorkbook workbook = new XSSFWorkbook();
		 
        
        MongoClient mongoClient = new MongoClient("localhost",27017);
		MongoDatabase db = mongoClient.getDatabase("BankUsersDB");
		MongoCollection<Document> collection=db.getCollection("userLogin");
		MongoCollection<Document> transCollection=db.getCollection("Transactions");
		Document req=collection.find(eq("username",d.get("username"))).first();
		// Create a spreadsheet inside a workbook
        XSSFSheet spreadsheet1
            = workbook.createSheet("transcations");
        XSSFRow row = spreadsheet1.createRow(1);
        XSSFCell cell;
 
        // Step 6: Process the results
        cell = row.createCell(1);
        cell.setCellValue("Transcation id");
        cell = row.createCell(2);
        cell.setCellValue("Time");
        cell = row.createCell(3);
        cell.setCellValue("Transaction Type");
        cell = row.createCell(4);
        cell.setCellValue("Amount");
        cell = row.createCell(5);
        cell.setCellValue("Log");
        cell = row.createCell(6);
        cell.setCellValue("Balance");
        int i = 2;
        MongoCursor<Document> cursor = transCollection.find(eq("username",req.get("username"))).iterator();
        while (cursor.hasNext()) {
        	Document f=cursor.next();
            row = spreadsheet1.createRow(i);
            cell = row.createCell(1);
            cell.setCellValue(f.getObjectId("_id").toString());
 
            cell = row.createCell(2);
            cell.setCellValue(f.get("Timestamp").toString());
            cell = row.createCell(3);
            cell.setCellValue(f.get("Ttype").toString());
            cell = row.createCell(4);
            cell.setCellValue(f.getDouble("Amount"));
            cell = row.createCell(5);
            cell.setCellValue(f.get("Log").toString());
            cell = row.createCell(6);
            cell.setCellValue(f.getDouble("balance"));
            
 
            i++;
        }
        FileOutputStream output = null;
		try {
			output = new FileOutputStream(new File(
					"C:\\Users\\NANI\\Documents\\eclipse workspace\\javaProject\\transcation sheets\\"+d.getString("username")+"'sTransactions.xlsx"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
     
            // write
            try {
				workbook.write(output);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
     
            // Step 7: Close the connection
            try {
				output.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
 System.out.println("Excel sheet created");	
 JOptionPane.showMessageDialog(new JFrame(), "Trasactions report generated","",JOptionPane.PLAIN_MESSAGE);
	}
	

}
