package com.skripsi.skripsi.rest.response;

import javax.validation.constraints.NotNull;
import java.util.Set;

public class RencanaStudiRes {
    private String namaMahasiswa;
    private Set<String> daftarMatkul;

    public RencanaStudiRes(String namaMahasiswa, Set<String> daftarMatkul) {
        this.namaMahasiswa = namaMahasiswa;
        this.daftarMatkul = daftarMatkul;
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
