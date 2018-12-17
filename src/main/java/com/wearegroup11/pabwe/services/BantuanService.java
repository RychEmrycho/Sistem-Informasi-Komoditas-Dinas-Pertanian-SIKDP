package com.wearegroup11.pabwe.services;

import java.util.List;

import com.wearegroup11.pabwe.models.Bantuan;

public interface BantuanService {
	
	List<Bantuan> listBantuan();
	
	Bantuan saveOrUpdate(Bantuan bantuan);
	
	Bantuan getBantuanById(long id);
	
	void delete(long id);
	
}
