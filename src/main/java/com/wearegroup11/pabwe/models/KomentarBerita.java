package com.wearegroup11.pabwe.models;

import com.wearegroup11.pabwe.repositories.UserRepository;
import com.wearegroup11.pabwe.services.UserServiceImpl;
import org.hibernate.annotations.Type;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Timestamp;

@Entity
public class KomentarBerita {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private Long idUser;
    private Long idBerita;
    @Type(type = "text")
    private String isi;
    private Timestamp waktu;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }

    public Long getIdBerita() {
        return idBerita;
    }

    public void setIdBerita(Long idBerita) {
        this.idBerita = idBerita;
    }

    public String getIsi() {
        return isi;
    }

    public void setIsi(String isi) {
        this.isi = isi;
    }

    public Timestamp getWaktu() {
        return waktu;
    }

    public void setWaktu(Timestamp waktu) {
        this.waktu = waktu;
    }
}
