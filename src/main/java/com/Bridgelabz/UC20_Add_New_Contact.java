package com.Bridgelabz;

import java.sql.*;

public class UC20_Add_New_Contact {
    public static void main(String[] args) {
        Connection con = null;
        PreparedStatement stm = null;
        String query = "insert into address_book.address_book values(?,?,?,?,?,?,?,?,?)";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("driver register");

            con = DriverManager.getConnection("jdbc:mysql://localhost:3307?user=root&password=Srushti@2712");
            System.out.println("connection establish");

            stm = con.prepareStatement(query);
            System.out.println("platform created");

            stm.setInt(1, 15);
            stm.setString(2, "Akshay");
            stm.setString(3, "Family");
            stm.setString(4, "Bavdhan");
            stm.setString(5, "Solapur");
            stm.setString(6, "Maharashtra");
            stm.setInt(7, 551367);
            stm.setInt(8,1158885);
            stm.setString(9,"akshay@gmail.com");
            stm.executeUpdate();

            stm.setInt(1,16);
            stm.setString(2,"Samarth");
            stm.setString(3,"Profession");
            stm.setString(4,"Vitthal Nagar");
            stm.setString(5,"Bikaner");
            stm.setString(6,"Rajasthan");
            stm.setInt(7,117421);
            stm.setInt(8,9655551);
            stm.setString(9,"samarth@gmail.com");
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