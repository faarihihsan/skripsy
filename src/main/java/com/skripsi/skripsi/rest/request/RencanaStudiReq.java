package com.skripsi.skripsi.rest.request;

import javax.validation.constraints.NotNull;
import java.util.Set;

public class RencanaStudiReq {
    private Integer id;

    @NotNull
    private String namaMahasiswa;

    @NotNull
    private Set<String> daftarMatkul;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNamaMahasiswa() {
        return namaMahasiswa;
    }

    public void setNamaMahasiswa(String namaMahasiswa) {
        this.namaMahasiswa = namaMahasiswa;
    }

    public Set<String> getDaftarMatkul() {
        return daftarMatkul;
    }

    public void setDaftarMatkul(Set<String> daftarMatkul) {
        this.daftarMatkul = daftarMatkul;
    }
}
