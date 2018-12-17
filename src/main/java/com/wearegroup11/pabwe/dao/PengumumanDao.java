package com.wearegroup11.pabwe.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wearegroup11.pabwe.models.Pengumuman;
import com.wearegroup11.pabwe.services.PengumumanService;

@Service
public class PengumumanDao implements PengumumanService {

	private EntityManager em;
	
	@Autowired
	public void setEmf(EntityManagerFactory emf) {
		em = emf.createEntityManager();
	}
	
	@Override
	public List<Pengumuman> listPengumuman() {
		// TODO Auto-generated method stub
		return em.createQuery("from Pengumuman", Pengumuman.class).getResultList();
	}

	@Override
	public Pengumuman saveOrUpdate(Pengumuman pengumuman) {
		// TODO Auto-generated method stub
		em.getTransaction().begin();
		Pengumuman saved = em.merge(pengumuman);
		em.getTransaction().commit();
		return saved;
	}

	@Override
	public Pengumuman getPengumumanById(long id) {
		// TODO Auto-generated method stub
		return em.find(Pengumuman.class, id);
	}

	@Override
	public void delete(long id) {
		// TODO Auto-generated method stub
		em.getTransaction().begin();
		em.remove(em.find(Pengumuman.class, id));
		em.getTransaction().commit();
	}

}
