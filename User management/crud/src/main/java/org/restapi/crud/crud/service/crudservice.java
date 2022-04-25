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
			String url ="jdbc:mysql://localhost:3306/users";
			String uname ="root";
			String pwd = "";
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url,uname,pwd);
			
		} catch(Exception e) {
			System.out.println(e +" data insert unsuccess.");
		}
	}

	
	public crudmodel insertUser(crudmodel user) {
		String insert = "insert into person(userid,nic,name,address,contact) values(?,?,?,?,?) ";
		
		try {
			PreparedStatement ps = con.prepareStatement(insert);
			ps.setLong(1, user.getUserid());
			ps.setLong(2, user.getNic());
			ps.setString(3, user.getName());
			ps.setString(4, user.getAddress());
			ps.setLong(5, user.getContact());
			
			ps.execute();
		}catch(Exception e) {
			System.out.println(e +"data insert unsuccess.");
		}
		
		return user;
		
	}
	
	public ArrayList<crudmodel> getUser() throws SQLException{
		
		ArrayList<crudmodel> data = new ArrayList<crudmodel>();
		
		String select = "select * from person";
		PreparedStatement ps = con.prepareStatement(select);
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			crudmodel model = new crudmodel();
			
			model.setUserid(rs.getInt("userid"));
			model.setNic(rs.getInt("nic"));
			model.setName(rs.getString("name")); // column name	
			model.setAddress(rs.getString("address"));
			model.setContact(rs.getInt("Contact"));
			
			data.add(model);
			
		}
		
		return data;
		
	}
	
	
	public ArrayList<crudmodel> getUserById(int userid) throws SQLException{
		
		ArrayList<crudmodel> data = new ArrayList<crudmodel>();
		String select = "select * from person where userid =?";
		PreparedStatement ps = con.prepareStatement(select);
		ps.setInt(1,userid);
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			crudmodel model = new crudmodel();
			
			model.setUserid(rs.getInt("userid"));
			model.setNic(rs.getInt("nic"));
			model.setName(rs.getString("name")); // column name	
			model.setAddress(rs.getString("address"));
			model.setContact(rs.getInt("Contact"));
			
			data.add(model);		
		}		
		return data;	
	}
	
	public crudmodel updatetUser(crudmodel user) {
		String insert = "update person set nic=? , name=? , address=?, contact=? where userid=?";
		
		try {
			PreparedStatement ps = con.prepareStatement(insert);

			ps.setLong(1, user.getNic());
			ps.setString(2, user.getName());
			ps.setString(3, user.getAddress());
			ps.setLong(4, user.getContact());
			ps.setLong(5, user.getUserid());
			
			ps.executeUpdate();
		}catch(Exception e) {
			System.out.println(e +"data insert unsuccess.");
		}
		
		return user;
		
	}
	

	public int deletetUser(int userid) {
		String insert = "delete from person where userid =?";
		
		try {
			PreparedStatement ps = con.prepareStatement(insert);
			ps.setInt(1,userid);
			
			ps.executeUpdate();
		}catch(Exception e) {
			System.out.println(e +"data insert unsuccess.");
		}
		
		return userid;
		
	}
	
	


}

