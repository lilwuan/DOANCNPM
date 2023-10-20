package edu.abcd.bcdddd.model;

public class TaiKhoan {
    String email, pass, name, diachi, phone, thanhvien;
    int role;

    public TaiKhoan() {

    }

    public TaiKhoan(String email, String pass, String name, String diachi, String phone, String thanhvien, int role) {
        this.email = email;
        this.pass = pass;
        this.name = name;
        this.diachi = diachi;
        this.phone = phone;
        this.thanhvien = thanhvien;
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getThanhvien() {
        return thanhvien;
    }

    public void setThanhvien(String thanhvien) {
        this.thanhvien = thanhvien;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }
}
