package com.skripsi.skripsi.model;

import javax.persistence.*;
import javax.validation.constraints.*;


@Entity
@Table(name="matkul")
public class MatkulModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    private String nama;

    private Integer kapasitas;

    public MatkulModel(){

    }

    public MatkulModel(String nama, Integer kapasitas) {
        this.nama = nama;
        this.kapasitas = kapasitas;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
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
