package com.wearegroup11.pabwe.models;

import org.hibernate.annotations.Type;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Version;

@Entity
public class Bantuan {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String nama_bantuan;
	private Long id_kelompok;
	@Type(type = "text")
	private String deskripsi;
	private String proposal;
	private String status;
	private Date tanggal;
	
	@Version
	private Integer version;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNama_bantuan() {
		return nama_bantuan;
	}

	public void setNama_bantuan(String nama_bantuan) {
		this.nama_bantuan = nama_bantuan;
	}

	public Long getId_kelompok() {
		return id_kelompok;
	}

	public void setId_kelompok(Long id_kelompok) {
		this.id_kelompok = id_kelompok;
	}

	public String getDeskripsi() {
		return deskripsi;
	}

	public void setDeskripsi(String deskripsi) {
		this.deskripsi = deskripsi;
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

	public Date getTanggal() {
		return tanggal;
	}

	public void setTanggal(Date tanggal) {
		this.tanggal = tanggal;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}
}