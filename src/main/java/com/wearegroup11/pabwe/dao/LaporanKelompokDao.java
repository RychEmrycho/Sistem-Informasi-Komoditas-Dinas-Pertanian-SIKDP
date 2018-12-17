package com.wearegroup11.pabwe.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wearegroup11.pabwe.models.LaporanKelompok;
import com.wearegroup11.pabwe.services.LaporanKelompokService;



@Service
public class LaporanKelompokDao implements LaporanKelompokService {
private EntityManager em;
	
	@Autowired
	public void setEmf(EntityManagerFactory emf) {
		em = emf.createEntityManager();
	}
	
	@Override
	public List<LaporanKelompok> listLaporanKelompok() {
		// TODO Auto-generated method stub
		return em.createQuery("from LaporanKelompok", LaporanKelompok.class).getResultList();
	}

	@Override
	public LaporanKelompok saveOrUpdate(LaporanKelompok laporanKelompok) {
		// TODO Auto-generated method stub
		em.getTransaction().begin();
		LaporanKelompok saved = em.merge(laporanKelompok);
		em.getTransaction().commit();
		return saved;
	}

	@Override
	public LaporanKelompok getLaporanKelompokById(long id) {
		// TODO Auto-generated method stub
		return em.find(LaporanKelompok.class, id);
	}

	@Override
	public void delete(long id) {
		// TODO Auto-generated method stub
		em.getTransaction().begin();
		em.remove(em.find(LaporanKelompok.class, id));
		em.getTransaction().commit();
	}
}
