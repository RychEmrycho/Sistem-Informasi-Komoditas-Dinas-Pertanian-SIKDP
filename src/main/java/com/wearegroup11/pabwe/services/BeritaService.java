package com.wearegroup11.pabwe.services;

import java.util.List;

import com.wearegroup11.pabwe.models.Berita;

public interface BeritaService {

	List<Berita> listBerita();
	
	Berita saveOrUpdate(Berita berita);
	
	Berita getBeritaById(long id);
	
	void delete(long id);
}