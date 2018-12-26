package com.wearegroup11.pabwe.models;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
public class HargaKomoditi {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_komoditi")
    private Komoditi komoditi;

    private Timestamp tanggal;

    private Integer harga;

    @Version
    private Integer version;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Komoditi getKomoditi() {
        return komoditi;
    }

    public void setKomoditi(Komoditi komoditi) {
        this.komoditi = komoditi;
    }

    public Timestamp getTanggal() {
        return tanggal;
    }

    public void setTanggal(Timestamp tanggal) {
        this.tanggal = tanggal;
    }

    public Integer getHarga() {
        return harga;
    }

    public void setHarga(Integer harga) {
        this.harga = harga;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }
}
