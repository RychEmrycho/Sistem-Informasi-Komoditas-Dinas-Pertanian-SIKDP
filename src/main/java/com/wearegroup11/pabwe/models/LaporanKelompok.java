package com.wearegroup11.pabwe.models;

import javax.persistence.*;
import java.sql.Date;

@Entity(name = "LaporanKelompok")
@Table(name = "laporan_kelompok")
public class LaporanKelompok {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String namaLaporan;
	private String deskripsi;
	private Date tanggal;
	private String laporan;
    private Integer status;

	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_kelompok")
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

    public Integer getStatus() {
		return status;
	}

    public void setStatus(Integer status) {
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
