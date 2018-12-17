package com.wearegroup11.pabwe.services;

import java.util.List;

import com.wearegroup11.pabwe.models.Kelurahan;

public interface KelurahanService {
	List<Kelurahan> listKelurahan();
	
	Kelurahan saveOrUpdate(Kelurahan kelurahan);
	
	Kelurahan getKelurahanById(long id);
	
	void delete(long id);
}
