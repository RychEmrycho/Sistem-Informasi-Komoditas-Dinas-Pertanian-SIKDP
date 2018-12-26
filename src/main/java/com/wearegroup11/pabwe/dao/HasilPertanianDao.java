package com.wearegroup11.pabwe.dao;

import com.wearegroup11.pabwe.models.HasilPertanian;
import com.wearegroup11.pabwe.services.HasilPertanianService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

@Service
public class HasilPertanianDao implements HasilPertanianService {

    private EntityManager em;

    @Autowired
    public void setEmf(EntityManagerFactory emf) {
        em = emf.createEntityManager();
    }

    @Override
    public List<HasilPertanian> listHasilPertanian() {
        return em.createQuery("from HasilPertanian", HasilPertanian.class).getResultList();
    }

    @Override
    public HasilPertanian saveOrUpdate(HasilPertanian hasilPertanian) {
        em.getTransaction().begin();
        HasilPertanian saved = em.merge(hasilPertanian);
        em.getTransaction().commit();
        return saved;
    }

    @Override
    public HasilPertanian getHasilPertanianById(long id) {
        return em.find(HasilPertanian.class, id);
    }

    @Override
    public void delete(long id) {
        em.getTransaction().begin();
        em.remove(em.find(HasilPertanian.class, id));
        em.getTransaction().commit();
    }
}

