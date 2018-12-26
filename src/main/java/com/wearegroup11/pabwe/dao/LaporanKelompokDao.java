package com.wearegroup11.pabwe.dao;

import com.wearegroup11.pabwe.models.LaporanKelompok;
import com.wearegroup11.pabwe.services.LaporanKelompokService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

@Service
public class LaporanKelompokDao implements LaporanKelompokService {
private EntityManager em;

	@Autowired
	public void setEmf(EntityManagerFactory emf) {
		em = emf.createEntityManager();
	}

	@Override
	public List<LaporanKelompok> listLaporanKelompok() {
		return em.createQuery("from LaporanKelompok", LaporanKelompok.class).getResultList();
	}

	@Override
	public LaporanKelompok saveOrUpdate(LaporanKelompok laporanKelompok) {
		em.getTransaction().begin();
		LaporanKelompok saved = em.merge(laporanKelompok);
		em.getTransaction().commit();
		return saved;
	}

	@Override
	public LaporanKelompok getLaporanKelompokById(long id) {
		return em.find(LaporanKelompok.class, id);
	}

	@Override
	public void delete(long id) {
		em.getTransaction().begin();
		em.remove(em.find(LaporanKelompok.class, id));
		em.getTransaction().commit();
	}

	@Override
	public void updateStatus(Integer status, Long id) {
		em.getTransaction().begin();
		LaporanKelompok laporanKelompok = em.find(LaporanKelompok.class, id);
		laporanKelompok.setStatus(status);
		em.merge(laporanKelompok);
		em.getTransaction().commit();
	}
}
