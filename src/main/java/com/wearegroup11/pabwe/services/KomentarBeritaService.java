package com.wearegroup11.pabwe.services;

import com.wearegroup11.pabwe.models.KomentarBerita;

import java.util.List;

public interface KomentarBeritaService {

    List<KomentarBerita> listKomentarBerita(long id);

    KomentarBerita saveOrUpdate(KomentarBerita berita);

    KomentarBerita getKomentarBeritaById(long id);

    void delete(long id);

}
