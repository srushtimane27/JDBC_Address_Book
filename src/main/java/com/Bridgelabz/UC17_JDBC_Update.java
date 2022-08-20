package com.Bridgelabz;

import java.sql.*;
import java.util.Scanner;

public class UC17_JDBC_Update {
    public static void main(String[] args) {
        Connection con = null;
        PreparedStatement stm = null;
        String query = "update address_book.address_book set zip = '123456' where id = 14";

        Scanner sc = new Scanner(System.in);
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("driver register");

            con = DriverManager.getConnection("jdbc:mysql://localhost:3307?user=root&password=Srushti@2712");

            System.out.println("connection establish");

            stm = con.prepareStatement(query);
            //   System.out.println("platform created");


            stm.executeUpdate();

            System.out.println("Data inserted");

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
