package com.wearegroup11.pabwe.services;

import java.util.List;

import com.wearegroup11.pabwe.models.LaporanKelompok;

public interface LaporanKelompokService {
	List<LaporanKelompok> listLaporanKelompok();
	
	LaporanKelompok saveOrUpdate(LaporanKelompok laporanKelompok);
	
	LaporanKelompok getLaporanKelompokById(long id);
	
	void delete(long id);
}
