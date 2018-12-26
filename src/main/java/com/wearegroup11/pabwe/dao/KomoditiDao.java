package com.wearegroup11.pabwe.dao;

import com.wearegroup11.pabwe.models.Komoditi;
import com.wearegroup11.pabwe.services.KomoditiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

@Service
public class KomoditiDao implements KomoditiService {

    private EntityManager em;

    @Autowired
    public void setEmf(EntityManagerFactory emf) {
        em = emf.createEntityManager();
    }

    @Override
    public List<Komoditi> listKomoditi() {
        return em.createQuery("from Komoditi", Komoditi.class).getResultList();
    }

    @Override
    public Komoditi saveOrUpdate(Komoditi komoditi) {
        em.getTransaction().begin();
        Komoditi saved = em.merge(komoditi);
        em.getTransaction().commit();
        return saved;
    }

    @Override
    public Komoditi getById(long id) {
        return em.find(Komoditi.class, id);
    }

    @Override
    public void delete(long id) {
        em.getTransaction().begin();
        em.remove(em.find(Komoditi.class, id));
        em.getTransaction().commit();
    }
}
