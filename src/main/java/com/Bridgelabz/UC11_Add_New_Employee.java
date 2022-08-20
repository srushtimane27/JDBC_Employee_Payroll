package com.Bridgelabz;
import java.sql.*;

public class UC11_Add_New_Employee {
    public static void main(String[] args) {
        Connection con = null;
        PreparedStatement stm = null;
        String query = "insert into payroll_service.payroll values(?,?,?,?,?,?,?)";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("driver register");

            con = DriverManager.getConnection("jdbc:mysql://localhost:3307?user=root&password=Srushti@2712");
            System.out.println("connection establish");

            stm = con.prepareStatement(query);
            System.out.println("platform created");

            stm.setInt(1, 5);
            stm.setString(2, "Sahil");
            stm.setDouble(3,6000000);
            stm.setDouble(4,1000000);
            stm.setDouble(5,1000000);
            stm.setDouble(6,1000000);
            stm.setDouble(7,3000000);
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

