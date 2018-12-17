package com.wearegroup11.pabwe.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wearegroup11.pabwe.models.Berita;
import com.wearegroup11.pabwe.services.BeritaService;

@Service
public class BeritaDao implements BeritaService {

	private EntityManager em;
	
	@Autowired
	public void setEmf(EntityManagerFactory emf) {
		em = emf.createEntityManager();
	}
	
	@Override
	public List<Berita> listBerita() {
		// TODO Auto-generated method stub
		return em.createQuery("from Berita", Berita.class).getResultList();
	}

	@Override
	public Berita saveOrUpdate(Berita berita) {
		// TODO Auto-generated method stub
		em.getTransaction().begin();
		Berita saved = em.merge(berita);
		em.getTransaction().commit();
		return saved;
	}

	@Override
	public Berita getBeritaById(long id) {
		// TODO Auto-generated method stub
		return em.find(Berita.class, id);
	}

	@Override
	public void delete(long id) {
		// TODO Auto-generated method stub
		em.getTransaction().begin();
		em.remove(em.find(Berita.class, id));
		em.getTransaction().commit();
	}
	
}
