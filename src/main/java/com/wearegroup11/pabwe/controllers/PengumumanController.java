package com.wearegroup11.pabwe.controllers;

import com.wearegroup11.pabwe.services.PengumumanService;
import com.wearegroup11.pabwe.services.UserService;
import com.wearegroup11.pabwe.storage.StorageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.wearegroup11.pabwe.models.Pengumuman;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.Calendar;

@Controller
@RequestMapping("/pengumuman")
public class PengumumanController {

    private PengumumanService pengumumanService;
    private UserService userService;
    private StorageService storageService;

    private Logger logger = LoggerFactory.getLogger(PengumumanController.class);

    @Autowired
    public void injectDependency(PengumumanService pengumumanService, UserService userService, StorageService storageService) {
        this.pengumumanService = pengumumanService;
        this.userService = userService;
        this.storageService = storageService;
    }

    @RequestMapping("")
    public String ListPengumuman(Model model) {
        model.addAttribute("pengumuman", pengumumanService.listPengumuman());
        return "/pengumuman/index-pengumuman";
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String tampilkanForm(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Pengumuman pengumuman = new Pengumuman();
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());

        logger.error("MEH: " + auth.getName());

        pengumuman.setId_user(userService.findByEmail(auth.getName()).getId());
        pengumuman.setTanggal(timestamp);

        model.addAttribute("pengumuman", pengumuman);
        return "/pengumuman/formPengumuman";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String simpanDataPengumuman(Model model, final @ModelAttribute(value = "berita") @Valid Pengumuman pengumuman, BindingResult bindingResult, final @RequestParam(value = "lampiran") MultipartFile uploadingFile) {
        storageService.store(uploadingFile);
        pengumuman.setLampiran(uploadingFile.getOriginalFilename());

        model.addAttribute("pengumuman", pengumumanService.saveOrUpdate(pengumuman));
        return "redirect:/pengumuman";
    }

    @RequestMapping("/edit/{id}")
    public String tampilkanFormUpdate(@PathVariable("id") long id, Model model) {
        model.addAttribute("pengumuman", pengumumanService.getPengumumanById(id));
        return "/pengumuman/formPengumuman";
    }

    @RequestMapping("/view/{id}")
    public String tampilkanDetail(@PathVariable("id") long id, Model model) {
        Pengumuman pengumuman = pengumumanService.getPengumumanById(id);

        logger.error("Pengumuman: " + pengumuman);

        userService.findById(pengumuman.getId_user()).ifPresent(user_author -> {
            model.addAttribute("author", "oleh: "+ user_author.getNamaDepan() + " " + user_author.getNamaBelakang());
        });

        model.addAttribute("pengumuman", pengumuman);

        return "/pengumuman/view-pengumuman";
    }

    @RequestMapping("/hapus/{id}")
    public String deleteDataPengumuman(@PathVariable("id") long id) {
        pengumumanService.delete(id);
        return "redirect:/pengumuman";
    }

}