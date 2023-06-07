/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;
//class ánh xạ các thuộc tính có trong csdl bảng đề tài
public class TaiKhoan {
    public String TenTaiKhoan,MatKhau,VaiTro,SoDienThoai;

    public String getTenTaiKhoan() {
        return TenTaiKhoan;
    }

    public void setTenTaiKhoan(String TenTaiKhoan) {
        this.TenTaiKhoan = TenTaiKhoan;
    }

    public String getMatKhau() {
        return MatKhau;
    }

    public void setMatKhau(String MatKhau) {
        this.MatKhau = MatKhau;
    }

    public String getVaiTro() {
        return VaiTro;
    }

    public void setVaiTro(String VaiTro) {
        this.VaiTro = VaiTro;
    }

    public String getSoDienThoai() {
        return SoDienThoai;
    }

    public void setSoDienThoai(String SoDienThoai) {
        this.SoDienThoai = SoDienThoai;
    }

    public TaiKhoan(String TenTaiKhoan, String MatKhau, String VaiTro, String SoDienThoai) {
        this.TenTaiKhoan = TenTaiKhoan;
        this.MatKhau = MatKhau;
        this.VaiTro = VaiTro;
        this.SoDienThoai = SoDienThoai;
    }

    public TaiKhoan() {
    }
}
