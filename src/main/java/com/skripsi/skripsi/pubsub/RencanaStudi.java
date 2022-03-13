package com.skripsi.skripsi.pubsub;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RencanaStudi {
    @JsonProperty("namaMahasiswa")
    private String namaMahasiswa;

    @JsonProperty("daftarMatkulId")
    private String daftarMatkulId;

    public RencanaStudi(String namaMahasiswa, String daftarMatkulId) {
        this.namaMahasiswa = namaMahasiswa;
        this.daftarMatkulId = daftarMatkulId;
    }

    public String getNamaMahasiswa() {
        return namaMahasiswa;
    }

    public void setNamaMahasiswa(String namaMahasiswa) {
        this.namaMahasiswa = namaMahasiswa;
    }

    public String getDaftarMatkulId() {
        return daftarMatkulId;
    }

    public void setDaftarMatkulId(String daftarMatkulId) {
        this.daftarMatkulId = daftarMatkulId;
    }
}
