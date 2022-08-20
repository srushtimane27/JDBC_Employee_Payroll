package com.Bridgelabz;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class UC12_Remove_Employee {
    public static void main(String[] args) {
        Connection con = null;
        Statement stm = null;
        //   String query = "insert into address_book.address_book values('10', 'Sahil', 'Friend', 'Aundh', 'Pune', 'Maharashtra', '356245','8569754', 'sahil@gmail.com')";
        String query = "delete from payroll_service.payroll where id = 4";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("driver register");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3307?user=root&password=Srushti@2712");
            System.out.println("connection establish");
            stm = con.createStatement();
            System.out.println("platform created");
            //      stm.executeUpdate(query);
            //      System.out.println("Data inserted");
            stm.executeUpdate(query);
            System.out.println("Data deleted");
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
