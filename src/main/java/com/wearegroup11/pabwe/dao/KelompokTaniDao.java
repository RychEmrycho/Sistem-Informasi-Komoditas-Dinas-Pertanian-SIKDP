package com.wearegroup11.pabwe.dao;

import com.wearegroup11.pabwe.models.KelompokTani;
import com.wearegroup11.pabwe.models.User;
import com.wearegroup11.pabwe.services.KelompokTaniService;
import com.wearegroup11.pabwe.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

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
		return em.createQuery("from KelompokTani", KelompokTani.class).getResultList();
	}

	@Override
	public KelompokTani saveOrUpdate(KelompokTani kelompok) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        em.getTransaction().begin();
        User user = userService.findByEmail(auth.getName());
        user.setKelompokTani(kelompok);
        kelompok.setUser(user);
		KelompokTani saved = em.merge(kelompok);
		em.getTransaction().commit();
		return saved;
	}

    @Override
    public void updateStatus(Integer status, Long id) {
        em.getTransaction().begin();
        KelompokTani kelompokTani = em.find(KelompokTani.class, id);
        kelompokTani.setStatus(status);
        em.merge(kelompokTani);
        em.getTransaction().commit();
    }

	@Override
	public KelompokTani getKelompokTaniById(long id) {
		return em.find(KelompokTani.class, id);
	}

	@Override
	public void delete(long id) {
		em.getTransaction().begin();
		em.remove(em.find(KelompokTani.class, id));
		em.getTransaction().commit();
	}
}
