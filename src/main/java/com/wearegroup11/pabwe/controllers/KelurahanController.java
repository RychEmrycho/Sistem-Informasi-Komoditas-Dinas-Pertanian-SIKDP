package com.wearegroup11.pabwe.controllers;

import com.wearegroup11.pabwe.services.KecamatanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.wearegroup11.pabwe.models.KelompokTani;
import com.wearegroup11.pabwe.models.Kelurahan;
import com.wearegroup11.pabwe.services.KelurahanService;


@Controller
@RequestMapping("kelurahan")
public class KelurahanController {
	
	private KelurahanService kelurahanService;
	private KecamatanService kecamatanService;

	@Autowired
	public void injectDependency(KelurahanService kelurahanService, KecamatanService kecamatanService) {
		this.kelurahanService = kelurahanService;
		this.kecamatanService = kecamatanService;
	}
	
	@RequestMapping("")
	public String ListKelurahan(Model model) {
		model.addAttribute("kecamatanService", kecamatanService);
		model.addAttribute("kelurahan", kelurahanService.listKelurahan());
		return "/kelurahan/index-kelurahan";
	}
	
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String tampilkanForm(Model model) {
		Kelurahan kelurahan = new Kelurahan();

		model.addAttribute("kecamatan", kecamatanService.listKecamatan());
		model.addAttribute("kelurahan", kelurahan);
		return "/kelurahan/formKelurahan";
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String simpanDataKelurahan(Model model, Kelurahan kelurahan) {
		model.addAttribute("kelurahan", kelurahanService.saveOrUpdate(kelurahan));
		return "redirect:/kelurahan";
	}
	
	
	@RequestMapping("/edit/{id}")
	public String tampilkanFormUpdate(@PathVariable("id") int id, Model model) {
		model.addAttribute("kecamatan", kecamatanService.listKecamatan());
		model.addAttribute("kelurahan", kelurahanService.getKelurahanById(id));
		return "/kelurahan/formKelurahan";
	}
	
	@RequestMapping("/hapus/{id}")
	public String deleteDataKelurahan(@PathVariable("id") int id) {
		kelurahanService.delete(id);
		return "redirect:/kelurahan";
	}
}
