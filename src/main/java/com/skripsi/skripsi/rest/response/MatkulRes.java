package com.skripsi.skripsi.rest.response;

public class MatkulRes {
    private Integer id;
    private String nama;
    private Integer kapasitas;

    public MatkulRes(Integer id, String nama, Integer kapasitas) {
        this.id = id;
        this.nama = nama;
        this.kapasitas = kapasitas;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public Integer getKapasitas() {
        return kapasitas;
    }

    public void setKapasitas(Integer kapasitas) {
        this.kapasitas = kapasitas;
    }
}
