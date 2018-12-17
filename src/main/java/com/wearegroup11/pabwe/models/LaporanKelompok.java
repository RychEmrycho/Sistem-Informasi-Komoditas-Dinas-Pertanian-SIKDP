package com.wearegroup11.pabwe.models;

import java.sql.Date;

import javax.persistence.*;

@Entity(name = "LaporanKelompok")
@Table(name = "laporan_kelompok")
public class LaporanKelompok {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String namaLaporan;
	private String deskripsi;
	private Integer idKelompok;
	private Date tanggal;
	private String laporan;
	private String status;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "kelompoktani_id")
	private KelompokTani kelompokTani;
	
	@Version
	private Integer version;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNamaLaporan() {
		return namaLaporan;
	}

	public void setNamaLaporan(String namaLaporan) {
		this.namaLaporan = namaLaporan;
	}

	public String getDeskripsi() {
		return deskripsi;
	}

	public void setDeskripsi(String deskripsi) {
		this.deskripsi = deskripsi;
	}

	public Integer getIdKelompok() {
		return idKelompok;
	}

	public void setIdKelompok(Integer idKelompok) {
		this.idKelompok = idKelompok;
	}

	public Date getTanggal() {
		return tanggal;
	}

	public void setTanggal(Date tanggal) {
		this.tanggal = tanggal;
	}

	public String getLaporan() {
		return laporan;
	}

	public void setLaporan(String laporan) {
		this.laporan = laporan;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	public KelompokTani getKelompokTani() {
		return kelompokTani;
	}

	public void setKelompokTani(KelompokTani kelompokTani) {
		this.kelompokTani = kelompokTani;
	}
}
