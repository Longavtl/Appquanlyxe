/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;
//class ánh xạ các thuộc tính có trong csdl bảng đề tài 
public class DeTai {
    private String MaDeTai,TenDeTai,GVHD,TenSVThucHien,CongNgheSuDung,TienDo;
    private int Khoa;
    public String getMaDeTai() {
        return MaDeTai;
    }

    public void setMaDeTai(String MaDeTai) {
        this.MaDeTai = MaDeTai;
    }

    public String getTenDeTai() {
        return TenDeTai;
    }

    public void setTenDeTai(String TenDeTai) {
        this.TenDeTai = TenDeTai;
    }

    public String getGVHD() {
        return GVHD;
    }

    public void setGVHD(String GVHD) {
        this.GVHD = GVHD;
    }

    public String getTenSVThucHien() {
        return TenSVThucHien;
    }

    public void setTenSVThucHien(String TenSVThucHien) {
        this.TenSVThucHien = TenSVThucHien;
    }

    public String getCongNgheSuDung() {
        return CongNgheSuDung;
    }

    public void setCongNgheSuDung(String CongNgheSuDung) {
        this.CongNgheSuDung = CongNgheSuDung;
    }

    public String getTienDo() {
        return TienDo;
    }

    public void setTienDo(String TienDo) {
        this.TienDo = TienDo;
    }

    public int getKhoa() {
        return Khoa;
    }

    public void setKhoa(int Khoa) {
        this.Khoa = Khoa;
    }
    
}
