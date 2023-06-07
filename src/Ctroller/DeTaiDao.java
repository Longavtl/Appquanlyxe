/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ctroller;

import Model.DBConnect;
import Model.DeTai;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

//class này tạo các phương thức thêm sửa xóa tìm kiếm và hiển thị tất cả(tìm kiếm all)
public class DeTaiDao {
    //phương thức insert để thêm đề tài vào CSDL 
    public boolean insert (DeTai dt)throws Exception
    {
    //tạo string tưong ứng vs câu lệnh insert với các thuộc tính tương ứng với các cột trong bảng
    String sql="INSERT INTO `detai`(`MaDeTai`, `TenDeTai`, `GVHD`, `SVThucHien`, `Khoa`, `CongNgheSuDung`, `TienDo`)"+"values(?,?,?,?,?,?,?)";
    try(
            //tạo đối tượng DBConect
       Connection conn= DBConnect.Connect();
        PreparedStatement psmt= conn.prepareStatement(sql);//thực thi câu lẹnh sql
            ){
        // các textbox nhập tương úng với các thuộc tính trong lớp đề tài 
        psmt.setString(1,dt.getMaDeTai());
        psmt.setString(2,dt.getTenDeTai());
        psmt.setString(3,dt.getGVHD());
        psmt.setString(4,dt.getTenSVThucHien());
        psmt.setInt(5,dt.getKhoa());
        psmt.setString(6,dt.getCongNgheSuDung());
        psmt.setString(7,dt.getTienDo());
        return psmt.executeUpdate()>0;
    }
    }
    //phương thức sửa các thuộc tính  trong CSDL
     public boolean update (DeTai dt)throws Exception
    {
        //tạo string sql 
    String sql="UPDATE `detai`" +
            " SET TenDeTai =?,GVHD = ?,SVThucHien = ?,Khoa = ?,CongNgheSuDung = ?,TienDo = ?"
            +" where MaDeTai = ?";
    try(
            //tạo đối tượng DBConect
        Connection conn= DBConnect.Connect();
        PreparedStatement psmt= conn.prepareStatement(sql);//thực thi câu lẹnh sql
            ){
        // các textbox nhập tương úng với các thuộc tính trong lớp đề tài 
        psmt.setString(7,dt.getMaDeTai());
        psmt.setString(1,dt.getTenDeTai());
        psmt.setString(2,dt.getGVHD());
        psmt.setString(3,dt.getTenSVThucHien());
        psmt.setInt(4,dt.getKhoa());
        psmt.setString(5,dt.getCongNgheSuDung());
        psmt.setString(6,dt.getTienDo());
        return psmt.executeUpdate()>0;
    }
    }
     //phương thức xóa 1 dòng trong CSDL yêu cầu truyền vào mã đề tài
     public boolean delete (String MaDeTai)throws Exception
    {
        //lệnh sql
    String sql= "DELETE FROM `detai`" 
            +" where MaDeTai = ?";
    try(
            //tạo đối tượng DBConect
        Connection conn= DBConnect.Connect();
        PreparedStatement psmt= conn.prepareStatement(sql);//thực thi câu lẹnh sql
            ){
        psmt.setString(1, MaDeTai);        
        return psmt.executeUpdate()>0;
    }}
     //phương thức tìm kiếm các thuộc tính  trong CSDL yêu cầu truyền vào mã đề tài nếu mã đề tai trùng vs trong CSDL trả về kết ảu
      public DeTai timkiem (String MaDeTai)throws Exception
    {
        //câu lệnh sql
    String sql= "SELECT `MaDeTai`, `TenDeTai`, `GVHD`, `SVThucHien`, `Khoa`, `CongNgheSuDung`, `TienDo` FROM `detai` where MaDeTai = ?";
    try(
            //tạo đối tượng DBconect 
        Connection conn= DBConnect.Connect();
        PreparedStatement psmt= conn.prepareStatement(sql);//thực thi sql
            ){
        psmt.setString(1, MaDeTai);        
        try(ResultSet rs=psmt.executeQuery();){
            if(rs.next())
            {
                //kết quả trả về là rs nếu nó có dữ liệu thì tạo class DeTai tương ứng
                DeTai nt =createNgoaiThanh(rs);
                return nt;
            }
            else{
                 String message1 = "Không tìm thấy ";

        JOptionPane.showMessageDialog(null, message1);
            }
        }
    }
    return null;
}

    private DeTai createNgoaiThanh(final ResultSet rs) throws NumberFormatException, SQLException {
        DeTai dt =new DeTai();
        dt.setMaDeTai(rs.getString("MaDeTai"));
        dt.setTenDeTai(rs.getString("TenDeTai"));
        dt.setGVHD(rs.getString("GVHD"));
        dt.setTenSVThucHien(rs.getString("SVThucHien"));
        dt.setKhoa(rs.getInt("Khoa"));
        dt.setCongNgheSuDung(rs.getNString("CongNgheSuDung"));
        dt.setTienDo(rs.getString("TienDo"));
        return dt;
    }
    //phương thức hiển thị  tất cả kết quả trong CSDL 
      public List<DeTai> timkiemALL ()throws Exception
    {
    String sql= "SELECT* FROM detai";//sql
    try(
        Connection conn= DBConnect.Connect();
        PreparedStatement psmt= conn.prepareStatement(sql);//thực thi sql
            ){     
        try(ResultSet rs=psmt.executeQuery();){
            List<DeTai>list=new ArrayList<>();
            while(rs.next())
            {
                DeTai dt =createNgoaiThanh(rs);
                list.add(dt);
                //thêm từng phần tử vào mảng
            }
            return list;
        }
        
    }
    }
}
