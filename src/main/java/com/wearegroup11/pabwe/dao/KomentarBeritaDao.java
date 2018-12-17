package com.wearegroup11.pabwe.dao;

import com.wearegroup11.pabwe.models.KomentarBerita;
import com.wearegroup11.pabwe.services.KomentarBeritaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

@Service
public class KomentarBeritaDao implements KomentarBeritaService {

    private EntityManager em;

    @Autowired
    public void setDependency(EntityManagerFactory emf){
        em = emf.createEntityManager();
    }

    @Override
    public List<KomentarBerita> listKomentarBerita(long id) {
        return em.createQuery("from KomentarBerita komentar WHERE komentar.idBerita IN :id ORDER BY komentar.id DESC", KomentarBerita.class)
                .setParameter("id", id)
                .getResultList();
    }

    @Override
    public KomentarBerita saveOrUpdate(KomentarBerita komentar) {
        em.getTransaction().begin();
        KomentarBerita saved = em.merge(komentar);
        em.getTransaction().commit();
        return null;
    }

    @Override
    public KomentarBerita getKomentarBeritaById(long id) {
        return em.find(KomentarBerita.class, id);
    }

    @Override
    public void delete(long id) {

        em.getTransaction().begin();
        em.remove(getKomentarBeritaById(id));
        em.getTransaction().commit();

    }
}
