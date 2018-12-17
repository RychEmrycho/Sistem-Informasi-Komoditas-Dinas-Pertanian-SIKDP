package com.wearegroup11.pabwe.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.wearegroup11.pabwe.models.Kecamatan;
import com.wearegroup11.pabwe.services.KecamatanService;


@Controller
@RequestMapping("kecamatan")
public class KecamatanController {
	
	private KecamatanService kecamatanService;

	@Autowired
	public void setKecamatanService(KecamatanService kecamatanService) {
		this.kecamatanService = kecamatanService;
	}
	
	@RequestMapping("")
	public String ListKecamatan(Model model) {
		model.addAttribute("kecamatan", kecamatanService.listKecamatan());
		return "/kecamatan/index-kecamatan";
	}
	
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String tampilkanForm(Model model) {
		model.addAttribute("kecamatan", new Kecamatan());
		return "/kecamatan/formKecamatan";
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String simpanDataKecamatan(Model model, Kecamatan kecamatan) {
		model.addAttribute("kecamatan", kecamatanService.saveOrUpdate(kecamatan));
		return "redirect:/kecamatan";
	}
	
	@RequestMapping("/edit/{id}")
	public String tampilkanFormUpdate(@PathVariable("id") int id, Model model) {
		model.addAttribute("kecamatan", kecamatanService.getKecamatanById(id));
		return "/kecamatan/formKecamatan";
	}
	
	@RequestMapping("/hapus/{id}")
	public String deleteDataKecamatan(@PathVariable("id") int id) {
		kecamatanService.delete(id);
		return "redirect:/kecamatan";
	}
}
