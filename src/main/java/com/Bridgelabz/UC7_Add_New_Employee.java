package com.Bridgelabz;

import java.sql.*;

public class UC7_Add_New_Employee {
    public static void main(String[] args) {
        Connection con = null;
        PreparedStatement stm = null;
        String query = "insert into payroll_service.employee_payroll values(?,?,?,?)";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("driver register");

            con = DriverManager.getConnection("jdbc:mysql://localhost:3307?user=root&password=Srushti@2712");
            System.out.println("connection establish");

            stm = con.prepareStatement(query);
            System.out.println("platform created");

            stm.setInt(1, 4);
            stm.setString(2, "Akshay");
            stm.setDouble(3,4000000);
            stm.setDate(4, new Date(2019-5-15));
            stm.executeUpdate();

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
