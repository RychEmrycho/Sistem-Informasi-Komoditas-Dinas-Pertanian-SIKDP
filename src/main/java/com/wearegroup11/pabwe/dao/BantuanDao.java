package com.wearegroup11.pabwe.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wearegroup11.pabwe.models.Bantuan;
import com.wearegroup11.pabwe.services.BantuanService;

@Service
public class BantuanDao implements BantuanService {

	private EntityManager em;
	
	@Autowired
	public void setEmf(EntityManagerFactory emf) {
		em = emf.createEntityManager();
	}
	
	@Override
	public List<Bantuan> listBantuan() {
		// TODO Auto-generated method stub
		return em.createQuery("from Bantuan", Bantuan.class).getResultList();
	}

	@Override
	public Bantuan saveOrUpdate(Bantuan bantuan) {
		// TODO Auto-generated method stub
		em.getTransaction().begin();
		Bantuan saved = em.merge(bantuan);
		em.getTransaction().commit();
		return saved;
	}

	@Override
	public Bantuan getBantuanById(long id) {
		// TODO Auto-generated method stub
		return em.find(Bantuan.class, id);
	}

	@Override
	public void delete(long id) {
		// TODO Auto-generated method stub
		em.getTransaction().begin();
		em.remove(em.find(Bantuan.class, id));
		em.getTransaction().commit();
	}

}
