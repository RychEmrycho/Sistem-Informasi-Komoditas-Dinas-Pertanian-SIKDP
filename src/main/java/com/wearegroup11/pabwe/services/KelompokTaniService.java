package com.wearegroup11.pabwe.services;

import com.wearegroup11.pabwe.models.KelompokTani;

import java.util.List;

public interface KelompokTaniService {
	
	List<KelompokTani> listKelompokTani();
	
	KelompokTani saveOrUpdate(KelompokTani kelompok);
	
	KelompokTani getKelompokTaniById(long id);
	
	void delete(long id);

	void updateStatus(Integer status, Long id);

}
