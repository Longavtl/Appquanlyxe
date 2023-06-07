/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;
import java.sql.Connection;
import java.sql.DriverManager;
//class này để kết nối vs mysql xampp
public class DBConnect {
    public static Connection Connect()
    {
        //nạp driver & kết nối tới Database quanlysinhvien
        Connection conn=null;
        try{
            String url       = "jdbc:mysql://localhost:3307/quanlysinhvien";
            String user      = "root";
            String password  = "";
    // create a connection to the database
    conn = DriverManager.getConnection(url, user, password); 
    System.out.println("Kết nối thành công");
        }
    catch(Exception ex)
    {
        ex.printStackTrace();
    }
       return conn; 
    }
}
