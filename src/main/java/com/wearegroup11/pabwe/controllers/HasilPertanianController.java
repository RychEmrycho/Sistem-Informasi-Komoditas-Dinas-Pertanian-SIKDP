package com.wearegroup11.pabwe.controllers;

import com.wearegroup11.pabwe.models.HasilPertanian;
import com.wearegroup11.pabwe.models.KelompokTani;
import com.wearegroup11.pabwe.services.HasilPertanianService;
import com.wearegroup11.pabwe.services.KomoditiService;
import com.wearegroup11.pabwe.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Date;
import java.util.Calendar;

@Controller
@RequestMapping("/hasil-pertanian")
public class HasilPertanianController {

    private HasilPertanianService hasilPetanianService;
    private KomoditiService komoditiService;
    private UserService userService;

    private Logger logger = LoggerFactory.getLogger(HasilPertanianController.class);

    @Autowired
    public void injectDependency(HasilPertanianService hasilPertanianService, KomoditiService komoditiService, UserService userService) {
        this.hasilPetanianService = hasilPertanianService;
        this.komoditiService = komoditiService;
        this.userService = userService;
    }

    @RequestMapping("")
    public String ListPengumuman(Model model) {
        model.addAttribute("hasilPertanian", hasilPetanianService.listHasilPertanian());
        return "/hasil-pertanian/index-hasil-pertanian";
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String tampilkanForm(Model model) {
        HasilPertanian hasilPertanian = new HasilPertanian();
        Calendar calendar = Calendar.getInstance();
        Date bulan = new Date(calendar.getTime().getTime());

        hasilPertanian.setBulan(bulan);
        model.addAttribute("hasilPertanian", hasilPertanian);
        model.addAttribute("listKomoditi", komoditiService.listKomoditi());

        return "/hasil-pertanian/formHasilPertanian";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String simpanDataHasilPertanian(@RequestParam("idKomoditi") String idKomoditi, Model model, HasilPertanian hasilPertanian) {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        KelompokTani kelompokTani = userService.findByEmail(auth.getName()).getKelompokTani();
        hasilPertanian.setKelompokTani(kelompokTani);

        hasilPertanian.setKomoditi(komoditiService.getById(Integer.parseInt(idKomoditi)));

        model.addAttribute("hasilPertanian", hasilPetanianService.saveOrUpdate(hasilPertanian));
        return "redirect:/hasil-pertanian";
    }

    @RequestMapping("/edit/{id}")
    public String tampilkanFormUpdate(@PathVariable("id") long id, Model model) {
        model.addAttribute("listKomoditi", komoditiService.listKomoditi());
        model.addAttribute("hasilPertanian", hasilPetanianService.getHasilPertanianById(id));
        return "hasil-pertanian/formHasilPertanian";
    }


    @RequestMapping("/hapus/{id}")
    public String deleteDataHasilPertanian(@PathVariable("id") long id) {
        hasilPetanianService.delete(id);
        return "redirect:/hasil-pertanian";
    }

}