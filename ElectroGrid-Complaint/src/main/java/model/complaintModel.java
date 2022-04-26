package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import connection.DBConnect;

public class complaintModel {
	
	private int success;
	
	//insert function 
	public void addComplaint(String account_number,String name,String phone,String email,String complaintType,String subject,String massage) {
		Connection connection;
		PreparedStatement preparedStatement;
		
		try {
			connection = DBConnect.getDBConnection();
			
			//insert value into db
			preparedStatement = connection.prepareStatement("insert into complaint (account_number,name,phone,email,complaintType,subject,massage) values (?,?,?,?,?,?,?)");
			preparedStatement.setString(1, account_number);
			preparedStatement.setString(2, name);
			preparedStatement.setString(3, phone);
			preparedStatement.setString(4, email);
			preparedStatement.setString(5, complaintType);
			preparedStatement.setString(6, subject);
			preparedStatement.setString(7, massage);
			preparedStatement.execute();
			preparedStatement.close();
			connection.close();
			setSuccess(1);
		
		}catch (ClassNotFoundException | SQLException  e) {
			setSuccess(0);
			System.out.println(e.getMessage());
		}
	}

	public int getSuccess() {
		return success;
	}

	public void setSuccess(int success) {
		this.success = success;
	}
	
	//Data retrive function
	public String getComplaint() {
		
		Connection connection;
		PreparedStatement preparedStatement;
		String data="";
		
		try {
			connection = DBConnect.getDBConnection();
			preparedStatement = connection.prepareStatement("SELECT * FROM complaint");
			
			ResultSet resultSet = preparedStatement.executeQuery();
			
			data = "<table><thead>"
		            +"<tr>"
		            +"<th>ID</th>"
	                +"<th>Account Number</th>"
	                +"<th>Name</th>"
	                +"<th>Phone</th>"
	                +"<th>Email</th>"
	                +"<th>Complaint Type</th>"
	                +"<th>Subject</th>"
	                +"<th>Massage</th>"
	                +"<th>Action</th>"
	                +"</tr>"
	            +"</thead><tbody>";
			
			while (resultSet.next()) {
				
				String button = "<button type='button' onclick=''>Delete</button>";
				
				data = data+"<tr><td>"+resultSet.getString(1)+"</td>"
						+ "<td>"+resultSet.getString(2)+"</td>"
						+ "<td>"+resultSet.getString(3)+"</td>"
						+ "<td>"+resultSet.getString(4)+"</td>"
						+ "<td>"+resultSet.getString(5)+"</td>"
						+ "<td>"+resultSet.getString(6)+"</td>"
						+ "<td>"+resultSet.getString(7)+"</td>"
						+ "<td>"+resultSet.getString(8)+"</td>"
						+ "<td>"+button+"</td>"
					  + "</tr>";
				
			}
			
			preparedStatement.close();
			connection.close();
			
		}catch (ClassNotFoundException | SQLException  e) {

			System.out.println(e.getMessage());
		}
		
		return data+"</table>";
	}
	
	//Update function
	public void editComplaint(int id,String account_number,String name,String phone,String email,String complaintType,String subject,String massage) {
		Connection connection;
		PreparedStatement preparedStatement;
		
		try {
			connection = DBConnect.getDBConnection();
			
				//update value and query parts
				preparedStatement = connection.prepareStatement("UPDATE complaint SET account_number=?,name=?,phone=?,email=?,complaintType=?,subject=?,massage=? where id=?");
				preparedStatement.setString(1, account_number);
				preparedStatement.setString(2, name);
				preparedStatement.setString(3, phone);
				preparedStatement.setString(4, email);
				preparedStatement.setString(5, complaintType);
				preparedStatement.setString(6, subject);
				preparedStatement.setString(7, massage);
				preparedStatement.setInt(8,id);
				preparedStatement.execute();
				preparedStatement.close();
				connection.close();
				setSuccess(1);
				
		
		}catch (ClassNotFoundException | SQLException  e) {
			setSuccess(0);
			System.out.println(e.getMessage());
		}
	}

	//Delete function
	public void deleteComplaint(int id) {
		Connection connection;
		PreparedStatement preparedStatement;
		
		try {
			connection = DBConnect.getDBConnection();
			
			//delete complaint query
			preparedStatement = connection.prepareStatement("DELETE FROM complaint WHERE id=?");
			preparedStatement.setInt(1, id);
			preparedStatement.execute();
			
			setSuccess(1);
		
		}catch (ClassNotFoundException | SQLException  e) {
			setSuccess(0);
		}
	}
	
}
