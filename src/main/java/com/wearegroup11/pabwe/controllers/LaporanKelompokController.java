package com.wearegroup11.pabwe.controllers;

import com.wearegroup11.pabwe.models.KelompokTani;
import com.wearegroup11.pabwe.models.LaporanKelompok;
import com.wearegroup11.pabwe.services.KelompokTaniService;
import com.wearegroup11.pabwe.services.LaporanKelompokService;
import com.wearegroup11.pabwe.services.UserService;
import com.wearegroup11.pabwe.storage.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;


@Controller
@RequestMapping("laporan-kelompok")
public class LaporanKelompokController {

	private StorageService storageService;
	private LaporanKelompokService laporanKelompokService;
	private KelompokTaniService kelompokTaniService;
	private UserService userService;

	@Autowired
	public void injectDependency(LaporanKelompokService laporanKelompokService, KelompokTaniService kelompokTaniService, StorageService storageService, UserService userService) {
		this.laporanKelompokService = laporanKelompokService;
		this.kelompokTaniService = kelompokTaniService;
		this.storageService = storageService;
		this.userService = userService;
	}
	
	@RequestMapping("")
	public String ListLaporanKelompok(Model model) {
		model.addAttribute("kelompokService", kelompokTaniService);
		model.addAttribute("laporanKelompok", laporanKelompokService.listLaporanKelompok());
		return "/laporan-kelompok/index-laporan-kelompok";
	}
	
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String tampilkanForm(Model model) {

		model.addAttribute("laporanKelompok", new LaporanKelompok());
		return "/laporan-kelompok/formLaporanKelompok";
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String addLaporan(Model model, final @ModelAttribute(value = "laporanKelompok") @Valid LaporanKelompok laporanKelompok, BindingResult bindingResult, final @RequestParam(value = "laporan") MultipartFile uploadingFile) {
		storageService.store(uploadingFile);
		laporanKelompok.setLaporan(uploadingFile.getOriginalFilename());

		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		KelompokTani kelompokTani = userService.findByEmail(auth.getName()).getKelompokTani();
		laporanKelompok.setKelompokTani(kelompokTani);

		model.addAttribute("laporan", laporanKelompokService.saveOrUpdate(laporanKelompok));
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

	private ModelAndView getModelAndView(@RequestParam(name = "id") long id, int i) {
		ModelAndView model = new ModelAndView();
		laporanKelompokService.updateStatus(i, id);
		model.setViewName("redirect:/dashboard#laporan");
		return model;
	}

	@RequestMapping(value = {"/accept"}, method = RequestMethod.POST)
	public ModelAndView accept(@RequestParam(name = "id") long id) {
		return getModelAndView(id, 1);
	}

	@RequestMapping(value = {"/reject"}, method = RequestMethod.POST)
	public ModelAndView reject(@RequestParam(name = "id") long id) {
		return getModelAndView(id, 2);
	}
}
