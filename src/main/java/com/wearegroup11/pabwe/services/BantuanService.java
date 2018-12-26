package com.wearegroup11.pabwe.services;

import com.wearegroup11.pabwe.models.Bantuan;

import java.util.List;

public interface BantuanService {
	
	List<Bantuan> listBantuan();
	
	Bantuan saveOrUpdate(Bantuan bantuan);
	
	Bantuan getBantuanById(long id);
	
	void delete(long id);

    void updateStatus(Integer status, Long id);
}