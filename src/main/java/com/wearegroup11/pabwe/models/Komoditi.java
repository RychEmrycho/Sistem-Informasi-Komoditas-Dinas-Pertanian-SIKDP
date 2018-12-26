package com.wearegroup11.pabwe.models;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Komoditi {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String namaKomoditi;
    private String lamaPanen;

    @Type(type = "text")
    private String deskripsi;

    private String foto;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<HargaKomoditi> hargaKomoditi = new HashSet<>();

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<HasilPertanian> hasilPertanian = new HashSet<>();

    @Version
    private Integer version;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNamaKomoditi() {
        return namaKomoditi;
    }

    public void setNamaKomoditi(String namaKomoditi) {
        this.namaKomoditi = namaKomoditi;
    }

    public String getLamaPanen() {
        return lamaPanen;
    }

    public void setLamaPanen(String lamaPanen) {
        this.lamaPanen = lamaPanen;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public Set<HargaKomoditi> getHargaKomoditi() {
        return hargaKomoditi;
    }

    public void setHargaKomoditi(Set<HargaKomoditi> hargaKomoditi) {
        this.hargaKomoditi = hargaKomoditi;
    }

    public Set<HasilPertanian> getHasilPertanian() {
        return hasilPertanian;
    }

    public void setHasilPertanian(Set<HasilPertanian> hasilPertanian) {
        this.hasilPertanian = hasilPertanian;
    }

    public void addHargaKomoditi(HargaKomoditi hargaKomoditi) {
        this.hargaKomoditi.add(hargaKomoditi);
        hargaKomoditi.setKomoditi(this);
    }

    public void removeHargaKomoditi(HargaKomoditi hargaKomoditi) {
        this.hargaKomoditi.remove(hargaKomoditi);
        hargaKomoditi.setKomoditi(null);
    }

    public void addHasilPertanian(HasilPertanian hasilPertanian) {
        this.hasilPertanian.add(hasilPertanian);
        hasilPertanian.setKomoditi(this);
    }

    public void removeHasilPertanian(HasilPertanian hasilPertanian) {
        this.hasilPertanian.remove(hasilPertanian);
        hasilPertanian.setKomoditi(null);
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }
}
