package com.wearegroup11.pabwe.services;

import com.wearegroup11.pabwe.models.Komoditi;

import java.util.List;

public interface KomoditiService {

    List<Komoditi> listKomoditi();

    Komoditi saveOrUpdate(Komoditi komoditi);

    Komoditi getById(long id);

    void delete(long id);
}