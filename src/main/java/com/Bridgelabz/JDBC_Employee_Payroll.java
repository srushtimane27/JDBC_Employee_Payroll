package com.Bridgelabz;

import java.sql.*;
import java.util.Scanner;

public class JDBC_Employee_Payroll {
    public static void main(String[] args) {
        Connection con = null;
        PreparedStatement stm = null;

        String query = "select * from payroll_service.employee_payroll";
        Scanner sc = new Scanner(System.in);
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("driver register");

            con = DriverManager.getConnection("jdbc:mysql://localhost:3307?user=root&password=Srushti@2712");
            System.out.println("connection establish");

            stm = con.prepareStatement(query);
            System.out.println("platform created");

            System.out.println("Please insert the id to fetch the particular record");
            int UserId = sc.nextInt();


            ResultSet rs = stm.executeQuery();

            if(rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString(2);
                String gender = rs.getString(3);
                double basic_pay = rs.getDouble(4);
                Date start = rs.getDate(5);

                System.out.println("User id -> "+id+ "User Name -> "+name+ "User Gender -> "+gender+ "User Basic_Pay -> "+basic_pay+ "User Date -> "+start);
            }else{
                System.out.println("No record found with userId: " +UserId);
            }

            //     System.out.println("Data inserted");

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

                }if (sc != null){
                    sc.close();
                }
            }
        }
    }
}
