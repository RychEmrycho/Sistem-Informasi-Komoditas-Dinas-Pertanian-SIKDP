package com.wearegroup11.pabwe.services;

import java.util.List;

import com.wearegroup11.pabwe.models.KelompokTani;

public interface KelompokTaniService {
	
	List<KelompokTani> listKelompokTani();
	
	KelompokTani saveOrUpdate(KelompokTani kelompok);
	
	KelompokTani getKelompokTaniById(long id);
	
	void delete(long id);
	
}
