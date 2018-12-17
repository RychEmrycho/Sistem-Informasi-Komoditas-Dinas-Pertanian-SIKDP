package com.wearegroup11.pabwe.services;

import java.util.List;

import com.wearegroup11.pabwe.models.Pengumuman;

public interface PengumumanService {
	
	List<Pengumuman> listPengumuman();
	
	Pengumuman saveOrUpdate(Pengumuman pengumuman);
	
	Pengumuman getPengumumanById(long id);
	
	void delete(long id);
}
