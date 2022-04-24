package org.restapi.crud.crud.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import org.restapi.crud.crud.model.crudmodel;

public class crudservice {
	
	Connection con;

	
	public crudservice(){
		
		try {
			String url ="jdbc:mysql://localhost:3306/payments";
			String uname ="root";
			String pwd = "";
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url,uname,pwd);
			
		} catch(Exception e) {
			System.out.println(e +" data insert unsuccess.");
		}
	}

	
	public crudmodel insertPayment(crudmodel payment) {
		String insert = "insert into payment(paymentId,amount,cardNo,cardHolder,cvv,expDate) values(?,?,?,?,?,?) ";
		
		try {
			PreparedStatement ps = con.prepareStatement(insert);
			ps.setLong(1, payment.getPaymentId());
			ps.setLong(2, payment.getAmount());
			ps.setString(3, payment.getCardNo());
			ps.setString(4, payment.getCardHolder());
			ps.setLong(5, payment.getCvv());
			ps.setString(6, payment.getExpDate());
			
			ps.execute();
		}catch(Exception e) {
			System.out.println(e +"data insert unsuccess.");
		}
		
		return payment;
		
	}
	
	
	
public ArrayList<crudmodel> getPayment() throws SQLException{
		
		ArrayList<crudmodel> data = new ArrayList<crudmodel>();
		
		String select = "select * from payment";
		PreparedStatement ps = con.prepareStatement(select);
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			crudmodel model = new crudmodel();
			
			model.setPaymentId(rs.getInt("paymentId"));
			model.setAmount(rs.getInt("amount"));
			model.setCardNo(rs.getString("cardNo")); // column name	
			model.setCardHolder(rs.getString("cardHolder"));
			model.setCvv(rs.getInt("cvv"));
			model.setExpDate(rs.getString("expDate"));
			
			data.add(model);
			
		}
		
		return data;
		
	}


public crudmodel updatetPayment(crudmodel payment) {
	String update = "update payment set amount=? , cardNo=? , cardHolder=?, cvv=?, expDate=? where paymentId=?";
	
	try {
		PreparedStatement ps = con.prepareStatement(update);

		
		ps.setLong(1, payment.getAmount());
		ps.setString(2, payment.getCardNo());
		ps.setString(3, payment.getCardHolder());
		ps.setLong(4, payment.getCvv());
		ps.setString(5, payment.getExpDate());
		ps.setLong(6, payment.getPaymentId());
		
		ps.executeUpdate();
	}catch(Exception e) {
		System.out.println(e +"data update unsuccess.");
	}
	
	return payment;
	
}

public int deletetPayment(int paymentId) {
	String delete = "delete from payment where paymentId =?";
	
	try {
		PreparedStatement ps = con.prepareStatement(delete);
		ps.setInt(1,paymentId);
		
		ps.executeUpdate();
	}catch(Exception e) {
		System.out.println(e +"data delete unsuccess.");
	}
	
	return paymentId;
	
}

public ArrayList<crudmodel> getPaymentById(int paymentId) throws SQLException{
	
	ArrayList<crudmodel> data = new ArrayList<crudmodel>();
	String select = "select * from payment where paymentId =?";
	PreparedStatement ps = con.prepareStatement(select);
	ps.setInt(1,paymentId);
	ResultSet rs = ps.executeQuery();
	
	while(rs.next()) {
		crudmodel model = new crudmodel();
		
		model.setPaymentId(rs.getInt("paymentId"));
		model.setAmount(rs.getInt("amount"));
		model.setCardNo(rs.getString("cardNo")); // column name	
		model.setCardHolder(rs.getString("cardHolder"));
		model.setCvv(rs.getInt("cvv"));
		model.setExpDate(rs.getString("expDate"));
		
		data.add(model);		
	}		
	return data;	
}

}
