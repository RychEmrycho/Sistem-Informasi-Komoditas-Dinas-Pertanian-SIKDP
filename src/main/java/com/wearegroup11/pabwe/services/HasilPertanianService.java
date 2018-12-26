package com.wearegroup11.pabwe.services;

import com.wearegroup11.pabwe.models.HasilPertanian;

import java.util.List;

public interface HasilPertanianService {

    List<HasilPertanian> listHasilPertanian();

    HasilPertanian saveOrUpdate(HasilPertanian hasilPertanian);

    HasilPertanian getHasilPertanianById(long id);

    void delete(long id);
}
