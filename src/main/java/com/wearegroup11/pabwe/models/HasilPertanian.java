package com.wearegroup11.pabwe.models;

import javax.persistence.*;
import java.sql.Date;

@Entity
public class HasilPertanian {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_komoditi")
    private Komoditi komoditi;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_kelompok")
    private KelompokTani kelompokTani;

    private Date bulan;

    @Version
    private Integer version;

    // luasLahan dalam m(2)
    private Integer luasLahan;

    //jumlahHasilPanen dalam KG
    private Integer jumlahHasilPanen;

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

    public KelompokTani getKelompokTani() {
        return kelompokTani;
    }

    public void setKelompokTani(KelompokTani kelompokTani) {
        this.kelompokTani = kelompokTani;
    }

    public Date getBulan() {
        return bulan;
    }

    public void setBulan(Date bulan) {
        this.bulan = bulan;
    }

    public Integer getLuasLahan() {
        return luasLahan;
    }

    public void setLuasLahan(Integer luasLahan) {
        this.luasLahan = luasLahan;
    }

    public Integer getJumlahHasilPanen() {
        return jumlahHasilPanen;
    }

    public void setJumlahHasilPanen(Integer jumlahHasilPanen) {
        this.jumlahHasilPanen = jumlahHasilPanen;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }
}
