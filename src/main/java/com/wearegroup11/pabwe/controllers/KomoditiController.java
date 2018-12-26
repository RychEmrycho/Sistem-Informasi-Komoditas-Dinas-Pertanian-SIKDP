package com.wearegroup11.pabwe.controllers;

import com.wearegroup11.pabwe.models.Komoditi;
import com.wearegroup11.pabwe.services.KomoditiService;
import com.wearegroup11.pabwe.storage.StorageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;

@Controller
@RequestMapping("komoditi")
public class KomoditiController {

    private final Logger logger = LoggerFactory.getLogger(KomoditiController.class);

    private KomoditiService komoditiService;
    private StorageService storageService;

    @Autowired
    public void injectDependency(KomoditiService komoditiService, StorageService storageService) {
        this.storageService = storageService;
        this.komoditiService = komoditiService;
    }

    @RequestMapping("")
    public String ListKomoditi(Model model) {
        model.addAttribute("komoditi", komoditiService.listKomoditi());
        return "komoditi/index-komoditi";
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String tampilkanForm(Model model) {

        Komoditi komoditi = new Komoditi();
        model.addAttribute("komoditi", komoditi);

        return "komoditi/formKomoditi";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String simpanData(Model model, final @ModelAttribute(value = "komoditi") @Valid Komoditi komoditi, BindingResult bindingResult, final @RequestParam(value = "foto") MultipartFile uploadingFile) {
        storageService.store(uploadingFile);
        komoditi.setFoto(uploadingFile.getOriginalFilename());

        model.addAttribute("berita", komoditiService.saveOrUpdate(komoditi));
        return "redirect:/komoditi";
    }

    @RequestMapping("/edit/{id}")
    public String tampilkanFormUpdate(@PathVariable("id") long id, Model model) {
        model.addAttribute("komoditi", komoditiService.getById(id));
        return "komoditi/formKomoditi";
    }

    @RequestMapping("/view/{id}")
    public String tampilkanDetail(@PathVariable("id") long id, Model model) {
        Komoditi komoditi = komoditiService.getById(id);
        model.addAttribute("komoditi", komoditi);
        return "komoditi/view-komoditi";
    }

    @RequestMapping("/hapus/{id}")
    public String deleteData(@PathVariable("id") long id) {
        komoditiService.delete(id);
        return "redirect:/komoditi";
    }
}
