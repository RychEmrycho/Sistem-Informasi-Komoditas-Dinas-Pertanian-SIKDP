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
    private String status;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "kelompoktani_id")
    private Set<LaporanKelompok> laporanKelompok = new HashSet<>();

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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
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
}
