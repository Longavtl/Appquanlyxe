/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ctroller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import Model.DBConnect;
import Model.DBConnect;
import Model.TaiKhoan;
//class này có các phương thức thêm sửa xóa 
public class TaiKhoanDao {
    //phương thức thêm tài khoản
     public boolean insert (TaiKhoan nt)throws Exception
    {
    String sql="INSERT INTO `taikhoan`(TenTaiKhoan,MatKhau,VaiTro,SoDienThoai)"+"values(?,?,?,?)";// tạo câu lệnh sql
    try(
        Connection conn= DBConnect.Connect();//tạo đổi tượng DBConect để kết nối csdl
        PreparedStatement psmt= conn.prepareStatement(sql);//thức thi sql
            ){
        //ánh xạ các trường tương ứng từ dâtbase
        psmt.setString(1,nt.getTenTaiKhoan());
        psmt.setString(2,nt.getMatKhau());
        psmt.setString(3,nt.getVaiTro());
        psmt.setString(4,nt.getSoDienThoai());
        
        return psmt.executeUpdate()>0;
    }
    }
     //phương thức check đăng nhập
     public TaiKhoan checklogin (String TenTaiKhoan,String MatKhau)throws Exception{
    String sql="SELECT TenTaiKhoan,MatKhau,VaiTro From `taikhoan`"+
            " where TenTaiKhoan=? and MatKhau=?";//sql lấy về 2 trường tên tài khoản và mk
        try(
        Connection conn= DBConnect.Connect();
        PreparedStatement psmt= conn.prepareStatement(sql);
                ){
        psmt.setString(1,TenTaiKhoan);
        psmt.setString(2,MatKhau);
        
        try(ResultSet rs=psmt.executeQuery();){
            if(rs.next())
            {
            TaiKhoan nd=new TaiKhoan();
            nd.setTenTaiKhoan(TenTaiKhoan);
            nd.setVaiTro(rs.getString("VaiTro"));
           
            //nd.setPassword(Password);
            return nd;
            }
        }
        }
        
    return null;
}
     //phương thức sửa thông tin tài khoản
     public boolean update (TaiKhoan nt)throws Exception
    {
    String sql="UPDATE `taikhoan`" +
            " SET MatKhau =?,VaiTro=?,SoDienThoai=?"
            +" where TenTaiKhoan = ?";//sql
    try(
        Connection conn= DBConnect.Connect();
        PreparedStatement psmt= conn.prepareStatement(sql);//thực thi sql
            ){
        psmt.setString(1,nt.getMatKhau());
        psmt.setString(2,nt.getVaiTro());  
        psmt.setString(3,nt.getSoDienThoai());
        psmt.setString(4,nt.getTenTaiKhoan());
        //gán kết quả trả về về đối tượng TaiKhoan
        return psmt.executeUpdate()>0;
    }
    }
     private TaiKhoan createUsers(final ResultSet rs) throws NumberFormatException, SQLException {
        TaiKhoan nt =new TaiKhoan();
        nt.setTenTaiKhoan(rs.getString("TenTaiKhoan"));
        nt.setMatKhau(rs.getString("MatKhau"));
        nt.setVaiTro(rs.getString("VaiTro"));
        nt.setSoDienThoai(rs.getString("SoDienThoai"));
        return nt;
    }
     //phương thức xóa tài khoản
    public boolean delete (String username)throws Exception
    {
    String sql= "DELETE FROM `taikhoan`" 
            +" where TenTaiKhoan = ?";//saq
    try(
        Connection conn= DBConnect.Connect();
        PreparedStatement psmt= conn.prepareStatement(sql);//thực thi sql
            ){
        psmt.setString(1, username);        
        return psmt.executeUpdate()>0;
    }}
    //phương thức hiển thị tất các trong bảng Taikhoan
   public List<TaiKhoan> timkiemALL ()throws Exception
    {
    String sql= "SELECT* FROM `taikhoan`";//sql
    try(
        Connection conn= DBConnect.Connect();
        PreparedStatement psmt= conn.prepareStatement(sql);
            ){     
        try(ResultSet rs=psmt.executeQuery();){
            List<TaiKhoan>list=new ArrayList<>();
            while(rs.next())
            {
                TaiKhoan nt =createUsers(rs);
                list.add(nt);
               //add từng kết quả trả về vào đối tượng nt
            }
            return list;
        }
    }
    }
}
