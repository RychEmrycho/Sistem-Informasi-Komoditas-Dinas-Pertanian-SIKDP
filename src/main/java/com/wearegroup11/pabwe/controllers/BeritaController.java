package com.wearegroup11.pabwe.controllers;

import com.wearegroup11.pabwe.models.Berita;
import com.wearegroup11.pabwe.models.KomentarBerita;
import com.wearegroup11.pabwe.services.BeritaService;
import com.wearegroup11.pabwe.services.KomentarBeritaService;
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
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.Calendar;

@Controller
@RequestMapping("berita")
public class BeritaController {

	private final Logger logger = LoggerFactory.getLogger(BeritaController.class);
	private BeritaService beritaService;
	private StorageService storageService;
	private UserService userService;
	private KomentarBeritaService komentarBeritaService;

	@Autowired
	public void injectDependency(BeritaService beritaService, StorageService storageService, UserService userService, KomentarBeritaService komentarBeritaService) {
		this.storageService = storageService;
		this.beritaService = beritaService;
		this.userService = userService;
		this.komentarBeritaService = komentarBeritaService;
	}

	@RequestMapping("")
	public String ListBerita(Model model) {
		model.addAttribute("berita", beritaService.listBerita());
		return "berita/index-berita";
	}

	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String tampilkanForm(Model model) {

		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Berita berita = new Berita();

		berita.setId_user(userService.findByEmail(auth.getName()).getId());

		Calendar calendar = Calendar.getInstance();
		Date tanggal = new Date((calendar.getTime()).getTime());

		berita.setTanggal(tanggal);
		model.addAttribute("berita", berita);

		return "berita/formBerita";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String simpanDataBerita(Model model, final @ModelAttribute(value = "berita") @Valid Berita berita, BindingResult bindingResult, final @RequestParam(value = "foto") MultipartFile uploadingFile) {
		storageService.store(uploadingFile);
		berita.setFoto(uploadingFile.getOriginalFilename());

		model.addAttribute("berita", beritaService.saveOrUpdate(berita));
		return "redirect:/berita";
	}

	@RequestMapping("/edit/{id}")
	public String tampilkanFormUpdate(@PathVariable("id") long id, Model model) {
		model.addAttribute("berita", beritaService.getBeritaById(id));
		return "berita/formBerita";
	}

	@RequestMapping("/view/{id}")
	public String tampilkanDetail(@PathVariable("id") long id, Model model) {
		Berita berita = beritaService.getBeritaById(id);
		model.addAttribute("berita", beritaService.getBeritaById(id));

		KomentarBerita komentarBerita = new KomentarBerita();

		model.addAttribute("komentarForm", komentarBerita);
		model.addAttribute("userService" , userService);
		model.addAttribute("komentar", komentarBeritaService.listKomentarBerita(id));

		userService.findById(berita.getId_user()).ifPresent(user_author -> {
			model.addAttribute("author", user_author.getNamaDepan() + " " + user_author.getNamaBelakang());
		});

		return "berita/view-berita";
	}

	@RequestMapping(value = "/post-comment-for-berita/{id}", method = RequestMethod.POST)
	public String postKomentarBerita(@PathVariable("id") long id, Model model, KomentarBerita komentarBerita) {

		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		komentarBerita.setIdUser(userService.findByEmail(auth.getName()).getId());
		komentarBerita.setWaktu(new Timestamp(System.currentTimeMillis()));
		komentarBerita.setIdBerita(id);
		model.addAttribute("komentar", komentarBeritaService.saveOrUpdate(komentarBerita));

		return "redirect:/berita/view/" + id +"#komentar";
	}

	@RequestMapping("/hapus/{id}")
	public String deleteDataBerita(@PathVariable("id") long id) {
		beritaService.delete(id);
		return "redirect:/berita";
	}
}
