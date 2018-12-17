package com.wearegroup11.pabwe.models;

import java.sql.Date;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long nik;
    private String namaDepan;
    private String namaBelakang;
    private String jenisKelamin;
    private String noHP;
    private String tempatLahir;
    private Date tanggalLahir;
    private String alamatRtRw;
    private String alamatDusun;
    private String alamatDesa;
    private String alamatKecamatan;

    private String username;
    private String email;
    private String password;

    private int active;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "user", optional = false, orphanRemoval = true, fetch = FetchType.LAZY)
    private KelompokTani kelompokTani;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public Long getNik() {
        return nik;
    }

    public void setNik(Long nik) {
        this.nik = nik;
    }

    public String getNamaDepan() {
        return namaDepan;
    }

    public void setNamaDepan(String namaDepan) {
        this.namaDepan = namaDepan;
    }

    public String getNamaBelakang() {
        return namaBelakang;
    }

    public void setNamaBelakang(String namaBelakang) {
        this.namaBelakang = namaBelakang;
    }

    public String getJenisKelamin() {
        return jenisKelamin;
    }

    public void setJenisKelamin(String jenisKelamin) {
        this.jenisKelamin = jenisKelamin;
    }

    public String getNoHP() {
        return noHP;
    }

    public void setNoHP(String noHP) {
        this.noHP = noHP;
    }

    public String getTempatLahir() {
        return tempatLahir;
    }

    public void setTempatLahir(String tempatLahir) {
        this.tempatLahir = tempatLahir;
    }

    public Date getTanggalLahir() {
        return tanggalLahir;
    }

    public void setTanggalLahir(Date tanggalLahir) {
        this.tanggalLahir = tanggalLahir;
    }

    public String getAlamatRtRw() {
        return alamatRtRw;
    }

    public void setAlamatRtRw(String alamatRtRw) {
        this.alamatRtRw = alamatRtRw;
    }

    public String getAlamatDusun() {
        return alamatDusun;
    }

    public void setAlamatDusun(String alamatDusun) {
        this.alamatDusun = alamatDusun;
    }

    public String getAlamatDesa() {
        return alamatDesa;
    }

    public void setAlamatDesa(String alamatDesa) {
        this.alamatDesa = alamatDesa;
    }

    public String getAlamatKecamatan() {
        return alamatKecamatan;
    }

    public void setAlamatKecamatan(String alamatKecamatan) {
        this.alamatKecamatan = alamatKecamatan;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public KelompokTani getKelompokTani() {
        return kelompokTani;
    }

    public void setKelompokTani(KelompokTani kelompokTani) {
        if (kelompokTani == null) {
            if (this.kelompokTani != null) {
                this.kelompokTani.setUser(null);
            }
        } else {
            kelompokTani.setUser(this);
        }

        this.kelompokTani = kelompokTani;
    }

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "User [id=" + id + ", nik=" + nik + ", namaDepan=" + namaDepan + ", namaBelakang=" + namaBelakang
                + ", jenisKelamin=" + jenisKelamin + ", noHP=" + noHP + ", tempatLahir=" + tempatLahir
                + ", tanggalLahir=" + tanggalLahir + ", alamatRtRw=" + alamatRtRw + ", alamatDusun=" + alamatDusun
                + ", alamatDesa=" + alamatDesa + ", alamatKecamatan=" + alamatKecamatan + ", username=" + username
                + ", email=" + email + ", password=" + password + ", active=" + active + ", roles=" + roles + "]";
    }
}
