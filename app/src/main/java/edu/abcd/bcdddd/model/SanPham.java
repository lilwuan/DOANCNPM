package edu.abcd.bcdddd.model;

import java.io.Serializable;

public class SanPham implements Serializable {
    String ImagePro, idsanpham, loai_sanpham, mota, namsx, tensanpham, thuonghieu;
    int gia;
    public SanPham(){

    }

    public SanPham(String imagePro, int gia, String idsanpham, String loai_sanpham, String mota, String namsx, String tensanpham, String thuonghieu) {
        ImagePro = imagePro;
        this.gia = gia;
        this.idsanpham = idsanpham;
        this.loai_sanpham = loai_sanpham;
        this.mota = mota;
        this.namsx = namsx;
        this.tensanpham = tensanpham;
        this.thuonghieu = thuonghieu;
    }

    public String getImagePro() {
        return ImagePro;
    }

    public void setImagePro(String imagePro) {
        ImagePro = imagePro;
    }

    public int getGia() {
        return gia;
    }

    public void setGia(int gia) {
        this.gia = gia;
    }

    public String getIdsanpham() {
        return idsanpham;
    }

    public void setIdsanpham(String idsanpham) {
        this.idsanpham = idsanpham;
    }

    public String getLoai_sanpham() {
        return loai_sanpham;
    }

    public void setLoai_sanpham(String loai_sanpham) {
        this.loai_sanpham = loai_sanpham;
    }

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }

    public String getNamsx() {
        return namsx;
    }

    public void setNamsx(String namsx) {
        this.namsx = namsx;
    }

    public String getTensanpham() {
        return tensanpham;
    }

    public void setTensanpham(String tensanpham) {
        this.tensanpham = tensanpham;
    }

    public String getThuonghieu() {
        return thuonghieu;
    }

    public void setThuonghieu(String thuonghieu) {
        this.thuonghieu = thuonghieu;
    }
}
