package com.Bridgelabz;

import java.security.spec.RSAOtherPrimeInfo;
import java.sql.*;
import java.util.Scanner;

public class JDBC_Address_Book {
    public static void main(String[] args) {
        Connection con = null;
        PreparedStatement stm = null;

        String query = "select * from address_book.address_book where id = ?";
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
            stm.setInt(1,userId);

            ResultSet rs = stm.executeQuery();

            if(rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString(2);
                String type = rs.getString(3);
                String address = rs.getString(4);
                String city = rs.getString(5);
                String state = rs.getString(6);
                int zip = rs.getInt(7);
                int phone = rs.getInt(8);
                String email = rs.getNString(9);
                System.out.println("User id -> "+id+" User name -> "+name+ "User type -> "+type+ "User address -> "+address+ "User city -> "+city+ "User State -> "+state+ "User zip -> "+zip+ "User Phone Number -> " +phone+ "User Email ID -> "+email);
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
