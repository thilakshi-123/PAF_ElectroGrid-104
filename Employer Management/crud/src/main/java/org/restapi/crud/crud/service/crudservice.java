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

	//database  connection
	public crudservice(){
		
		try {
			String url ="jdbc:mysql://localhost:3306/employers_eg";
			String uname ="root";
			String pwd = "";
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url,uname,pwd);
			
		} catch(Exception e) {
			System.out.println(e +" data insert unsuccess.");
		}
	}

	
	public crudmodel insertEmp(crudmodel emp) {
		String insert = "insert into employers (empid,nic,name,address,dept,contact) values(?,?,?,?,?,?) ";
		
		try {
			PreparedStatement ps = con.prepareStatement(insert);
			ps.setLong(1, emp.getEmpid());
			ps.setLong(2, emp.getNic());
			ps.setString(3, emp.getName());
			ps.setString(4, emp.getAddress());
			ps.setString(5, emp.getDept());
			ps.setLong(6, emp.getContact());
			
			ps.execute();
		}catch(Exception e) {
			System.out.println(e +"data insert unsuccess.");
		}
		
		return emp;
		
	}
	
	public ArrayList<crudmodel> getEmp() throws SQLException{
		
		ArrayList<crudmodel> data = new ArrayList<crudmodel>();
		
		String select = "select * from employers";
		PreparedStatement ps = con.prepareStatement(select);
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			crudmodel model = new crudmodel();
			
			model.setEmpid(rs.getInt("empid"));
			model.setNic(rs.getInt("nic"));
			model.setName(rs.getString("name")); // column name	
			model.setAddress(rs.getString("address"));
			model.setDept(rs.getString("dept"));
			model.setContact(rs.getInt("Contact"));
			
			data.add(model);
			
		}
		
		return data;
		
	}
	
	
	public ArrayList<crudmodel> getEmpById(int empid) throws SQLException{
		
		ArrayList<crudmodel> data = new ArrayList<crudmodel>();
		String select = "select * from employers where empid =?";
		PreparedStatement ps = con.prepareStatement(select);
		ps.setInt(1,empid);
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			crudmodel model = new crudmodel();
			
			model.setEmpid(rs.getInt("empid"));
			model.setNic(rs.getInt("nic"));
			model.setName(rs.getString("name")); // column name	
			model.setAddress(rs.getString("address"));
			model.setDept(rs.getString("dept"));
			model.setContact(rs.getInt("Contact"));
			
			data.add(model);		
		}		
		return data;	
	}
	
	public crudmodel updateEmp(crudmodel emp) {
		String insert = "update employers set nic=? , name=? , address=?,dept=?, contact=? where empid=?";
		
		try {
			PreparedStatement ps = con.prepareStatement(insert);

			
			ps.setLong(1, emp.getNic());
			ps.setString(2, emp.getName());
			ps.setString(3, emp.getAddress());
			ps.setString(4, emp.getDept());
			ps.setLong(5, emp.getContact());
			ps.setLong(6, emp.getEmpid());
		
			
			ps.executeUpdate();
		}catch(Exception e) {
			System.out.println(e +"data insert unsuccess.");
		}
		
		return emp;
		
	}
	

	public String deletetEmp(int empid) {
		String output = "";
		String insert = "delete from employers where empid =?";
		
		try {
			PreparedStatement ps = con.prepareStatement(insert);
			ps.setInt(1,empid);
			ps.executeUpdate();
			 output = "Deleted successfully";
		}catch(Exception e) {
			System.out.println(e +"data insert unsuccess.");
		}
		
		return output;
		
	}
	
	


}

