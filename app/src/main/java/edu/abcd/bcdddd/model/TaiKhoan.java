package edu.abcd.bcdddd.model;

public class TaiKhoan {
    String diachi, email, id, name, pass, phone, thanhvien;
    public TaiKhoan(){

    }

    public TaiKhoan(String diachi, String email, String id, String name, String pass, String phone, String thanhvien) {
        this.diachi = diachi;
        this.email = email;
        this.id = id;
        this.name = name;
        this.pass = pass;
        this.phone = phone;
        this.thanhvien = thanhvien;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
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
}
