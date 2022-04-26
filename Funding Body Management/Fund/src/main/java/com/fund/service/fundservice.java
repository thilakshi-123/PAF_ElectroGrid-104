package com.fund.service;

import com.fund.model.fundmodel;

import java.sql.*;
import java.util.ArrayList;

public class fundservice {
    Connection con;


    public fundservice(){

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


    public fundmodel insertFund(fundmodel fund) {
        String insert = "insert into fund(fundId,fundType,description,fundAmount,issuedDate,issuedBy) values(?,?,?,?,?,?) ";

        try {
            PreparedStatement ps = con.prepareStatement(insert);
            ps.setLong(1, fund.getFundId());
            ps.setString(2, fund.getFundType());
            ps.setString(3, fund.getDescription());
            ps.setLong(4, fund.getFundAmount());
            ps.setString(5, fund.getIssuedDate());
            ps.setString(6, fund.getIssuedBy());

            ps.execute();
        }catch(Exception e) {
            System.out.println(e +"data insert unsuccess.");
        }

        return fund;

    }

    public ArrayList<fundmodel> getFund() throws SQLException {

        ArrayList<fundmodel> data = new ArrayList<fundmodel>();

        String select = "select * from fund";
        PreparedStatement ps = con.prepareStatement(select);
        ResultSet rs = ps.executeQuery();

        while(rs.next()) {
            fundmodel model = new fundmodel();

            model.setFundId(rs.getInt("fundId"));
            model.setFundType(rs.getString("fundType"));
            model.setDescription(rs.getString("description"));
            model.setFundAmount(rs.getInt("fundAmount")); // column name
            model.setIssuedDate(rs.getString("issuedDate"));
            model.setIssuedBy(rs.getString("issuedBy"));

            data.add(model);

        }

        return data;

    }


    public ArrayList<fundmodel> getFundById(int fundId) throws SQLException{

        ArrayList<fundmodel> data = new ArrayList<fundmodel>();
        String select = "select * from fund where fundId =?";
        PreparedStatement ps = con.prepareStatement(select);
        ps.setInt(1,fundId);
        ResultSet rs = ps.executeQuery();

        while(rs.next()) {
            fundmodel model = new fundmodel();

            model.setFundId(rs.getInt("fundId"));
            model.setFundType(rs.getString("fundType"));
            model.setDescription(rs.getString("description"));
            model.setFundAmount(rs.getInt("fundAmount")); // column name
            model.setIssuedDate(rs.getString("issuedDate"));
            model.setIssuedBy(rs.getString("issuedBy"));

            data.add(model);
        }
        return data;
    }

    public fundmodel updateFund(fundmodel fund) {
        String insert = "update fund set fundType=?,description=? , fundAmount=? , issuedDate=?, issuedBy=? where fundId=?";

        try {
            PreparedStatement ps = con.prepareStatement(insert);

            ps.setString(1, fund.getFundType());
            ps.setString(2, fund.getDescription());
            ps.setLong(3, fund.getFundAmount());
            ps.setString(4, fund.getIssuedDate());
            ps.setString(5, fund.getIssuedBy());
            ps.setLong(6, fund.getFundId());

            ps.executeUpdate();
        }catch(Exception e) {
            System.out.println(e +"data insert unsuccess.");
        }

        return fund;

    }


    public int deleteFund(int fundId) {
        String insert = "delete from fund where fundId =?";

        try {
            PreparedStatement ps = con.prepareStatement(insert);
            ps.setInt(1,fundId);

            ps.executeUpdate();
        }catch(Exception e) {
            System.out.println(e +"data insert unsuccess.");
        }
        return fundId;
    }
}
