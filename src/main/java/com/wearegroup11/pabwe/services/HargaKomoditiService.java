package com.wearegroup11.pabwe.services;

import com.wearegroup11.pabwe.models.HargaKomoditi;

import java.util.List;

public interface HargaKomoditiService {

    List<HargaKomoditi> listHargaKomoditi();

    HargaKomoditi saveOrUpdate(HargaKomoditi hasilPertanian);

    HargaKomoditi getHargaKomoditiById(long id);

    void delete(long id);
}
