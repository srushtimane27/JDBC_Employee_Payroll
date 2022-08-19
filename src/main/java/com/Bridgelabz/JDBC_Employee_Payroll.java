package com.Bridgelabz;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBC_Employee_Payroll {
    public static void main(String[] args) {
        Connection con = null;
        Statement stm = null;

        String query = "update payroll_service.payroll set basic_pay = '300' where id = 2";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("driver register");

            con = DriverManager.getConnection("jdbc:mysql://localhost:3307?user=root&password=Srushti@2712");
            System.out.println("connection establish");

            stm = con.createStatement();
            System.out.println("platform created");

            stm.executeUpdate(query);
            System.out.println("Data Updated");
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
            }if (stm != null){
                try {
                    stm.close();
                }catch (SQLException s){
                    System.out.println(s.getMessage());
                }
            }
        }
    }
}
