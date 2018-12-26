package com.wearegroup11.pabwe.services;

import com.wearegroup11.pabwe.models.LaporanKelompok;

import java.util.List;

public interface LaporanKelompokService {
	List<LaporanKelompok> listLaporanKelompok();
	
	LaporanKelompok saveOrUpdate(LaporanKelompok laporanKelompok);
	
	LaporanKelompok getLaporanKelompokById(long id);
	
	void delete(long id);

    void updateStatus(Integer status, Long id);
}
