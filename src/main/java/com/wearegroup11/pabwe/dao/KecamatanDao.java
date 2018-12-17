package com.wearegroup11.pabwe.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wearegroup11.pabwe.models.Kecamatan;
import com.wearegroup11.pabwe.services.KecamatanService;

@Service
public class KecamatanDao implements KecamatanService {

	private EntityManager em;
	
	@Autowired
	public void setEmf(EntityManagerFactory emf) {
		em = emf.createEntityManager();
	}
	
	@Override
	public List<Kecamatan> listKecamatan() {
		// TODO Auto-generated method stub
		return em.createQuery("from Kecamatan", Kecamatan.class).getResultList();
	}

	@Override
	public Kecamatan saveOrUpdate(Kecamatan kecamatan) {
		// TODO Auto-generated method stub
		em.getTransaction().begin();
		Kecamatan saved = em.merge(kecamatan);
		em.getTransaction().commit();
		return saved;
	}

	@Override
	public Kecamatan getKecamatanById(long id) {
		// TODO Auto-generated method stub
		return em.find(Kecamatan.class, id);
	}

	@Override
	public void delete(long id) {
		// TODO Auto-generated method stub
		em.getTransaction().begin();
		em.remove(em.find(Kecamatan.class, id));
		em.getTransaction().commit();
	}

}
