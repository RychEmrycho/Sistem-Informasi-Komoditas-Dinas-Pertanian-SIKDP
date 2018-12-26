package com.wearegroup11.pabwe.models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "KelompokTani")
@Table(name = "kelompok_tani")
public class KelompokTani {

    @Id
    private Long id;

    private Long idKelurahan;
    private Long idKecamatan;
    private String namaKelompok;
    private Integer jumlahAnggota;
    private Integer luasSawah;
    private Integer luasDarat;
    private String noTelepon;
    private String proposal;
    private Integer status;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<LaporanKelompok> laporanKelompok = new HashSet<>();

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Bantuan> bantuanKelompok = new HashSet<>();

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<HasilPertanian> hasilPertanianKelompok = new HashSet<>();

    @Version
    private Integer version;

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    private User user;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdKelurahan() {
        return idKelurahan;
    }

    public void setIdKelurahan(Long idKelurahan) {
        this.idKelurahan = idKelurahan;
    }

    public Long getIdKecamatan() {
        return idKecamatan;
    }

    public void setIdKecamatan(Long idKecamatan) {
        this.idKecamatan = idKecamatan;
    }

    public String getNamaKelompok() {
        return namaKelompok;
    }

    public void setNamaKelompok(String namaKelompok) {
        this.namaKelompok = namaKelompok;
    }

    public Integer getJumlahAnggota() {
        return jumlahAnggota;
    }

    public void setJumlahAnggota(Integer jumlahAnggota) {
        this.jumlahAnggota = jumlahAnggota;
    }

    public Integer getLuasSawah() {
        return luasSawah;
    }

    public void setLuasSawah(Integer luasSawah) {
        this.luasSawah = luasSawah;
    }

    public Integer getLuasDarat() {
        return luasDarat;
    }

    public void setLuasDarat(Integer luasDarat) {
        this.luasDarat = luasDarat;
    }

    public String getNoTelepon() {
        return noTelepon;
    }

    public void setNoTelepon(String noTelepon) {
        this.noTelepon = noTelepon;
    }

    public String getProposal() {
        return proposal;
    }

    public void setProposal(String proposal) {
        this.proposal = proposal;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Set<LaporanKelompok> getLaporanKelompok() {
        return laporanKelompok;
    }

    public void setLaporanKelompok(Set<LaporanKelompok> laporanKelompok) {
        this.laporanKelompok = laporanKelompok;
    }

    public void addLaporan(LaporanKelompok laporanKelompok) {
        this.laporanKelompok.add(laporanKelompok);
        laporanKelompok.setKelompokTani(this);
    }

    public void removeLaporan(LaporanKelompok laporanKelompok) {
        this.laporanKelompok.remove(laporanKelompok);
        laporanKelompok.setKelompokTani(null);
    }

    public Set<Bantuan> getBantuanKelompok() {
        return bantuanKelompok;
    }

    public void setBantuanKelompok(Set<Bantuan> bantuanKelompok) {
        this.bantuanKelompok = bantuanKelompok;
    }

    public void addBantuan(Bantuan bantuan) {
        this.bantuanKelompok.add(bantuan);
        bantuan.setKelompokTani(this);
    }

    public void removeBantuan(Bantuan bantuan) {
        this.bantuanKelompok.remove(bantuan);
        bantuan.setKelompokTani(null);
    }

    public Set<HasilPertanian> getHasilPertanianKelompok() {
        return hasilPertanianKelompok;
    }

    public void setHasilPertanianKelompok(Set<HasilPertanian> hasilPertanianKelompok) {
        this.hasilPertanianKelompok = hasilPertanianKelompok;
    }

    public void addHasilPertanian(HasilPertanian hasilPertanian) {
        this.hasilPertanianKelompok.add(hasilPertanian);
        hasilPertanian.setKelompokTani(this);
    }

    public void removeHasilPertanian(HasilPertanian hasilPertanian) {
        this.hasilPertanianKelompok.remove(hasilPertanian);
        hasilPertanian.setKelompokTani(null);
    }
}
