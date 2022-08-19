package com.Bridgelabz;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBC_Employee_Payroll {
    public static void main(String[] args) {
        Connection con = null;
        Statement stm = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("driver register");

            con = DriverManager.getConnection("jdbc:mysql://localhost:3307?user=root&password=Srushti@2712");
            System.out.println("connection establish");

            stm = con.createStatement();
            System.out.println("platform created");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }finally {
            if (con != null){
                try{
                    con.close();
                }catch(SQLException s)
                {
                    System.out.println(s.getMessage());
                }
            }
        }
    }
}


