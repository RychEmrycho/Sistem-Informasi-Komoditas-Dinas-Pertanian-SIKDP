package com.wearegroup11.pabwe.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import com.wearegroup11.pabwe.models.User;
import com.wearegroup11.pabwe.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.wearegroup11.pabwe.models.KelompokTani;
import com.wearegroup11.pabwe.services.KelompokTaniService;

@Service
public class KelompokTaniDao implements KelompokTaniService {

	private EntityManager em;
	private UserService userService;
	
	@Autowired
	public void injectDependency(EntityManagerFactory emf, UserService userService) {
		em = emf.createEntityManager();
		this.userService = userService;
	}
	
	@Override
	public List<KelompokTani> listKelompokTani() {
		// TODO Auto-generated method stub
		return em.createQuery("from KelompokTani", KelompokTani.class).getResultList();
	}

	@Override
	public KelompokTani saveOrUpdate(KelompokTani kelompok) {
		// TODO Auto-generated method stub
		em.getTransaction().begin();

		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = userService.findByEmail(auth.getName());
		user.setKelompokTani(kelompok);

		KelompokTani saved = em.merge(kelompok);

		em.getTransaction().commit();
		return saved;
	}

	@Override
	public KelompokTani getKelompokTaniById(long id) {
		// TODO Auto-generated method stub
		return em.find(KelompokTani.class, id);
	}

	@Override
	public void delete(long id) {
		// TODO Auto-generated method stub
		em.getTransaction().begin();
		em.remove(em.find(KelompokTani.class, id));
		em.getTransaction().commit();
	}

}
