package com.wearegroup11.pabwe.controllers;

import com.wearegroup11.pabwe.services.KelompokTaniService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.wearegroup11.pabwe.models.LaporanKelompok;
import com.wearegroup11.pabwe.services.LaporanKelompokService;




@Controller
@RequestMapping("laporan-kelompok")
public class LaporanKelompokController {
	
	private LaporanKelompokService laporanKelompokService;
	private KelompokTaniService kelompokTaniService;

	@Autowired
	public void injectDependency(LaporanKelompokService laporanKelompokService, KelompokTaniService kelompokTaniService) {
		this.laporanKelompokService = laporanKelompokService;
		this.kelompokTaniService = kelompokTaniService;
	}
	
	@RequestMapping("")
	public String ListLaporanKelompok(Model model) {
		model.addAttribute("kelompokService", kelompokTaniService);
		model.addAttribute("laporanKelompok", laporanKelompokService.listLaporanKelompok());
		return "/laporan-kelompok/index-laporan-kelompok";
	}
	
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String tampilkanForm(Model model) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//		LaporanKelompok laporanKelompok = kelompokTaniService.getKelompokTaniById(auth.getDetails())

		model.addAttribute("laporanKelompok", new LaporanKelompok());
		return "/laporan-kelompok/formLaporanKelompok";
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String simpanDataLaporanKelompok(Model model, LaporanKelompok laporanKelompok) {
		model.addAttribute("laporanKelompok", laporanKelompokService.saveOrUpdate(laporanKelompok));
		return "redirect:/laporan-kelompok";
	}
	
	@RequestMapping("/edit/{id}")
	public String tampilkanFormUpdate(@PathVariable("id") int id, Model model) {
		model.addAttribute("laporanKelompok", laporanKelompokService.getLaporanKelompokById(id));
		return "/laporan-kelompok/formLaporanKelompok";
	}

	@RequestMapping("/view/{id}")
	public String tampilkanDetail(@PathVariable("id") long id, Model model) {
		model.addAttribute("laporanKelompok", laporanKelompokService.getLaporanKelompokById(id));
		return "/laporan-kelompok/view-laporan-kelompok";
	}
	
	
	@RequestMapping("/hapus/{id}")
	public String deleteDataKelurahan(@PathVariable("id") int id) {
		laporanKelompokService.delete(id);
		return "redirect:/laporan-kelompok";
	}
}
