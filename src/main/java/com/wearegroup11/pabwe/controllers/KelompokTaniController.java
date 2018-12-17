package com.wearegroup11.pabwe.controllers;

import com.wearegroup11.pabwe.services.KecamatanService;
import com.wearegroup11.pabwe.services.KelurahanService;
import com.wearegroup11.pabwe.services.UserService;
import com.wearegroup11.pabwe.storage.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.wearegroup11.pabwe.models.KelompokTani;
import com.wearegroup11.pabwe.services.KelompokTaniService;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;

@Controller
@RequestMapping("kelompok-tani")
public class KelompokTaniController {

	private KelompokTaniService kelompokTaniService;
	private KelurahanService kelurahanService;
	private KecamatanService kecamatanService;
	private UserService userService;
	private StorageService storageService;

	@Autowired
	public void injectDependency(KelompokTaniService kelompokTaniService, KelurahanService kelurahanService, KecamatanService kecamatanService, UserService userService, StorageService storageService) {
		this.kelompokTaniService = kelompokTaniService;
		this.kelurahanService = kelurahanService;
		this.kecamatanService = kecamatanService;
		this.userService = userService;
		this.storageService = storageService;
	}
	
	@RequestMapping("")
	public String ListKelompokTani(Model model) {
		model.addAttribute("userService", userService);
		model.addAttribute("kelompok", kelompokTaniService.listKelompokTani());
		return "kelompok-tani/index";
	}
	
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String tampilkanForm(Model model) {
		model.addAttribute("kelurahan",kelurahanService.listKelurahan());
		model.addAttribute("kecamatan", kecamatanService.listKecamatan());

		KelompokTani kelompokTani = new KelompokTani();
		model.addAttribute("kelompok", kelompokTani);
		return "kelompok-tani/formKelompokTani";
	}

	//	@RequestMapping(value = "/save", method = RequestMethod.POST)
//	public String simpanDataBerita(Model model, final @ModelAttribute(value = "berita")
//	@Valid Berita berita, BindingResult bindingResult, final @RequestParam(value = "foto") MultipartFile uploadingFile) {
//		storageService.store(uploadingFile);
//		berita.setFoto(uploadingFile.getOriginalFilename());
//
//		model.addAttribute("berita", beritaService.saveOrUpdate(berita));
//		return "redirect:/berita";
//	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String simpanDataKelompoktani(Model model, final @ModelAttribute(value = "kelompok") @Valid KelompokTani kelompokTani, BindingResult bindingResult, final @RequestParam(value = "proposal") MultipartFile uploadedFile) {
		storageService.store(uploadedFile);
		kelompokTani.setProposal(uploadedFile.getOriginalFilename());
		model.addAttribute("kelompoktani", kelompokTaniService.saveOrUpdate(kelompokTani));
		return "redirect:/kelompok-tani";
	}
	
	@RequestMapping("/edit/{id}")
	public String tampilkanFormUpdate(@PathVariable("id") long id, Model model) {
		model.addAttribute("kelurahan",kelurahanService.listKelurahan());
		model.addAttribute("kecamatan", kecamatanService.listKecamatan());
		model.addAttribute("kelompok", kelompokTaniService.getKelompokTaniById(id));
		return "kelompok-tani/formKelompokTani";
	}
	
	@RequestMapping("/hapus/{id}")
	public String deleteDataKelompokTani(@PathVariable("id") long id) {
		kelompokTaniService.delete(id);
		return "redirect:/kelompok-tani";
	}

}
