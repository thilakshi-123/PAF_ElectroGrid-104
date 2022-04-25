package com.project.service;

import com.project.model.projectmodel;

import java.sql.*;
import java.util.ArrayList;

public class projectservice {
    Connection con;


    public projectservice(){

        try {
            String url ="jdbc:mysql://localhost:3306/electrogrid";
            String uname ="root";
            String pwd = "";

            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url,uname,pwd);

        } catch(Exception e) {
            System.out.println(e +" data insert unsuccess.");
        }
    }


    public projectmodel insertProject(projectmodel project) {
        String insert = "insert into project(projectId,projectName,description,startDate,endDate,budget,price,sponserId) values(?,?,?,?,?,?,?,?) ";

        try {
            PreparedStatement ps = con.prepareStatement(insert);
            ps.setLong(1, project.getProjectId());
            ps.setString(2, project.getProjectName());
            ps.setString(3, project.getDescription());
            ps.setString(4, project.getStartDate());
            ps.setString(5, project.getEndDate());
            ps.setLong(6, project.getBudget());
            ps.setLong(7, project.getPrice());
            ps.setString(8, project.getSponserId());

            ps.execute();
        }catch(Exception e) {
            System.out.println(e +"data insert unsuccess.");
        }

        return project;

    }

    public ArrayList<projectmodel> getProject() throws SQLException {

        ArrayList<projectmodel> data = new ArrayList<projectmodel>();

        String select = "select * from project";
        PreparedStatement ps = con.prepareStatement(select);
        ResultSet rs = ps.executeQuery();

        while(rs.next()) {
            projectmodel model = new projectmodel();

            model.setProjectId(rs.getInt("projectId"));
            model.setProjectName(rs.getString("projectName"));
            model.setDescription(rs.getString("description")); // column name
            model.setStartDate(rs.getString("startDate"));
            model.setEndDate(rs.getString("endDate"));
            model.setBudget(rs.getInt("budget"));
            model.setPrice(rs.getInt("price"));
            model.setSponserId(rs.getString("sponserId"));

            data.add(model);

        }

        return data;

    }


    public ArrayList<projectmodel> getProjectById(int projectId) throws SQLException{

        ArrayList<projectmodel> data = new ArrayList<projectmodel>();
        String select = "select * from project where projectId =?";
        PreparedStatement ps = con.prepareStatement(select);
        ps.setInt(1,projectId);
        ResultSet rs = ps.executeQuery();

        while(rs.next()) {
            projectmodel model = new projectmodel();

            model.setProjectId(rs.getInt("projectId"));
            model.setProjectName(rs.getString("projectName"));
            model.setDescription(rs.getString("description")); // column name
            model.setStartDate(rs.getString("startDate"));
            model.setEndDate(rs.getString("endDate"));
            model.setBudget(rs.getInt("budget"));
            model.setPrice(rs.getInt("price"));
            model.setSponserId(rs.getString("sponserId"));

            data.add(model);
        }
        return data;
    }

    public projectmodel updateProject(projectmodel project) {
        String insert = "update project set projectName=? , description=? , startDate=?, endDate=?, budget=?,price=?,sponserId=? where projectId=?";

        try {
            PreparedStatement ps = con.prepareStatement(insert);

            ps.setString(1, project.getProjectName());
            ps.setString(2, project.getDescription());
            ps.setString(3, project.getStartDate());
            ps.setString(4, project.getEndDate());
            ps.setLong(5, project.getBudget());
            ps.setLong(6, project.getPrice());
            ps.setString(7, project.getSponserId());
            ps.setLong(8, project.getProjectId());

            ps.executeUpdate();
        }catch(Exception e) {
            System.out.println(e +"data insert unsuccess.");
        }

        return project;

    }


    public int deleteProject(int projectId) {
        String insert = "delete from project where projectId =?";

        try {
            PreparedStatement ps = con.prepareStatement(insert);
            ps.setInt(1,projectId);

            ps.executeUpdate();
        }catch(Exception e) {
            System.out.println(e +"data insert unsuccess.");
        }

        return projectId;

    }
}
