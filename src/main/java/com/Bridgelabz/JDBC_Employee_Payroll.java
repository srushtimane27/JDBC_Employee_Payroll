package com.Bridgelabz;

import java.sql.*;
import java.util.Scanner;

public class JDBC_Employee_Payroll {
    public static void main(String[] args) {
        Connection con = null;
        PreparedStatement stm = null;

        String query = "select * from payroll_service.employee";
        Scanner sc = new Scanner(System.in);
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("driver register");

            con = DriverManager.getConnection("jdbc:mysql://localhost:3307?user=root&password=Srushti@2712");
            System.out.println("connection establish");

            stm = con.prepareStatement(query);
            System.out.println("platform created");

            System.out.println("Please insert the id to fetch the particular record");
            int userId = sc.nextInt();


            ResultSet rs = stm.executeQuery();

            if(rs.next()){
                int id = rs.getInt("id");
                int company_id = rs.getInt(2);
                String name = rs.getString(3);
                int phone_number = rs.getInt(4);
                String address = rs.getString(5);
                String gender = rs.getString(6);
                Date start = rs.getDate(7);

                System.out.println("User id -> "+id+ "Company_id -> "+company_id+ "User name -> "+name+ "User phone_number -> "+phone_number+ "User address -> "+address+ "User gender -> "+gender+ "User date -> "+start);
            }else{
                System.out.println("No record found with userId: " +userId);
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