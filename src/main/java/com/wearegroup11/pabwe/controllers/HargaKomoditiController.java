package com.wearegroup11.pabwe.controllers;

import com.wearegroup11.pabwe.models.HargaKomoditi;
import com.wearegroup11.pabwe.services.HargaKomoditiService;
import com.wearegroup11.pabwe.services.KomoditiService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Timestamp;

@Controller
@RequestMapping("/harga-komoditi")
public class HargaKomoditiController {

    private HargaKomoditiService hargaKomoditiService;
    private KomoditiService komoditiService;

    private Logger logger = LoggerFactory.getLogger(HargaKomoditiController.class);

    @Autowired
    public void injectDependency(HargaKomoditiService hargaKomoditiService, KomoditiService komoditiService) {
        this.hargaKomoditiService = hargaKomoditiService;
        this.komoditiService = komoditiService;
    }

    @RequestMapping("")
    public String ListPengumuman(Model model) {
        model.addAttribute("hargaKomoditi", hargaKomoditiService.listHargaKomoditi());
        return "/harga-komoditi/index-harga-komoditi";
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String tampilkanForm(Model model) {
        HargaKomoditi hargaKomoditi = new HargaKomoditi();

        Timestamp tanggal = new Timestamp(System.currentTimeMillis());

        hargaKomoditi.setTanggal(tanggal);
        model.addAttribute("hargaKomoditi", hargaKomoditi);
        model.addAttribute("listKomoditi", komoditiService.listKomoditi());

        return "/harga-komoditi/formHargaKomoditi";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String simpanDataHargaKomoditi(@RequestParam("idKomoditi") String idKomoditi, Model model, HargaKomoditi hargaKomoditi) {
        hargaKomoditi.setKomoditi(komoditiService.getById(Integer.parseInt(idKomoditi)));
        model.addAttribute("hargaKomoditi", hargaKomoditiService.saveOrUpdate(hargaKomoditi));
        return "redirect:/harga-komoditi";
    }

    @RequestMapping("/edit/{id}")
    public String tampilkanFormUpdate(@PathVariable("id") long id, Model model) {
        model.addAttribute("listKomoditi", komoditiService.listKomoditi());
        model.addAttribute("hargaKomoditi", hargaKomoditiService.getHargaKomoditiById(id));
        return "harga-komoditi/formHargaKomoditi";
    }

    @RequestMapping("/hapus/{id}")
    public String deleteDataHargaKomoditi(@PathVariable("id") long id) {
        hargaKomoditiService.delete(id);
        return "redirect:/harga-komoditi";
    }

}