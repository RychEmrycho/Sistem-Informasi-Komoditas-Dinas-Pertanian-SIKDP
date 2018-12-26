package com.wearegroup11.pabwe.models;

import javax.persistence.*;
import java.sql.Date;

@Entity(name = "Bantuan")
@Table(name = "bantuan")
public class Bantuan {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

    private String namaBantuan;
	private String deskripsi;
	private Date tanggal;
    private String proposal;
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

    public String getNamaBantuan() {
        return namaBantuan;
    }

    public void setNamaBantuan(String namaBantuan) {
        this.namaBantuan = namaBantuan;
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

    public KelompokTani getKelompokTani() {
        return kelompokTani;
    }

    public void setKelompokTani(KelompokTani kelompokTani) {
        this.kelompokTani = kelompokTani;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}
}
