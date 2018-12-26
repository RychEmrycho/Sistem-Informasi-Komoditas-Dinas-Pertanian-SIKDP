package com.wearegroup11.pabwe.dao;

import com.wearegroup11.pabwe.models.HargaKomoditi;
import com.wearegroup11.pabwe.services.HargaKomoditiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

@Service
public class HargaKomoditiDao implements HargaKomoditiService {

    private EntityManager em;

    @Autowired
    public void setEmf(EntityManagerFactory emf) {
        em = emf.createEntityManager();
    }

    public List<HargaKomoditi> listHargaKomoditi() {
        return em.createQuery("from HargaKomoditi ", HargaKomoditi.class).getResultList();
    }

    @Override
    public HargaKomoditi saveOrUpdate(HargaKomoditi hargaKomoditi) {
        em.getTransaction().begin();
        HargaKomoditi saved = em.merge(hargaKomoditi);
        em.getTransaction().commit();
        return saved;
    }

    @Override
    public HargaKomoditi getHargaKomoditiById(long id) {
        return em.find(HargaKomoditi.class, id);
    }

    @Override
    public void delete(long id) {
        em.getTransaction().begin();
        em.remove(em.find(HargaKomoditi.class, id));
        em.getTransaction().commit();
    }
}

