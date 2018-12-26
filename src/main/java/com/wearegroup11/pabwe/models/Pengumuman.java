package com.wearegroup11.pabwe.models;


import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
public class Pengumuman {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Long id_user;
	private String judul;
	private Timestamp tanggal;

    @Type(type = "text")
    private String isi;
	private String lampiran;
	@Version
	private Integer version;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getId_user() {
		return id_user;
	}

	public void setId_user(Long id_user) {
		this.id_user = id_user;
	}

	public String getJudul() {
		return judul;
	}

	public void setJudul(String judul) {
		this.judul = judul;
	}

	public Timestamp getTanggal() {
		return tanggal;
	}

	public void setTanggal(Timestamp tanggal) {
		this.tanggal = tanggal;
	}

	public String getIsi() {
		return isi;
	}

	public void setIsi(String isi) {
		this.isi = isi;
	}

	public String getLampiran() {
		return lampiran;
	}

	public void setLampiran(String lampiran) {
		this.lampiran = lampiran;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	@Override
	public String toString() {
		return "Pengumuman{" +
				"id=" + id +
				", id_user=" + id_user +
				", judul='" + judul + '\'' +
				", tanggal=" + tanggal +
				", isi='" + isi + '\'' +
				", lampiran='" + lampiran + '\'' +
				", version=" + version +
				'}';
	}
}
