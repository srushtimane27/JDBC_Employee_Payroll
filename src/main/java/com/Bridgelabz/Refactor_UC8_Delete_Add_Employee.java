package com.Bridgelabz;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Refactor_UC8_Delete_Add_Employee {
    public static void main(String[] args) {
        Connection con = null;
        Statement stm = null;

        String query = "delete from payroll_service.payroll where id = 5";
        String query1 = "insert into payroll_service.payroll values('8', 'Sahil', 6000000, 1000000, 1000000, 1000000, 3000000)";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("driver register");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3307?user=root&password=Srushti@2712");
            System.out.println("connection establish");
            stm = con.createStatement();
            System.out.println("platform created");
            stm.executeUpdate(query);
            System.out.println("Data deleted");
            stm.executeUpdate(query1);
            System.out.println("Data inserted");
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

