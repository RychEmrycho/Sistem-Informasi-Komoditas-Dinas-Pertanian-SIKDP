package com.wearegroup11.pabwe.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wearegroup11.pabwe.models.Kelurahan;
import com.wearegroup11.pabwe.services.KelurahanService;

@Service
public class KelurahanDao implements KelurahanService {

	private EntityManager em;
	
	@Autowired
	public void setEmf(EntityManagerFactory emf) {
		em = emf.createEntityManager();
	}
	
	@Override
	public List<Kelurahan> listKelurahan() {
		// TODO Auto-generated method stub
		return em.createQuery("from Kelurahan", Kelurahan.class).getResultList();
	}

	@Override
	public Kelurahan saveOrUpdate(Kelurahan kelurahan) {
		// TODO Auto-generated method stub
		em.getTransaction().begin();
		Kelurahan saved = em.merge(kelurahan);
		em.getTransaction().commit();
		return saved;
	}

	@Override
	public Kelurahan getKelurahanById(long id) {
		// TODO Auto-generated method stub
		return em.find(Kelurahan.class, id);
	}

	@Override
	public void delete(long id) {
		// TODO Auto-generated method stub
		em.getTransaction().begin();
		em.remove(em.find(Kelurahan.class, id));
		em.getTransaction().commit();
	}

}

