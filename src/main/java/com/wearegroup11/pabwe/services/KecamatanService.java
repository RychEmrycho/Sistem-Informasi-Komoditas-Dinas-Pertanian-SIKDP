package com.wearegroup11.pabwe.services;

import java.util.List;

import com.wearegroup11.pabwe.models.Kecamatan;

public interface KecamatanService {
	List<Kecamatan> listKecamatan();
	
	Kecamatan saveOrUpdate(Kecamatan kecamatan);
	
	Kecamatan getKecamatanById(long id);
	
	void delete(long id);
}
