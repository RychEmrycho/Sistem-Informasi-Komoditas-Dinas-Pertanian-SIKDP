package com.wearegroup11.pabwe.controllers;

import com.wearegroup11.pabwe.models.KelompokTani;
import com.wearegroup11.pabwe.services.KelompokTaniService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.wearegroup11.pabwe.models.Bantuan;
import com.wearegroup11.pabwe.services.BantuanService;

@Controller
@RequestMapping("bantuan")
public class BantuanController {

	private BantuanService bantuanService;
	private KelompokTaniService kelompokTaniService;

	@Autowired
	public void injectDependency(BantuanService bantuanService, KelompokTaniService kelompokTaniService) {
		this.bantuanService = bantuanService;
		this.kelompokTaniService = kelompokTaniService;
	}
	
	@RequestMapping("")
	public String ListBantuan(Model model) {
		model.addAttribute("bantuan", bantuanService.listBantuan());
		return "/bantuan/index";
	}
	
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String tampilkanForm(Model model) {
		model.addAttribute("bantuan", new Bantuan());
		return "/bantuan/formBantuan";
	}
	
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String simpanDataBantuan(Model model, Bantuan Bantuan) {
		model.addAttribute("bantuan", bantuanService.saveOrUpdate(Bantuan));
		return "redirect:/bantuan";
	}
	
	@RequestMapping("/edit/{id}")
	public String tampilkanFormUpdate(@PathVariable("id") long id, Model model) {
		model.addAttribute("bantuan", bantuanService.getBantuanById(id));
		return "/bantuan/formBantuan";
	}
	
	@RequestMapping("/view/{id}")
	public String tampilkanDetail(@PathVariable("id") long id, Model model) {

		Bantuan bantuan = bantuanService.getBantuanById(id);

		KelompokTani kelompokTani = kelompokTaniService.getKelompokTaniById(bantuan.getId_kelompok());
		model.addAttribute("namaKelompok", "created by: "+ kelompokTani.getNamaKelompok());

		model.addAttribute("bantuan", bantuanService.getBantuanById(id));
		return "/bantuan/view-bantuan";
	}
	
	@RequestMapping("/hapus/{id}")
	public String deleteDataBantuan(@PathVariable("id") long id) {
		bantuanService.delete(id);
		return "redirect:/bantuan";
	}

}
